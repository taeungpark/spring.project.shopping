package com.example.project.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "role")
@NoArgsConstructor
@Data
public class Role {
    @Id
    @Column(name = "role_id")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int roleId;

    @Column(length = 15)
    private String role;

    @Override
    public String toString(){
        return "Role = {role_id = " + roleId + "role = " + role + "}";
    }
}
