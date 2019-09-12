package com.example.recipe.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.recipe.model.Recipe;
import com.example.recipe.repository.RecipeRepository;

@Service
public class RecipeService {

	@Autowired
	private RecipeRepository recipeRepository;

	public List<Recipe> getAllRecipes() {
		List<Recipe> recipes = new ArrayList<>();
		recipeRepository.findAll().forEach(recipes::add);
		return recipes;
	}

	public Optional<Recipe> getRecipe(String id) {
		return recipeRepository.findById(id);
	}

	public void addRecipe(Recipe recipe) {
		recipeRepository.save(recipe);
	}

	public void updateRecipe(Recipe recipe) {
		recipeRepository.save(recipe);
	}

	public void deleteRecipe(String id) {
		if (recipeRepository.existsById(id)) {
			recipeRepository.deleteById(id);
		}
	}

}
