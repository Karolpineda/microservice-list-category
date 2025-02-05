package com.uce.microserviceupdatecategory.model;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Category {

    @Id
    private UUID id;  // Usamos UUID en lugar de String

    private String name;

    // Constructor por defecto
    public Category() {}

    // Constructor con parámetros
    public Category(String name) {
        this.name = name;
        this.id = UUID.randomUUID();  // Generar un UUID de tipo UUID
    }

    // Getters y setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
