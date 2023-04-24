package com.anhquan.api_ontech.services;

import com.anhquan.api_ontech.models.ProductLaptop;
import com.anhquan.api_ontech.repositorys.ProductLaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductLaptopService {
   @Autowired
    private ProductLaptopRepository repository;

    public List<ProductLaptop> getAllProducts() {
        return repository.findAll();
    }
    public ProductLaptop getProductById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public ProductLaptop createProduct(ProductLaptop product) {
        return repository.save(product);
    }

    public ProductLaptop updateProduct(Long id, ProductLaptop product) {
        ProductLaptop existingProduct = repository.findById(id).orElse(null);
        if (existingProduct == null) {
            return null;
        }
        existingProduct.setName(product.getName());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setPrice((int) product.getPrice());
        return repository.save(existingProduct);
    }

    public boolean deleteProduct(Long id) {
        ProductLaptop existingProduct = repository.findById(id).orElse(null);
        if (existingProduct == null) {
            return false;
        }
        repository.delete(existingProduct);
        return true;
    }
}
