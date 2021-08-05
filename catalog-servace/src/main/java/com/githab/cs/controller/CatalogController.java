package com.githab.cs.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CatalogController {
    @GetMapping(value = "/catalog")
    public BodyBuilder name() {
        return ResponseEntity.ok();
    }
}