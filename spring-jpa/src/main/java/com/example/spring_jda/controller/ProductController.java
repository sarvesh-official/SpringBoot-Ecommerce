package com.example.spring_jda.controller;

import com.example.spring_jda.model.Product;
import com.example.spring_jda.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController

@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService service;

    @RequestMapping("/")
    public String greet(){
        return "Hello the API is working";
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts(){

        return new ResponseEntity<>(service.getAllProducts(), HttpStatus.OK);

    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id){

        Product product = service.getProductById(id);

        if (product != null) return new ResponseEntity<>(service.getProductById(id),HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PostMapping("/products/addProduct")
    public ResponseEntity<Product> addProduct(@RequestBody Product product){

        return new ResponseEntity<>(service.addProduct(product),HttpStatus.ACCEPTED);
    }




    }
