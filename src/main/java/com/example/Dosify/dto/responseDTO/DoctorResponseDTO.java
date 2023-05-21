package com.example.Dosify.dto.responseDTO;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class DoctorResponseDTO {

    String name;

    String emailId;

    String mobNo;

    CenterResponseDTO centerResponseDTO;

}
