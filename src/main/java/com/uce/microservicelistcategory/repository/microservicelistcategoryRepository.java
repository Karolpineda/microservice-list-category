package com.uce.microserviceupdatecategory.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uce.microserviceupdatecategory.model.Category;

public interface microservicecreatecategoryRepository extends JpaRepository<Category, UUID> {
}

