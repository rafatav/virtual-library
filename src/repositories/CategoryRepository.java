package repositories;

import entities.Category;

import java.util.LinkedList;

public abstract class CategoryRepository {

    private static LinkedList<Category> list = new LinkedList<>();

    public static LinkedList<Category> getList() {
        return list;
    }
}
