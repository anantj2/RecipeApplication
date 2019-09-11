package com.example.recipe.controller;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.recipe.RecipeApplication;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RecipeApplication.class)
@SpringBootTest
public class RecipeControllerTest {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext wac;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();

	}
	@Test
	public void verifyAllRecipeList() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/recipes").accept(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$", hasSize(0))).andDo(print());
	}
	@Test
	public void verifyDeleteRecipe() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.delete("/recipes/1").accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
		
	}
	@Test
	public void verifyupdateRecipe() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.put("/recipes/1").accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isBadRequest());
	}

}
