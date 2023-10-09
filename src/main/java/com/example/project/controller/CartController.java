package com.example.project.controller;

import com.example.project.domain.Cart;
import com.example.project.dto.LoginInfo;
import com.example.project.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;

@RestController
@RequestMapping("/carts")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @PostMapping
    public Cart addCart(HttpSession httpSession, Model model){
        LoginInfo loginInfo = (LoginInfo) httpSession.getAttribute("loginInfo");
        model.addAttribute("loginInfo", loginInfo);

        LocalDate localDate = LocalDate.now();
        int year = localDate.getYear();
        int month = localDate.getMonthValue(); // number, getMonth().toStirng() -> String
        int day = localDate.getDayOfMonth();

        String date = String.valueOf(year) + (month < 10 ? "0" : "") + String.valueOf(month) + (day < 10 ? "0" : "") + String.valueOf(day);
        Cart cart = cartService.addCart(loginInfo.getMemberId(), date);

        return cart;
    }
}
