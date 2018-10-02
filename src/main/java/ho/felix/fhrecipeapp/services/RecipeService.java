package ho.felix.fhrecipeapp.services;

import ho.felix.fhrecipeapp.domain.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();
}
