package com.githab.cs.repository;

import java.util.List;

import com.githab.cs.model.ProductOffering.ProductOffering;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorySearchService extends JpaRepository<String, ProductOffering>{
    public ProductOffering searchId();
    public ProductOffering searchName();
    public ProductOffering searchLastTime();
    public List<ProductOffering> searchCategoty();
}
