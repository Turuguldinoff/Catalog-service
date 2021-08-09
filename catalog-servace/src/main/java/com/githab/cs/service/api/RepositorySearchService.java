package com.githab.cs.service.api;

import com.githab.cs.entity.ProductOffering.ProductOffering;

public interface RepositorySearchService{
    public ProductOffering searchId();
    public ProductOffering searchName();
    public ProductOffering searchLatTime();
    public ProductOffering searchCategoty();
}
