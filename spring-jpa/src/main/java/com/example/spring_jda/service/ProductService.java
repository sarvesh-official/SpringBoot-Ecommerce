package com.example.spring_jda.service;

import com.example.spring_jda.model.Product;
import com.example.spring_jda.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repo ;
    public List<Product> getAllProducts(){
        return repo.findAll();
    };

    public Product getProductById(int id) {

        return repo.findById(id).orElse(null);
    }


    public Product addProduct(Product product) {
        return repo.save(product);
    }
}
