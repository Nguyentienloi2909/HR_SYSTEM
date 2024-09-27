package com.helloIftekhar.springJwt.controller;

import com.helloIftekhar.springJwt.model.Product;
import com.helloIftekhar.springJwt.model.User;
import com.helloIftekhar.springJwt.service.CategoryService;
import com.helloIftekhar.springJwt.service.ProductService;
import com.helloIftekhar.springJwt.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin/product")

public class AdminProductController {
    public static final Logger logger = LoggerFactory.getLogger(AdminProductController.class);
    private CategoryService categoryService;
    private ProductService productService;


    @Autowired
    public AdminProductController(CategoryService categoryService, ProductService productService) {
        this.categoryService = categoryService;
        this.productService = productService;
    }
    // test postman
    @GetMapping(value="getALlSP", produces = "application/json")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = this.productService.getAllProduct();
        return ResponseEntity.ok(products);
    }

    @GetMapping(value="getProduct/{id}", produces = "application/json")
    public ResponseEntity<Product> getProductById(@PathVariable int id){
        Optional<Product> product = this.productService.findById(id);
        return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }







}
