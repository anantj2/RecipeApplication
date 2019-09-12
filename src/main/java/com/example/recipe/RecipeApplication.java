package com.example.recipe;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class RecipeApplication implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(RecipeApplication.class);

	@Override
	public void run(String... args) throws Exception {
		logger.info("\n----Begin logging RecipesServiceApplication----");

		logger.info("----System Properties from VM Arguments----");
		logger.info("server.port: " + System.getProperty("server.port"));
		logger.info("----End logging RecipesServiceApplication----");
	}

	public static void main(String[] args) {
		SpringApplication.run(RecipeApplication.class, args);
	}

}
