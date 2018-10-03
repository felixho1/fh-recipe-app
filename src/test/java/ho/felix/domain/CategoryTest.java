package ho.felix.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CategoryTest {

    Category category;

    @Before
    public void setUp() throws Exception {
        category = new Category();
    }

    @Test
    public void getId() {
        Long idValue = 8L;
        category.setId(idValue);
        assertEquals(idValue, category.getId());
    }

    @Test
    public void getDescription() {
        String desc = "Indonesian";
        category.setDescription(desc);
        assertEquals(desc, category.getDescription());
    }

    @Test
    public void getRecipes() {
        Recipe recipe1 = new Recipe();
        recipe1.setId(1L);
        category.getRecipes().add(recipe1);
        Recipe recipe2 = new Recipe();
        recipe2.setId(2L);
        category.getRecipes().add(recipe2);
        assertEquals(2, category.getRecipes().size());
    }
}