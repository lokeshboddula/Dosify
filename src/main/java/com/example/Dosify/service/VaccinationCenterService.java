package com.example.Dosify.service;

import com.example.Dosify.dto.requestDTO.CenterRequestDTO;
import com.example.Dosify.dto.responseDTO.CenterResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;



public interface VaccinationCenterService {
    CenterResponseDTO addCenter(CenterRequestDTO centerRequestDTO);

}
