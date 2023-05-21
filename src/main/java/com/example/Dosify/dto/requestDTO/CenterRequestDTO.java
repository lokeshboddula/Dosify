package com.example.Dosify.dto.requestDTO;

import com.example.Dosify.Enum.CenterType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CenterRequestDTO {

    String name;

    String location;

    CenterType centerType;
}
