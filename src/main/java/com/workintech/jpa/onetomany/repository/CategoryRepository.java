package com.workintech.jpa.onetomany.repository;

import com.workintech.jpa.onetomany.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
