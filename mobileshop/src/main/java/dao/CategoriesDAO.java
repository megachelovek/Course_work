package dao;

import model.Categories;

import java.sql.Date;
import java.util.List;

public interface CategoriesDAO {
    String CATEGORY_ID = "category_id";

    String NAME = "name";


    void addCategory(Categories category);

    List<Categories> getCategories();

    Categories getCategory(String name);

    Categories getCategory(int category_id);

    void updateCategory(Categories category);

    void deleteCategory(Categories category);

    void deleteCategory(int category_id);
}