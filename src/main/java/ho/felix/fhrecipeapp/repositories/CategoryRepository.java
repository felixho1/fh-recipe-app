package ho.felix.fhrecipeapp.repositories;

import ho.felix.fhrecipeapp.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
