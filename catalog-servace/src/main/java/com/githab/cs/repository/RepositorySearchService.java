package com.githab.cs.repository;

import java.util.List;

import org.jooq.Condition;

public interface RepositorySearchService <ID, Entity>{
    public List<Entity> searchC(Condition condition);
    public List<Entity> searchAll();

}
