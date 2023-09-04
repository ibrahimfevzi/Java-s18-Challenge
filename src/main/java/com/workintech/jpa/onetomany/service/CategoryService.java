package com.workintech.jpa.onetomany.service;

import com.workintech.jpa.onetomany.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    Category findById(int id);
    Category save(Category category);
    void delete(Category category);
}
