package com.githab.cs.repository;

import java.util.List;

import com.githab.cs.model.searchParams.SearchParams;

public interface RepositoryBase<ID, T> {
    public T create(T product);
    public T update(T product);
    public T getId(T product);
    public T delete(T product);
    public List<T> search(SearchParams params);
}
