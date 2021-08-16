package com.githab.cs.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface RepositorySearchService <ID, Entity>{
    public Entity searchId(ID id);
    public Entity searchName();
    public Entity searchLastTime();
    public List<Entity> searchCategoty();
}
