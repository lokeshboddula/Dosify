package com.example.Dosify.transformer;

import com.example.Dosify.dto.requestDTO.UserRequestDTO;
import com.example.Dosify.dto.responseDTO.UserResponseDTO;
import com.example.Dosify.model.User;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserTransformer {
    public static User UseRequestDTOToUser(UserRequestDTO userRequestDTO) {
        return User.builder()
                .name(userRequestDTO.getName())
                .age(userRequestDTO.getAge())
                .emailId(userRequestDTO.getEmailId())
                .mobNo(userRequestDTO.getMobNo())
                .gender(userRequestDTO.getGender())
                .build();
    }
    public static UserResponseDTO UserToUserResponseDTO(User user) {
        return UserResponseDTO.builder()
                .name(user.getName())
                .message("Congrats!, Registration successful on Dosify")
                .build();
    }
}
