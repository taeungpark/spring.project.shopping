package com.example.project.controller;

import com.example.project.domain.Member;
import com.example.project.dto.LoginInfo;
import com.example.project.dto.MemberDto;
import com.example.project.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/register")
    public ResponseEntity userRegistration(@RequestBody MemberDto memberDto) {
        String email = memberDto.getEmail();
        String password = memberDto.getPassword();
        String firstName = memberDto.getFirstName();
        String lastName = memberDto.getLastName();
        String address = memberDto.getAddress();
        String phone = memberDto.getPhone();

        memberService.addMember(email, password, firstName, lastName, address, phone);

        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody MemberDto memberDto, HttpSession httpSession){
        String email = memberDto.getEmail();
        String password = memberDto.getPassword();

        Member user = memberService.getUser(email);
        if (password.equals(user.getPassword())){
            LoginInfo loginInfo = new LoginInfo(user.getEmail(), user.getFirstName(), user.getLastName());

            List<String> roles = memberService.getRoles(user.getMemberId());
            loginInfo.setRoles(roles);

            httpSession.setAttribute("loginInfo", loginInfo);
//            System.out.println("login");
//            System.out.println(loginInfo);
        } else {
            throw new RuntimeException("wrong password");
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/logout")
    public ResponseEntity cart(HttpSession httpSession) {
        httpSession.removeAttribute("loginInfo");
//        System.out.println("logout");
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}
