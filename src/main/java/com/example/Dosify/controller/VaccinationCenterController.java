package com.example.Dosify.controller;

import com.example.Dosify.dto.requestDTO.CenterRequestDTO;
import com.example.Dosify.dto.responseDTO.CenterResponseDTO;
import com.example.Dosify.service.VaccinationCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/center")
public class VaccinationCenterController {
    @Autowired
    VaccinationCenterService vaccinationCenterService;

    @PostMapping("/add")
    public ResponseEntity addCenter(@RequestBody CenterRequestDTO centerRequestDTO) {
        CenterResponseDTO centerResponseDTO = vaccinationCenterService.addCenter(centerRequestDTO);
        return new ResponseEntity<>(centerResponseDTO, HttpStatus.CREATED);
    }
}
