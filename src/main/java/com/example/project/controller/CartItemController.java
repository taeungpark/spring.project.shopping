package com.example.project.controller;

import com.example.project.domain.CartItem;
import com.example.project.dto.AddCartItemDto;
import com.example.project.dto.LoginInfo;
import com.example.project.service.CartItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/cartItems")
@RequiredArgsConstructor
public class CartItemController {

    private final CartItemService cartItemService;

    @PostMapping
    public CartItem addCartItem(@RequestBody AddCartItemDto addCartItemDto, HttpSession httpSession, Model model){
        LoginInfo loginInfo = (LoginInfo) httpSession.getAttribute("loginInfo");
        model.addAttribute("loginInfo", loginInfo);

        if(cartItemService.isCartItemExist(loginInfo.getMemberId(), addCartItemDto.getCartId(), addCartItemDto.getProductId())){
            CartItem cartItem = cartItemService.getCartItem(loginInfo.getMemberId(), addCartItemDto.getCartId(), addCartItemDto.getProductId());
            cartItem.setQuantity(cartItem.getQuantity() + addCartItemDto.getQuantity());
            return cartItemService.updateCartItem(cartItem);
        }
        return cartItemService.addCartItem(addCartItemDto);
    }

    @DeleteMapping("/{cartItemId}")
    public ResponseEntity deleteCartItem(HttpSession httpSession, Model model, @PathVariable Long cartItemId){
        LoginInfo loginInfo = (LoginInfo) httpSession.getAttribute("loginInfo");
        model.addAttribute("loginInfo", loginInfo);

        if(cartItemService.isCartItemExist(loginInfo.getMemberId(), cartItemId) == false) {
            return ResponseEntity.badRequest().build();
        }
        cartItemService.deleteCartItem(loginInfo.getMemberId(), cartItemId);
        return ResponseEntity.ok().build();
    }

    public List<CartItem> getCartItems(HttpSession httpSession, Model model, @RequestParam(required = false) Long cartId) {
        LoginInfo loginInfo = (LoginInfo) httpSession.getAttribute("loginInfo");
        model.addAttribute("loginInfo", loginInfo);

        if(cartId == null){
            return cartItemService.getCartItems(loginInfo.getMemberId());
        }
        return cartItemService.getCartItems(loginInfo.getMemberId(), cartId);
    }
}
