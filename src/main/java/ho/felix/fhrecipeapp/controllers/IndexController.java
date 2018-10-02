package ho.felix.fhrecipeapp.controllers;

import ho.felix.fhrecipeapp.repositories.CategoryRepository;
import ho.felix.fhrecipeapp.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(){
        System.out.println(categoryRepository.findByDescription("Italian").get().getId());
        System.out.println(categoryRepository.findByDescription("Italian").get().getDescription());
        System.out.println(unitOfMeasureRepository.findByDescription("Cup").get().getId());
        System.out.println(unitOfMeasureRepository.findByDescription("Cup").get().getDescription());
        return "index";
    }

}
