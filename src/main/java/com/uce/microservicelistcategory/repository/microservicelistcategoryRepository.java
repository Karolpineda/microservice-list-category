package com.uce.microservicelistcategory.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uce.microservicelistcategory.model.Category;

public interface microservicelistcategoryRepository extends JpaRepository<Category, UUID> {
}

