package com.githab.cs.repository;

import com.githab.cs.entity.ProductOffering.ProductOffering;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorySearchService extends JpaRepository<String, ProductOffering>{
    public ProductOffering searchId();
    public ProductOffering searchName();
    public ProductOffering searchLatTime();
    public ProductOffering searchCategoty();
}
