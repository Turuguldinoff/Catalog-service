package com.githab.cs.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductOfferingController {
    @PostMapping(value = "/productOffering")
    public void creatProductOffering() {
        
    }

    @GetMapping(value = "/productOffering/{id}")
    public void getIdProductOffering() {
        
    }

    @PatchMapping(value = "/productOffering/{id}")
    public void upProductOffering() {
        
    }

    @DeleteMapping(value = "/productOffering/{id}")
    public void deleteProductOffering() {
        
    }

    @GetMapping(value = "/productOffering")
    public ResponseEntity <?> searchProductOffering() {
        return  ResponseEntity.ok("ok");
    }
}
