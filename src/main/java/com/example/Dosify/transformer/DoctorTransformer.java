package com.example.Dosify.transformer;

import com.example.Dosify.dto.requestDTO.DoctorRequestDTO;
import com.example.Dosify.dto.responseDTO.CenterResponseDTO;
import com.example.Dosify.dto.responseDTO.DoctorResponseDTO;
import com.example.Dosify.model.Doctor;
import lombok.experimental.UtilityClass;

@UtilityClass
public class DoctorTransformer {
    public static Doctor DoctorRequestDTOToDoctor(DoctorRequestDTO doctorRequestDTO) {
        return Doctor.builder()
                .name(doctorRequestDTO.getName())
                .age(doctorRequestDTO.getAge())
                .mobNo(doctorRequestDTO.getMobNo())
                .gender(doctorRequestDTO.getGender())
                .emailId(doctorRequestDTO.getEmailId())
                .build();
    }

    public static DoctorResponseDTO DoctorToDoctorResponseDTO(Doctor doctor){
        CenterResponseDTO centerResponseDTO = VaccinationCenterTransformer.CenterToCenterResponseDTO(doctor.getVaccinationCenter());

        return DoctorResponseDTO.builder()
                .name(doctor.getName())
                .mobNo(doctor.getMobNo())
                .emailId(doctor.getEmailId())
                .centerResponseDTO(centerResponseDTO)
                .build();
    }
}
