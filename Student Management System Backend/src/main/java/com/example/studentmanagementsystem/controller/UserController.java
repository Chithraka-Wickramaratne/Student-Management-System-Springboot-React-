package com.example.studentmanagementsystem.controller;

import com.example.studentmanagementsystem.dto.UserDTO;
import com.example.studentmanagementsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping(value = "api/v1/")

public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/getUsers")
    public List<UserDTO> getUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/saveUser")
    public UserDTO saveUser(@RequestBody UserDTO userDTO){
        return userService.saveUser(userDTO);
    }

    @PutMapping("/updateUser/{id}")
    public UserDTO updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO){
        return userService.updateUser(id, userDTO);
    }

    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id);
    }
}
