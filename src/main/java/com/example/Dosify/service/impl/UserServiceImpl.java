package com.example.Dosify.service.impl;

import com.example.Dosify.dto.requestDTO.UserRequestDTO;
import com.example.Dosify.dto.responseDTO.UserResponseDTO;
import com.example.Dosify.model.User;
import com.example.Dosify.repository.UserRepository;
import com.example.Dosify.service.UserService;
import com.example.Dosify.transformer.UserTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserResponseDTO addUser(UserRequestDTO userRequestDTO) {
        //convert requestDTO to entity
//        User user = new User();
//        user.setName(userRequestDTO.getName());
//        user.setAge(userRequestDTO.getAge());
//        user.setEmailId(userRequestDTO.getEmailId());
//        user.setMobNo(userRequestDTO.getMobNo());
//        user.setGender(userRequestDTO.getGender());
        // using builder

            User user = UserTransformer.UseRequestDTOToUser(userRequestDTO);
        User savedUser = userRepository.save(user);

//        convert entity -> responseDTO
//        userResponseDTO.setName(savedUser.getName());
//        userResponseDTO.setMessage("Congrats!, Registration successful on Dosify");

        return UserTransformer.UserToUserResponseDTO(savedUser);
    }

    @Override
    public String getByEmailId(String emailId) {
        User user = userRepository.findByEmailId(emailId);
        return user.getName();
    }

    @Override
    public UserResponseDTO updateNameByMobNo(String mobNo, String name) {

        User user = userRepository.findByMobNo(mobNo);
        user.setName(name);
        User savedUser = userRepository.save(user);

        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setName(savedUser.getName());
        userResponseDTO.setMessage("Name updation success on Dosify " + savedUser.getName());
        return userResponseDTO;
    }

    @Override
    public List<String> allUsersWithNoDoses() {
        List<String> names = new ArrayList<>();
        List<User> userList = userRepository.allUsersWithNoDoses();
        for (User user : userList)
            names.add(user.getName());

        return names;
    }
}
