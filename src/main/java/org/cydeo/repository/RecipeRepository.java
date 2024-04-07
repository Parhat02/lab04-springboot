package org.cydeo.repository;

import org.cydeo.model.Recipe;

public interface RecipeRepository {

    boolean save(Recipe recipe);
}
