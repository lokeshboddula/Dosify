package com.example.Dosify.service.impl;

import com.example.Dosify.Enum.VaccineType;
import com.example.Dosify.model.Dose2;
import com.example.Dosify.model.User;
import com.example.Dosify.service.Dose2Service;
import com.example.Dosify.transformer.Dose2Transformer;
import org.springframework.stereotype.Service;

@Service
public class Dose2ServiceImpl implements Dose2Service {
    @Override
    public Dose2 createDose2(User user, VaccineType vaccineType) {
         return Dose2Transformer.createDose2(user, vaccineType);
    }
}
