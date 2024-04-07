package org.cydeo.service;

import com.github.javafaker.Faker;
import org.cydeo.enums.QuantityType;
import org.cydeo.enums.RecipeType;
import org.cydeo.model.Ingredient;
import org.cydeo.model.Recipe;
import org.cydeo.repository.RecipeRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Component
public class RecipeServiceImpl implements RecipeService{

    private final RecipeRepository repository;
    private final ShareService shareService;
    private final Faker faker;

    public RecipeServiceImpl(RecipeRepository repository, ShareService shareService, Faker faker) {
        this.repository = repository;
        this.shareService = shareService;
        this.faker = faker;
    }

    @Override
    public boolean prepareRecipe() {

        //create a recipe object
        Recipe recipe = new Recipe();

        //set fields
        recipe.setRecipeId(UUID.randomUUID());
        recipe.setName(faker.food().dish());
        recipe.setDuration(generateRandomValue());
        recipe.setPreparation(faker.lorem().paragraph(5));
        recipe.setRecipeType(RecipeType.BREAKFAST);
        recipe.setIngredients(prepareIngredients());

        //save the recipe
        repository.save(recipe);

        //shareRecipe
        shareService.shareService(recipe);

        return true;
    }

    private List<Ingredient> prepareIngredients() {
        //create a list
        List<Ingredient> ingredientList = new ArrayList<>();

        //fill the list with random ingredients
        for (int i=0; i < generateRandomValue(); i++){
            Ingredient ingredient = new Ingredient();
            ingredient.setName(faker.food().ingredient());
            ingredient.setQuantity(generateRandomValue());
            ingredient.setQuantityType(QuantityType.TBSP);

            ingredientList.add(ingredient);
        }

        return ingredientList;
    }

    private int generateRandomValue(){
        return new Random().nextInt(20)+1;
    }
}
