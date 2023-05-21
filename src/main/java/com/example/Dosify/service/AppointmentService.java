package com.example.Dosify.service;

import com.example.Dosify.dto.requestDTO.AppointmentRequestDTO;
import com.example.Dosify.dto.responseDTO.AppointmentResponseDTO;
import com.example.Dosify.exception.DoctorNotFoundException;
import com.example.Dosify.exception.UserNotFoundException;

public interface AppointmentService {
    public AppointmentResponseDTO bookAppointment(AppointmentRequestDTO appointmentRequestDTO) throws UserNotFoundException, DoctorNotFoundException;
}
