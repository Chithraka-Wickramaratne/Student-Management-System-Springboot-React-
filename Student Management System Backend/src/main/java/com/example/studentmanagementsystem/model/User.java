package com.example.studentmanagementsystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    @Id
    private int id;
    private String name;
    private String dob;
    private String address;
    private String stream;
    private String subject;
    private int mobile;
}
