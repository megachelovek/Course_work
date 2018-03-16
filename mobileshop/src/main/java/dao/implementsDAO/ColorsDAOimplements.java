package dao.implementsDAO;

import dao.ColorsDAO;

import dao.DAO;
import model.Colors;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ColorsDAOimplements implements ColorsDAO {
    private DAO dao;

    public ColorsDAOimplements(DAO dao) {this.dao = dao;}

    @Override
    public Colors getColor(int color_id) {
        String query = "SELECT * FROM colors WHERE color_id = ?";
        Colors color = null;
        try (Connection connection = dao.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, color_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int rgb = resultSet.getInt(RGB);
                int id = resultSet.getInt(COLOR_ID);
                String namec = resultSet.getString(NAME);
                color = new Colors(id,rgb,namec);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return color;
    }

    @Override
    public Colors getColor(String name) {
        String query = "SELECT * FROM colors WHERE name = ?";
        Colors color = null;
        try (Connection connection = dao.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name );
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int rgb = resultSet.getInt(RGB);
                int id = resultSet.getInt(COLOR_ID);
                String namec = resultSet.getString(NAME);
                color = new Colors(id,rgb,namec);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return color;
    }

    @Override
    public List<Colors> getColors() {
        String query = "SELECT * FROM colors ORDER BY current_standing";
        List<Colors> colors = new ArrayList<>();
        try (Connection connection = dao.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int rgb = resultSet.getInt(RGB);
                int id = resultSet.getInt(COLOR_ID);
                String name = resultSet.getString(NAME);
                Colors colors1 = new Colors(id,rgb, name);
                colors.add(colors1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return colors;
    }

    @Override
    public void addColor(Colors color) {
        String query ="INSERT INTO colors (name) VALUES " + "(?,?,?)";
        try (Connection connection = dao.getConnection() ){
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, color.getColor_id());
            preparedStatement.setInt(2, color.getRgb());
            preparedStatement.setString(3, color.getName());
            preparedStatement.execute();
        }   catch (Exception e) { e.printStackTrace();}
    }

    @Override
    public void updateColor(Colors color) {
        String query = "UPDATE colors SET color_id = ?, rgb = ?, name = ? " +
                "WHERE color_id = ?";
        try (Connection connection = dao.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, color.getColor_id());
            preparedStatement.setInt(2, color.getRgb());
            preparedStatement.setString(3,color.getName());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteColor(String name) {
        String query = "DELETE colors WHERE name = ?";
        try (Connection connection = dao.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteColor(int color_id) {
        String query = "DELETE colors WHERE color_id = ?";
        try (Connection connection = dao.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, color_id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
