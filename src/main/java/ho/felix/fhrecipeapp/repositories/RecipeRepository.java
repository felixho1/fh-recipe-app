package ho.felix.fhrecipeapp.repositories;

import ho.felix.fhrecipeapp.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
