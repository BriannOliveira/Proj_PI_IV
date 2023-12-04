package com.woodpecker.backend.repository;

import com.woodpecker.backend.model.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String> {
    List<Category> findAllByUserId(String userId);
}
