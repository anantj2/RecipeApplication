package com.example.recipe.controller;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import com.example.recipe.RecipeApplication;
import com.example.recipe.model.Recipe;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RecipeApplication.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RecipeControllerTest {

	@LocalServerPort
	int randomServerPort;

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
				.andExpect(jsonPath("$", hasSize(1))).andDo(print());
	}

	@Test
	public void verifyDeleteRecipe() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.delete("/recipes/1").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());

	}

	@Test
	public void verifyupdateRecipe() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.put("/recipes/").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest());
	}

	@Test
	public void testForAddRecipe() throws Exception {
		RestTemplate restTemplate = new RestTemplate();
		Recipe recipe = new Recipe();
		recipe.setDishType("kjhkjhk");

		RequestEntity<Recipe> requestEntity = RequestEntity
				.post(new URI("http://localhost:" + randomServerPort + "/recipes/")).body(recipe);

		ResponseEntity<Recipe> response = restTemplate.exchange(requestEntity, Recipe.class);

		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	

}
