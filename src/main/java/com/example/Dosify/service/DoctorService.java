package com.example.Dosify.service;

import com.example.Dosify.dto.requestDTO.DoctorRequestDTO;
import com.example.Dosify.dto.responseDTO.DoctorResponseDTO;
import com.example.Dosify.exception.CenterNotPresentException;
import org.springframework.stereotype.Service;


public interface DoctorService {
    public DoctorResponseDTO addDoctor(DoctorRequestDTO doctorRequestDTO) throws CenterNotPresentException;
}
