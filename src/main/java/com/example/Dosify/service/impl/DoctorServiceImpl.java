package com.example.Dosify.service.impl;

import com.example.Dosify.dto.requestDTO.DoctorRequestDTO;
import com.example.Dosify.dto.responseDTO.DoctorResponseDTO;
import com.example.Dosify.exception.CenterNotPresentException;
import com.example.Dosify.model.Doctor;
import com.example.Dosify.model.VaccinationCenter;
import com.example.Dosify.repository.CenterRepository;
import com.example.Dosify.service.DoctorService;
import com.example.Dosify.transformer.DoctorTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    CenterRepository centerRepository;

    public DoctorResponseDTO addDoctor(DoctorRequestDTO doctorRequestDTO) throws CenterNotPresentException {
       Optional<VaccinationCenter> optionalVaccinationCenter =  centerRepository.findById(doctorRequestDTO.getCenterId());

       if (optionalVaccinationCenter.isEmpty()) {
            throw new CenterNotPresentException("Invalid Center!");
       }

       VaccinationCenter center = optionalVaccinationCenter.get();

       //dto -> entity
        Doctor doctor = DoctorTransformer.DoctorRequestDTOToDoctor(doctorRequestDTO);
        doctor.setVaccinationCenter(center);
        center.getDoctors().add(doctor);
        //below saves both doctor and center
        VaccinationCenter savedCenter =  centerRepository.save(center);

        return DoctorTransformer.DoctorToDoctorResponseDTO(doctor);
    }
}
