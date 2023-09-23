package com.example.project.controller;

import com.example.project.domain.Product;
import com.example.project.dto.AddProductDto;
import com.example.project.dto.LoginInfo;
import com.example.project.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public Product addProduct(@RequestBody AddProductDto addProductDto){
        return productService.addProduct(addProductDto);
    }

    @GetMapping
    public Page<Product> getProducts(@RequestParam(required = false, defaultValue = "0") int categoryId, @RequestParam(required = false, defaultValue = "0") int page, HttpSession httpSession, Model model) {
        int size = 10;
        LoginInfo loginInfo = (LoginInfo) httpSession.getAttribute("loginInfo");
        model.addAttribute("loginInfo", loginInfo);
        if(categoryId == 0) {
            return productService.getProducts(page, size);
        } else {
            return productService.getProducts(categoryId, page, size);
        }
    }

    @GetMapping("/{id}")
    public Product getProducts(@PathVariable Long id) {
        return productService.getProduct(id);
    }

}
