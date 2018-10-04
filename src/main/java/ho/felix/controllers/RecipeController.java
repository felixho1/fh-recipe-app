package ho.felix.controllers;

import ho.felix.domain.Recipe;
import ho.felix.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping("/recipe/show/{id}")
    public String showRecipe(@PathVariable String id, Model model) {
        Recipe recipe = recipeService.findById(new Long(id));
        model.addAttribute("recipe", recipe);
        return "recipe/show";
    }
}
