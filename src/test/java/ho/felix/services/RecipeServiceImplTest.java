package ho.felix.services;

import ho.felix.domain.Recipe;
import ho.felix.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class RecipeServiceImplTest {
    RecipeServiceImpl recipeService;

    @Mock
    RecipeRepository recipeRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        recipeService = new RecipeServiceImpl(recipeRepository);
    }

    @Test
    public void getRecipes() {
        // given
        HashSet<Recipe> recipes = new HashSet<>();
        Recipe recipe1 = new Recipe();
        recipe1.setId(1L);
        Recipe recipe2 = new Recipe();
        recipe2.setId(2L);
        recipes.add(recipe1);
        recipes.add(recipe2);

        when(recipeService.getRecipes()).thenReturn(recipes);

        // when
        Set<Recipe> returnedRecipes = recipeService.getRecipes();

        // then
        assertEquals(2, returnedRecipes.size());
        verify(recipeRepository, times(1)).findAll();
    }
}