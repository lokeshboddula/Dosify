package com.example.Dosify.transformer;

import com.example.Dosify.Enum.VaccineType;
import com.example.Dosify.model.Dose1;
import com.example.Dosify.model.User;
import lombok.experimental.UtilityClass;

import java.util.UUID;

@UtilityClass
public class Dose1Transformer {
    public static Dose1 createDose1(User user, VaccineType vaccineType) {
        return Dose1.builder()
                .doseId(String.valueOf(UUID.randomUUID()))
                .vaccineType(vaccineType)
                .user(user)
                .build();
    }
}
