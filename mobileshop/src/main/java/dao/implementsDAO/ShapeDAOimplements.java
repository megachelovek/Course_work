package dao.implementsDAO;

import dao.ShapeDAO;

import dao.DAO;
import model.Shape;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShapeDAOimplements implements ShapeDAO{
    private DAO dao;

    public ShapeDAOimplements(DAO dao) {this.dao = dao;}

    @Override
    public void addShape(Shape shape) {
        String query ="INSERT INTO shape (name) VALUES " + "(?,?,?,?)";
        try (Connection connection = dao.getConnection() ){
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, shape.getShape_id());
            preparedStatement.setInt(2, shape.getWidth());
            preparedStatement.setInt(3, shape.getHeight());
            preparedStatement.setInt(3, shape.getWeight());
            preparedStatement.execute();
        }   catch (Exception e) { e.printStackTrace();}
    }

    @Override
    public List<Shape> getShapes() {
        List<Shape> shapes = new ArrayList<>();
        String query = "SELECT * FROM shape ORDER BY shape_id";
        try (Connection connection = dao.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int shape_id = resultSet.getInt(SHAPE_ID);
                int width = resultSet.getInt(WIDTH);
                int height = resultSet.getInt(HEIGHT);
                int weight = resultSet.getInt(WEIGHT);
                Shape shape = new Shape(shape_id, width, height, weight);
                shapes.add(shape);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return shapes;
    }

    @Override
    public Shape getShape(int shape_id) {
        String query = "SELECT * FROM shape WHERE shape_id = ?";
        Shape shape1 = null;
        try (Connection connection = dao.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, shape_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int shape_id1 = resultSet.getInt(SHAPE_ID);
                int width = resultSet.getInt(WIDTH);
                int height = resultSet.getInt(HEIGHT);
                int weight = resultSet.getInt(WEIGHT);
                shape1 = new Shape(shape_id1, width, height, weight);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return shape1;
    }

    @Override
    public void deleteShape(int shape_id) {
        String query = "DELETE shape WHERE shape_id = ?";
        try (Connection connection = dao.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, shape_id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateShape(Shape shape) {
        String query = "UPDATE shape SET shape_id = ?, width = ?, height = ?,weight = ? " +
                "WHERE shape_id = ?";
        try (Connection connection = dao.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, shape.getShape_id());
            preparedStatement.setInt(2, shape.getWidth());
            preparedStatement.setInt(3,shape.getHeight());
            preparedStatement.setInt(4,shape.getWeight());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
