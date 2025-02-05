package com.uce.microserviceupdatecategory.controller;

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

import com.uce.microserviceupdatecategory.model.Category;
import com.uce.microserviceupdatecategory.repository.microservicecreatecategoryRepository;

@RestController
@RequestMapping("/api/categories")
public class microserviceupdateController {

    @Autowired
    private microservicecreatecategoryRepository microservicecreatecategoryRepository;

    // Endpoint Health para verificar si el microservicio está activo
    @GetMapping("/health")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("Microservicio Update Category está en funcionamient0");
    }

    // Actualizar una categoría existente
    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable UUID id, @RequestBody Category categoryDetails) {
        Optional<Category> existingCategory = microservicecreatecategoryRepository.findById(id);
        if (existingCategory.isPresent()) {
            Category category = existingCategory.get();
            // Actualizar el valor de la categoría con el nuevo nombre
            category.setName(categoryDetails.getName());
            
            // Guardar la categoría actualizada en la base de datos
            Category updatedCategory = microservicecreatecategoryRepository.save(category);
            return ResponseEntity.ok(updatedCategory);  // Devuelve la categoría actualizada
        }
        return ResponseEntity.notFound().build();  // Si la categoría no existe, devuelve un 404
    }
}

