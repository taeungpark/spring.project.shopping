package com.example.project.service;

import com.example.project.domain.Member;
import com.example.project.domain.Role;
import com.example.project.repository.MemberRepository;
import com.example.project.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final RoleRepository roleRepository;

    public Member addMember(String email, String password, String firstName, String lastName, String address, String phone){
        Optional<Member> optionalMember = memberRepository.findByEmail(email);
        if(optionalMember.isPresent()){
            throw new RuntimeException("already exist");
        }

        Role role = roleRepository.findByRole("USER").get();
        Member member = new Member();
        member.setEmail(email);
        member.setPassword(password);
        member.setFirstName(firstName);
        member.setLastName(lastName);
        member.setAddress(address);
        member.setPhone(phone);
        member.setRoles(Set.of(role));

        member = memberRepository.save(member);
        return member;
    }

    public Member getUser(String email){
        return memberRepository.findByEmail(email).orElseThrow();
    }

    public List<String> getRoles(Long memberId) {
        Set<Role> roles = memberRepository.findById(memberId).orElseThrow().getRoles();
        List<String> list = new ArrayList<>();
        for (Role role : roles){
            list.add(role.getRole());
        }
        return list;
    }
}
