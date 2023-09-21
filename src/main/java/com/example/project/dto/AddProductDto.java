package com.example.project.dto;

import lombok.Data;

import javax.persistence.Column;

@Data
public class AddProductDto {
    private int categoryId;

    @Column(length = 100)
    private String title;

    @Column(length = 300)
    private String description;

    @Column(length = 15)
    private Double price;

    private String imgUrl;
}
