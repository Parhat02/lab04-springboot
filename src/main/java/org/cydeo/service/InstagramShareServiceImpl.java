package org.cydeo.service;

import org.cydeo.model.Recipe;
import org.springframework.stereotype.Component;

@Component
public class InstagramShareServiceImpl implements ShareService{
    @Override
    public boolean shareService(Recipe recipe) {
        System.out.println("Shared on Instagram!");
        System.out.println("RecipeType: " + recipe.getRecipeType());
        System.out.println("Recipe Name: " + recipe.getName());
        System.out.println("Recipe Duration: " + recipe.getDuration());
        System.out.println("Ingredient List: ");

        recipe.getIngredients().forEach(ingredients ->
                System.out.println("    Ingredient Name: " + ingredients.getName() + " Quantity: " +
                        ingredients.getQuantity() + " " + ingredients.getQuantityType())
        );

        System.out.println("Preparation: \n" + "\t" + recipe.getPreparation());

        return true;
    }
}
