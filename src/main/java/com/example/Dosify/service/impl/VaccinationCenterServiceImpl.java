package com.example.Dosify.service.impl;

import com.example.Dosify.dto.requestDTO.CenterRequestDTO;
import com.example.Dosify.dto.responseDTO.CenterResponseDTO;
import com.example.Dosify.model.VaccinationCenter;
import com.example.Dosify.repository.CenterRepository;
import com.example.Dosify.service.VaccinationCenterService;
import com.example.Dosify.transformer.VaccinationCenterTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VaccinationCenterServiceImpl implements VaccinationCenterService {
    @Autowired CenterRepository centerRepository;
    @Override
    public CenterResponseDTO addCenter(CenterRequestDTO centerRequestDTO) {
        VaccinationCenter vaccinationCenter = VaccinationCenterTransformer.CenterRequestDTOToCenter(centerRequestDTO);

        VaccinationCenter savedCenter =  centerRepository.save(vaccinationCenter);

        return VaccinationCenterTransformer.CenterToCenterResponseDTO(savedCenter);
    }
}
