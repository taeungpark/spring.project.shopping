package com.example.project.service;

import com.example.project.domain.Category;
import com.example.project.domain.Product;
import com.example.project.dto.AddProductDto;
import com.example.project.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final CategoryService categoryService;
    private final ProductRepository productRepository;
    @Transactional
    public Product addProduct(AddProductDto addProductDto) {
        Category category = categoryService.getCategory(addProductDto.getCategoryId());
        Product product = new Product();
        product.setTitle(addProductDto.getTitle());
        product.setDescription(addProductDto.getDescription());
        product.setPrice(addProductDto.getPrice());
        product.setImgUrl(addProductDto.getImgUrl());
        product.setCategory(category);

        return productRepository.save(product);
    }

    @Transactional(readOnly = true)
    public Page<Product> getProducts(int categoryId, int page, int size){
        return productRepository.findProductByCategory_id(categoryId, PageRequest.of(page, size));
    }

    @Transactional(readOnly = true)
    public Page<Product> getProducts(int page, int size){
        return productRepository.findAll(PageRequest.of(page, size));
    }

    @Transactional(readOnly = true)
    public Product getProduct(Long productId){
        return productRepository.findById(productId).orElseThrow();
    }
}
