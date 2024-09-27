package com.helloIftekhar.springJwt.service;


import com.helloIftekhar.springJwt.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getALl();
    Boolean create(Category catetory);
    Category findById(int id);
    Boolean update(Category category);
    Boolean delete (int id);
    List<Category> findAllByCategoryName(String categoryName);
}
