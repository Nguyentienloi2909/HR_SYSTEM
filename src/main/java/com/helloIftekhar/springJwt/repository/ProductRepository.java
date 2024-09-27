package com.helloIftekhar.springJwt.repository;

import com.helloIftekhar.springJwt.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("select u from Product u where u.productName like %?1%")
    public List<Product> findAllProductByProductName(String productName);

}
