package com.example.Dosify.service;

import com.example.Dosify.dto.requestDTO.UserRequestDTO;
import com.example.Dosify.dto.responseDTO.UserResponseDTO;
import com.example.Dosify.model.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    public UserResponseDTO addUser(UserRequestDTO userRequestDTO);

    String getByEmailId(String emailId);

    UserResponseDTO updateNameByMobNo(String mobNo, String name);

    List<String> allUsersWithNoDoses();
}
