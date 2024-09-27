package com.helloIftekhar.springJwt.repository;

import com.helloIftekhar.springJwt.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    @Query("select u from Category u where u.categoryName like %?1%")
    List<Category> findAllByCategoryName(String categoryName);
}
