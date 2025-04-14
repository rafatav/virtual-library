package services;

import entities.Category;
import repositories.CategoryRepository;

public abstract class CategoryService {

    public static Category findById(int id) {
        for (Category category : CategoryRepository.getList()) {
            if (category.getId() == id) {
                return category;
            }
        }
        return null;
    }

    public static void insert(Category category) {
        CategoryRepository.getList().add(category);
    }
}
