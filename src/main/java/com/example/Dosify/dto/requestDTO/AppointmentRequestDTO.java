package com.example.Dosify.dto.requestDTO;

import com.example.Dosify.Enum.DoseNo;
import com.example.Dosify.Enum.VaccineType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class AppointmentRequestDTO {
    DoseNo doseNo;
    int doctorId;
    int userId;
    VaccineType vaccineType;
}
