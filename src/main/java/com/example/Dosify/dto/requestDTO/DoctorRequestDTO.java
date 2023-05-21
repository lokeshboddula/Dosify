package com.example.Dosify.dto.requestDTO;

import com.example.Dosify.Enum.Gender;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class DoctorRequestDTO {

    String name;

    int age;

    String emailId;

    String mobNo;

    Gender gender;

    int centerId;
}
