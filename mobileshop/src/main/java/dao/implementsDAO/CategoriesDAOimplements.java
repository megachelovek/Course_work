package dao.implementsDAO;

import dao.DAO;
import dao.CategoriesDAO;
import model.Categories;
import org.postgresql.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public  class CategoriesDAOimplements implements CategoriesDAO{
    private DAO dao;

    public CategoriesDAOimplements(DAO dao) {
        this.dao = dao;
    }

    public void addCategory(Categories category) {
        String query = "INSERT INTO categories (name) VALUES " +
                "(?)";
        try (Connection connection = dao.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, category.getName());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Categories getCategory(String name) {
        //String query = "SELECT * FROM categories WHERE name = ?";
        Categories category = new Categories();
        ResultSet resultSet = dao.execSQL(String.format("SELECT * FROM categories WHERE name = '%1$s'",name));
        try {
            while (resultSet.next())
            {
                int id = resultSet.getInt(CATEGORY_ID);
                String namec = resultSet.getString(NAME);
                category = new Categories(id, namec);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }

    @Override
    public Categories getCategory(int category_id) {
        String query = "SELECT * FROM categories WHERE category_id = ?";
        Categories category = null;
        try (Connection connection = dao.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, category_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt(CATEGORY_ID);
                String name = resultSet.getString(NAME);
                category = new Categories(id, name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }

    @Override
    public void updateCategory(Categories category) {
        String query = "UPDATE categories SET name = ?,category_id = ? " +
                "WHERE category_id = ?";
        try (Connection connection = dao.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, category.getName());
            preparedStatement.setInt(2, category.getCategory_id());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCategory(Categories category) {
        String query = "DELETE categories WHERE category_id = ?";
        try (Connection connection = dao.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,category.getCategory_id());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCategory(int category_id) {
        String query = "DELETE categories WHERE category_id = ?";
        try (Connection connection = dao.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,category_id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Categories> getCategories() {
        List<Categories> categories = new ArrayList<>();
        String query = "SELECT * FROM categories " ;//ORDER BY current_standing";
        try (Connection connection = dao.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(CATEGORY_ID);
                String name = resultSet.getString(NAME);
                Categories categories1 = new Categories(id, name);
                categories.add(categories1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

    public List<Categories> getAll() {
        List<Categories> CategoriesList1 = new ArrayList<>();
        ResultSet rs = dao.execSQL("select * from categories");
        Categories emp;
        try {
            while (rs.next()){
                emp = new Categories(rs.getInt("categories_id"),rs.getString("name"));
                CategoriesList1.add(emp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return CategoriesList1;
    }
}
