package com.uce.microservicelistcategory.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uce.microservicelistcategory.model.Category;
import com.uce.microservicelistcategory.repository.microservicelistcategoryRepository;

@RestController
@RequestMapping("/api/categories")
public class microservicelistController {

    @Autowired
    private microservicelistcategoryRepository microservicelistcategoryRepository;

    // Endpoint Health para verificar si el microservicio está activo
    @GetMapping("/health")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("Microservicio LIST Category está en funcionamiento");
    }

    // Endpoint para listar todas las categorías
    @GetMapping("/list")
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categories = microservicelistcategoryRepository.findAll();
        if (categories.isEmpty()) {
            return ResponseEntity.noContent().build();  // Si no hay categorías, devuelve 204 No Content
        }
        return ResponseEntity.ok(categories);  // Devuelve la lista de categorías
    }

}
