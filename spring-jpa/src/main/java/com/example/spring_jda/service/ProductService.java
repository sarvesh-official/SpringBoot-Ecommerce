package com.example.spring_jda.service;

import com.example.spring_jda.model.Product;
import com.example.spring_jda.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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


    public Product addProduct(Product product, MultipartFile imageFile) throws IOException {
        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        product.setImageData(imageFile.getBytes());
        return repo.save(product);
    }

    public Product updateProduct(int id, Product product, MultipartFile imageFile) throws IOException  {
        product.setImageData(imageFile.getBytes());
        product.setImageType(imageFile.getContentType());
        product.setImageName(imageFile.getOriginalFilename());
        return repo.save(product);

    }


    public void deleteProduct(int id) {
        repo.deleteById(id);
    }

    public List<Product> searchProducts(String keyword) {
            return repo.searchProducts(keyword);
    }
}
