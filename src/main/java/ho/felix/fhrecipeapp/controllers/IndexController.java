package ho.felix.fhrecipeapp.controllers;

import ho.felix.fhrecipeapp.repositories.CategoryRepository;
import ho.felix.fhrecipeapp.repositories.RecipeRepository;
import ho.felix.fhrecipeapp.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;
    private RecipeRepository recipeRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository, RecipeRepository recipeRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.recipeRepository = recipeRepository;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model){
//        System.out.println(categoryRepository.findByDescription("Italian").get().getId());
//        System.out.println(categoryRepository.findByDescription("Italian").get().getDescription());
//        System.out.println(unitOfMeasureRepository.findByDescription("Cup").get().getId());
//        System.out.println(unitOfMeasureRepository.findByDescription("Cup").get().getDescription());
        model.addAttribute("recipes", recipeRepository.findAll());
        return "index";
    }

}
