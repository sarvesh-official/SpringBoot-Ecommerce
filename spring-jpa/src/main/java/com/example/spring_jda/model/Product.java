package com.example.spring_jda.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String brand;
    private BigDecimal price;
    private String category;

    private Date releaseDate;
    private int quantity;
    private boolean available;

    private String imageName;
    private String imageType;
    @Lob
    private byte[] imageData;


    public void getImageName(String originalFilename) {
        this.imageName = originalFilename;
    }
}
