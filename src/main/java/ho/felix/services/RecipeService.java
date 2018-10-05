package ho.felix.services;

import ho.felix.commands.RecipeCommand;
import ho.felix.domain.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();
    Recipe findById(Long id);
    RecipeCommand saveRecipeCommand(RecipeCommand command);
    RecipeCommand findCommandById(Long id);
    void deleteById(Long idToDelete);
}
