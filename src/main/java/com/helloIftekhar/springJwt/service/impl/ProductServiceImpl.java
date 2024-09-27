package com.helloIftekhar.springJwt.service.impl;


import com.helloIftekhar.springJwt.model.Product;
import com.helloIftekhar.springJwt.repository.ProductRepository;
import com.helloIftekhar.springJwt.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProduct() {
        return this.productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(int id) {
        return this.productRepository.findById(id);
    }

    @Override
    @Transactional
    public Product addProduct(Product product) {
        return this.productRepository.save(product);
    }

    @Override
    @Transactional
    public Boolean updateProduct(Product product) {
        try {
            this.productRepository.saveAndFlush(product);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    @Transactional
    public Boolean deleteProductById(int id) {
        try{
            this.productRepository.deleteById(id);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Product> getAllProductByProductName(String productName) {
        return this.productRepository.findAllProductByProductName(productName);
    }
}
