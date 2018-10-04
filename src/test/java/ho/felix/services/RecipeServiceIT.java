package ho.felix.services;

import ho.felix.commands.RecipeCommand;
import ho.felix.converters.RecipeCommandToRecipe;
import ho.felix.converters.RecipeToRecipeCommand;
import ho.felix.domain.Recipe;
import ho.felix.repositories.RecipeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RecipeServiceIT {
    public static final String NEW_DESCRIPTION = "New Description";

    @Autowired
    RecipeService recipeService;

    @Autowired
    RecipeRepository recipeRepository;

    @Autowired
    RecipeCommandToRecipe recipeCommandToRecipe;

    @Autowired
    RecipeToRecipeCommand recipeToRecipeCommand;

    @Test
    @Transactional
    public void saveRecipeCommand() {
        Iterable<Recipe> recipeSet = recipeRepository.findAll();
        Recipe recipe = recipeSet.iterator().next();

        recipe.setDescription(NEW_DESCRIPTION);
        RecipeCommand savedRecipeCommand = recipeService.saveRecipeCommand(recipeToRecipeCommand.convert(recipe));

        assertEquals(NEW_DESCRIPTION, savedRecipeCommand.getDescription());
        assertEquals(recipe.getId(), savedRecipeCommand.getId());
        assertEquals(recipe.getCategories().size(), savedRecipeCommand.getCategories().size());
        assertEquals(recipe.getIngredients().size(), savedRecipeCommand.getIngredients().size());

    }
}