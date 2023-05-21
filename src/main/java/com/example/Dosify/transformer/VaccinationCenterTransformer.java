package com.example.Dosify.transformer;

import com.example.Dosify.dto.requestDTO.CenterRequestDTO;
import com.example.Dosify.dto.responseDTO.CenterResponseDTO;
import com.example.Dosify.model.VaccinationCenter;

public class VaccinationCenterTransformer {

    public static VaccinationCenter CenterRequestDTOToCenter(CenterRequestDTO centerRequestDTO) {
        return VaccinationCenter.builder()
                .name(centerRequestDTO.getName())
                .location(centerRequestDTO.getLocation())
                .centerType(centerRequestDTO.getCenterType())
                .build();
    }

    public static CenterResponseDTO CenterToCenterResponseDTO(VaccinationCenter vaccinationCenter) {
        return CenterResponseDTO.builder()
                .name(vaccinationCenter.getName())
                .location(vaccinationCenter.getLocation())
                .centerType(vaccinationCenter.getCenterType())
                .build();
    }
}
