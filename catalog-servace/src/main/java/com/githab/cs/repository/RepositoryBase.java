package com.githab.cs.repository;

import java.util.List;

import com.githab.cs.model.searchParams.SearchParams;

public interface RepositoryBase<ID, T> {
    T create(T product);
    T update(T product, ID id);
    T getId(ID id);
    void delete(String id);
    List<T> search(SearchParams params);
}
