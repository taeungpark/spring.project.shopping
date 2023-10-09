package com.example.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
//@AllArgsConstructor
public class LoginInfo {
    private Long memberId;
    private String email;
    private String firstName;
    private String lastName;
    private List<String> roles = new ArrayList<>();

    public LoginInfo(Long memberId, String email, String firstName, String lastName) {
        this.memberId = memberId;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void addRole(String roleName){
        roles.add(roleName);
    }
}
