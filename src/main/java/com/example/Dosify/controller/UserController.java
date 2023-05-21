package com.example.Dosify.controller;

import com.example.Dosify.dto.requestDTO.UserRequestDTO;
import com.example.Dosify.dto.responseDTO.UserResponseDTO;
import com.example.Dosify.model.User;
import com.example.Dosify.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody UserRequestDTO user) {
         UserResponseDTO userResponseDTO = userService.addUser(user);
         return new ResponseEntity(userResponseDTO, HttpStatus.CREATED);
    }

    @GetMapping("/getByEmailId")
    public ResponseEntity getByEmailId(@RequestParam("emailId") String emailId) {
        String name = userService.getByEmailId(emailId);
        return new ResponseEntity<>(name, HttpStatus.ACCEPTED);
    }

    @PutMapping("/updateNameByMobNo")
    public ResponseEntity updateNameByMobNo(@RequestParam("mobNo") String mobNo, @RequestParam("name") String name) {
        UserResponseDTO userResponseDTO = userService.updateNameByMobNo(mobNo, name);
        return new ResponseEntity<>(userResponseDTO, HttpStatus.ACCEPTED);
    }

    @GetMapping("/allUsersWithNoDoses")

    public List<String> allUsersWithNoDoses() {
        return userService.allUsersWithNoDoses();
    }
}
