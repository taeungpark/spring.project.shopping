package com.example.project.repository;

import com.example.project.domain.Member;
import com.example.project.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByRole(String role);

    Optional<Role> findById(Integer integer);
}
