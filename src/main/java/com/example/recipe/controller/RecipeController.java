package com.example.recipe.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.recipe.application.RecipeService;
import com.example.recipe.model.Recipe;

@RestController
@ComponentScan(basePackages = { "com.*" })
public class RecipeController {

    @Autowired
    private RecipeService recipeservice;

    @GetMapping("/recipes")
    public List<Recipe> getAllRecipes() {
        return recipeservice.getAllRecipes();
    }

    @GetMapping("/recipes/{recipeId}")
    public Optional<Recipe> getRecipe(@PathVariable String recipeId) {
        return recipeservice.getRecipe(recipeId);
    }

    @PostMapping("/recipes")
    public void addRecipe(@RequestBody Recipe recipe) {
        recipeservice.addRecipe(recipe);
    }

    @PutMapping("/recipes/{recipeId}")
    public void updateRecipe(@PathVariable String recipeId, @RequestBody Recipe recipe) {
        recipeservice.updateRecipe(recipeId, recipe);
    }

    @DeleteMapping("/recipes/{recipeId}")
    public void deleteRecipe(@PathVariable String recipeId) {
        recipeservice.deleteRecipe(recipeId);
    }
}
