package com.example.Dosify.service.impl;

import com.example.Dosify.Enum.DoseNo;
import com.example.Dosify.dto.requestDTO.AppointmentRequestDTO;
import com.example.Dosify.dto.responseDTO.AppointmentResponseDTO;
import com.example.Dosify.dto.responseDTO.CenterResponseDTO;
import com.example.Dosify.exception.DoctorNotFoundException;
import com.example.Dosify.exception.NotEligibleForDoseException;
import com.example.Dosify.exception.UserNotFoundException;
import com.example.Dosify.model.*;
import com.example.Dosify.repository.DoctorRepository;
import com.example.Dosify.repository.UserRepository;
import com.example.Dosify.service.AppointmentService;
import com.example.Dosify.service.Dose1Service;
import com.example.Dosify.service.Dose2Service;
import com.example.Dosify.transformer.AppointmentTransformer;
import com.example.Dosify.transformer.DoctorTransformer;
import com.example.Dosify.transformer.VaccinationCenterTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    Dose1Service dose1Service;
    @Autowired
    Dose2Service dose2Service;
    @Autowired
    private JavaMailSender emailSender;
    @Override
    public AppointmentResponseDTO bookAppointment(AppointmentRequestDTO appointmentRequestDTO) throws UserNotFoundException, DoctorNotFoundException, NotEligibleForDoseException {
        Optional<User> optionalUser =  userRepository.findById(appointmentRequestDTO.getUserId());

        if(optionalUser.isEmpty()) {
            throw new UserNotFoundException("User does not exist!");
        }
        Optional<Doctor> optionalDoctor = doctorRepository.findById(appointmentRequestDTO.getDoctorId());

        if(optionalDoctor.isEmpty()) {
            throw new DoctorNotFoundException("Doctor doesn't exist!");
        }

        User user = optionalUser.get();
        Doctor doctor = optionalDoctor.get();

        if(appointmentRequestDTO.getDoseNo() == DoseNo.DOSE_1) {
            Dose1 dose1 = dose1Service.createDose1(user, appointmentRequestDTO.getVaccineType());
            user.setDose1Taken(true);
            user.setDose1(dose1);
        } else {
            if(!user.isDose1Taken()) throw new NotEligibleForDoseException("Sorry!, you are not eligible " +
                    "for Dose2 take Dose1 first!");

            Dose2 dose2 = dose2Service.createDose2(user, appointmentRequestDTO.getVaccineType());
            user.setDose2Taken(true);
            user.setDose2(dose2);
        }

        Appointment appointment = AppointmentTransformer.createAppointment(user, doctor, appointmentRequestDTO);


        user.getAppointments().add(appointment);

        User savedUser = userRepository.save(user);

        Appointment savedAppointment = savedUser.getAppointments().get(savedUser.getAppointments().size() - 1);

        doctor.getAppointments().add(savedAppointment);

        doctorRepository.save(doctor);


        //send email

        String text = "Congrats!! " + user.getName() +
                ", your appointment booked for " + savedAppointment.getDoseNo()
                + " on " + savedAppointment.getDateOfAppointment();

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("dosify.backend@gmail.com");
        message.setTo(user.getEmailId());
        message.setSubject("Appointment Booked!!");
        message.setText(text);
        emailSender.send(message);




        //create response



        CenterResponseDTO centerResponseDTO = VaccinationCenterTransformer.CenterToCenterResponseDTO(doctor.getVaccinationCenter());

        return AppointmentTransformer
                            .createResponseDTO(user, savedAppointment, doctor, appointmentRequestDTO, centerResponseDTO);

    }
}
