package com.example.project.repository;

import com.example.project.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findProductByCategory_id(int categoryId, Pageable pageable);
}
