package com.example.project.service;

import com.example.project.domain.Category;
import com.example.project.dto.AddCategoryDto;
import com.example.project.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Transactional
    public Category addCategory(AddCategoryDto addCategoryDto){
        Category category = new Category();
        category.setName(addCategoryDto.getName());

        return categoryRepository.save(category);
    }

    @Transactional(readOnly = true)
    public List<Category> getCategories(){
        return categoryRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Category getCategory(int categoryId){
        return categoryRepository.findById(categoryId).orElseThrow();
    }
}
