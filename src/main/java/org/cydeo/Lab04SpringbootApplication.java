package org.cydeo;

import com.github.javafaker.Faker;
import org.cydeo.config.RecipeCreatorConfig;
import org.cydeo.repository.RecipeRepository;
import org.cydeo.repository.RecipeRepositoryImpl;
import org.cydeo.service.RecipeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.awt.*;

@SpringBootApplication
public class Lab04SpringbootApplication {

    public static void main(String[] args) {
        ApplicationContext container = SpringApplication.run(Lab04SpringbootApplication.class, args);

        RecipeService recipeService = container.getBean(RecipeService.class);

        recipeService.prepareRecipe();

        RecipeCreatorConfig recipeCreatorConfig = container.getBean(RecipeCreatorConfig.class);
        System.out.println("recipeCreatorConfig.getFirstName() = " + recipeCreatorConfig.getFirstName());
        System.out.println("recipeCreatorConfig.getLastName() = " + recipeCreatorConfig.getLastName());

    }


//    @Bean
//    public Faker fakerBean(){
//        return new Faker();
//    }

}
