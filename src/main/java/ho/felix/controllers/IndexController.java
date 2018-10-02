package ho.felix.controllers;

import ho.felix.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class IndexController {
    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model){
        log.debug("I am inside IndexController.getIndexPage. . . .");
//        System.out.println(categoryRepository.findByDescription("Italian").get().getId());
//        System.out.println(categoryRepository.findByDescription("Italian").get().getDescription());
//        System.out.println(unitOfMeasureRepository.findByDescription("Cup").get().getId());
//        System.out.println(unitOfMeasureRepository.findByDescription("Cup").get().getDescription());
        model.addAttribute("recipes", recipeService.getRecipes());
        return "index";
    }

}
