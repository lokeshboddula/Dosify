package com.example.Dosify.controller;

import com.example.Dosify.dto.requestDTO.AppointmentRequestDTO;
import com.example.Dosify.dto.responseDTO.AppointmentResponseDTO;
import com.example.Dosify.exception.DoctorNotFoundException;
import com.example.Dosify.exception.NotEligibleForDoseException;
import com.example.Dosify.exception.UserNotFoundException;
import com.example.Dosify.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
    @Autowired
    AppointmentService appointmentService;

    @PostMapping("/book")
    public AppointmentResponseDTO bookAppointment(@RequestBody AppointmentRequestDTO appointmentRequestDTO) throws UserNotFoundException, DoctorNotFoundException, NotEligibleForDoseException {
        return appointmentService.bookAppointment(appointmentRequestDTO);
    }
}
