package com.githab.cs.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.githab.cs.model.ProductOffering.ProductOffering;
import com.githab.cs.model.searchParams.SearchParams;
import com.githab.cs.service.api.ProductOfferingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
public class ProductOfferingController {
    @Autowired
    private ProductOfferingService pro;

    @PostMapping(value = "/productOffering")
    public ResponseEntity<?> creatProductOffering(@RequestBody ProductOffering prod) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body((pro.createProductOffering(ProductOffering.convert(prod))));

    }

    @GetMapping(value = "/productOffering/{id}")
    public ResponseEntity<?> getIdProductOffering(@PathVariable String id) {
        return pro.getProductOfferingById(id).map(ProductOffering::convertD).map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PatchMapping(value = "/productOffering/{id}")
    public ResponseEntity<?> upProductOffering(@RequestBody ProductOffering prod, @PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body((pro.upProductOffering(ProductOffering.convert(prod), id)));

    }

    @DeleteMapping(value = "/productOffering/{id}")
    public ResponseEntity<?> deleteProductOffering(@PathVariable String id) {
        pro.removeProductOffering(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Удален: " + id);

    }

    @GetMapping(value = "/productOffering")
    public ResponseEntity<?> searchProductOffering(@RequestParam Map<String, String> p) {
        Map <String, List<String>> f  = new HashMap<String, List<String>>();
        Set<String> j = p.keySet();
        String[] d;
        for (String i : j) {
            List<String> o = new ArrayList<String>(); 
            d = p.get(i).split(",");
            for (String string : d) {
                o.add(string);
            }
            f.put(i, o);
        }
        SearchParams par = new SearchParams(f, 0, 4);
        return ResponseEntity.ok(pro.searchProductOffering(par)
            .stream()
            .map(ProductOffering::convertD)
            .collect(Collectors.toList()));
    }
}
