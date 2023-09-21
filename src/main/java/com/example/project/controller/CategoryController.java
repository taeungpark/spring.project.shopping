package com.example.project.controller;

import com.example.project.domain.Category;
import com.example.project.dto.AddCategoryDto;
import com.example.project.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping
    public Category addCategory(@RequestBody AddCategoryDto addCategoryDto){
        return categoryService.addCategory(addCategoryDto);
    }

    @GetMapping
    public List<Category> getAllCategories(){
        return categoryService.getCategories();
    }
}
