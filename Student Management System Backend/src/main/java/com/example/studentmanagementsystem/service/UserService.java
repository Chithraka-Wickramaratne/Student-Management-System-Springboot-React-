package com.example.studentmanagementsystem.service;

import com.example.studentmanagementsystem.dto.UserDTO;
import com.example.studentmanagementsystem.model.User;
import com.example.studentmanagementsystem.repo.UserRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    public List<UserDTO> getAllUsers() {
        List<User> userList = userRepo.findAll();
        return modelMapper.map(userList, new TypeToken<List<UserDTO>>() {}.getType());
    }

    public UserDTO saveUser(UserDTO userDTO){
        userRepo.save(modelMapper.map(userDTO, User.class));
        return userDTO;
    }

    public UserDTO updateUser(Long id, UserDTO userDTO) {

        User existingUser = userRepo.findById(Math.toIntExact(id)).orElseThrow(() -> new RuntimeException("User not found"));

        existingUser.setName(userDTO.getName());
        existingUser.setAddress(userDTO.getAddress());
        existingUser.setDob(userDTO.getDob());
        existingUser.setStream(userDTO.getStream());
        existingUser.setSubject(userDTO.getSubject());
        existingUser.setMobile(userDTO.getMobile());

        userRepo.save(existingUser);

        return modelMapper.map(existingUser, UserDTO.class);
    }


    public String deleteUser(Long id) {
        // Check if the user exists before deleting
        User user = userRepo.findById(Math.toIntExact(id)).orElseThrow(() -> new RuntimeException("User not found"));

        userRepo.delete(user);
        return "User Deleted Successfully: " + user.getName(); // You can return the user's name or ID for confirmation
    }

}
