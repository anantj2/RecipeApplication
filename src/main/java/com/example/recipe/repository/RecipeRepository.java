package com.example.recipe.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.recipe.model.Recipe;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, String> {
}

