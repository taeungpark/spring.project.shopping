package com.example.project.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table (name = "memeber")
@NoArgsConstructor
@Data

public class Member {

    @Id
    @Column(name="member_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Column
    private String email;
    @Column(length = 50)
    private String password;
    @Column(length = 20)
    private String firstName;
    @Column(length = 20)
    private String lastName;
    @Column
    private String address;
    @Column(length = 15)
    private String phone;
    @CreationTimestamp
    private LocalDateTime regdate;

    @ManyToMany
    @JoinTable(name = "member_role",
            joinColumns = @JoinColumn(name = "member_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    @Override
    public String toString(){
        return "Member = {memberId = " + memberId + ", emil = " + email
                + ", password = " + password + ", firstName = " + firstName
                + ", lastName = " + lastName + ", address = " + address
                + ", phone = " + phone + ", regdate = " + regdate
                + ", roles = " + roles + "}";
    }

    public void addRole(Role role) {
        roles.add(role);
    }
}
