package com.example.Dosify.dto.responseDTO;

import com.example.Dosify.Enum.DoseNo;
import com.example.Dosify.Enum.VaccineType;
import com.example.Dosify.model.Appointment;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class AppointmentResponseDTO {

    String appointmentNo;

    Date dateOfAppointment;

    DoseNo doseNo;

    String userName;

    CenterResponseDTO centerResponseDTO;

    String doctorName;

    VaccineType vaccineType;
}
