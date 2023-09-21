package com.example.project.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "product")
@NoArgsConstructor
@Data
public class Product {
    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(length = 100)
    private String title;

    @Column(length = 300)
    private String description;

    @Column(length = 15)
    private Double price;

    private String imgUrl;

}
