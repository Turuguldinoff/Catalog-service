package com.githab.cs.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CatalogController {
    @GetMapping(value = "/catalog")
    public ResponseEntity <?>  name() {
        return  ResponseEntity.ok("ok");
    }
}