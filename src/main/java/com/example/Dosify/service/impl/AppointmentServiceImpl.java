package com.example.Dosify.service.impl;

import com.example.Dosify.Enum.DoseNo;
import com.example.Dosify.dto.requestDTO.AppointmentRequestDTO;
import com.example.Dosify.dto.responseDTO.AppointmentResponseDTO;
import com.example.Dosify.exception.DoctorNotFoundException;
import com.example.Dosify.exception.UserNotFoundException;
import com.example.Dosify.model.Doctor;
import com.example.Dosify.model.Dose1;
import com.example.Dosify.model.Dose2;
import com.example.Dosify.model.User;
import com.example.Dosify.repository.DoctorRepository;
import com.example.Dosify.repository.UserRepository;
import com.example.Dosify.service.AppointmentService;
import com.example.Dosify.service.Dose1Service;
import com.example.Dosify.service.Dose2Service;
import com.example.Dosify.transformer.DoctorTransformer;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Override
    public AppointmentResponseDTO bookAppointment(AppointmentRequestDTO appointmentRequestDTO) throws UserNotFoundException, DoctorNotFoundException {
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
            Dose2 dose2 = dose2Service.createDose2(user, appointmentRequestDTO.getVaccineType());
            user.setDose2Taken(true);
            user.setDose2(dose2);
        }

    }
}
