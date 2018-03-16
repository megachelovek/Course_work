package dao.implementsDAO;

import dao.SmartphoneDAO;

import dao.DAO;
import model.Smartphone;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SmartphoneDAOimplements implements SmartphoneDAO{

    private DAO dao;

    public SmartphoneDAOimplements(DAO dao) {this.dao = dao;}

    @Override
    public List<Smartphone> getSmartphones() {
        List<Smartphone> shapes = new ArrayList<>();
        String query = "SELECT * FROM smartphone ORDER BY product_id";
        try (Connection connection = dao.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int product_id = resultSet.getInt(PRODUCT_ID);
                String name = resultSet.getString(NAME);
                String cpu = resultSet.getString(CPU);
                int ram = resultSet.getInt(RAM);
                int rom = resultSet.getInt(ROM);
                int color_id = resultSet.getInt(COLOR_ID);
                int shape_id = resultSet.getInt(SHAPE_ID);
                Smartphone smartphone = new Smartphone(product_id, name, cpu, ram, rom, color_id,shape_id);
                shapes.add(smartphone);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return shapes;
    }

    @Override
    public List<Smartphone> getSmartphones(int shape_id) {
        List<Smartphone> shapes = new ArrayList<>();
        String query = "SELECT * FROM smartphone WHERE shape_id=? ORDER BY product_id";
        try (Connection connection = dao.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, shape_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int product_id = resultSet.getInt(PRODUCT_ID);
                String name = resultSet.getString(NAME);
                String cpu = resultSet.getString(CPU);
                int ram = resultSet.getInt(RAM);
                int rom = resultSet.getInt(ROM);
                int color_id = resultSet.getInt(COLOR_ID);
                int shape_id1 = resultSet.getInt(SHAPE_ID);
                Smartphone smartphone = new Smartphone(product_id, name, cpu, ram, rom, color_id,shape_id1);
                shapes.add(smartphone);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return shapes;
    }

    @Override
    public Smartphone getSmartphone(String name) {
        String query = "SELECT * FROM smartphone WHERE name = ?";
        Smartphone smartphone1 = null;
        try (Connection connection = dao.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int product_id = resultSet.getInt(PRODUCT_ID);
                String name1 = resultSet.getString(NAME);
                String cpu = resultSet.getString(CPU);
                int ram = resultSet.getInt(RAM);
                int rom = resultSet.getInt(ROM);
                int color_id = resultSet.getInt(COLOR_ID);
                int shape_id1 = resultSet.getInt(SHAPE_ID);
                 smartphone1 = new Smartphone(product_id, name1, cpu, ram, rom, color_id,shape_id1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return smartphone1;
    }

    @Override
    public Smartphone getSmartphone(int product_id) {
        String query = "SELECT * FROM smartphone WHERE product_id = ?";
        Smartphone smartphone1 = null;
        try (Connection connection = dao.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, product_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int product_id1 = resultSet.getInt(PRODUCT_ID);
                String name1 = resultSet.getString(NAME);
                String cpu = resultSet.getString(CPU);
                int ram = resultSet.getInt(RAM);
                int rom = resultSet.getInt(ROM);
                int color_id = resultSet.getInt(COLOR_ID);
                int shape_id1 = resultSet.getInt(SHAPE_ID);
                smartphone1 = new Smartphone(product_id1, name1, cpu, ram, rom, color_id,shape_id1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return smartphone1;
    }

    @Override
    public void addSmartphone(Smartphone smartphone) {
        String query ="INSERT INTO smartphone (name) VALUES " + "(?,?,?,?,?,?,?)";
        try (Connection connection = dao.getConnection() ){
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, smartphone.getProduct_id());
            preparedStatement.setString(2, smartphone.getName());
            preparedStatement.setString(3, smartphone.getCpu());
            preparedStatement.setInt(4, smartphone.getRam());
            preparedStatement.setInt(5, smartphone.getRom());
            preparedStatement.setInt(6, smartphone.getShape_id());
            preparedStatement.setInt(7, smartphone.getColor_id());
            preparedStatement.execute();
        }   catch (Exception e) { e.printStackTrace();}
    }

    @Override
    public void deleteSmartphone(Smartphone smartphone) {
        String query = "DELETE smartphone WHERE product_id = ?";
        try (Connection connection = dao.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, smartphone.getProduct_id());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteSmartphone(int product_id) {
        String query = "DELETE smartphone WHERE product_id = ?";
        try (Connection connection = dao.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, product_id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateSmartphone(Smartphone smartphone) {
        String query = "UPDATE smartphone SET product_id = ?, name = ?, cpu = ?,ram = ?,rom = ?,shape_id=?,color_id=? " +
                "WHERE product_id = ?";
        try (Connection connection = dao.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, smartphone.getProduct_id());
            preparedStatement.setString(2, smartphone.getName());
            preparedStatement.setString(3, smartphone.getCpu());
            preparedStatement.setInt(4, smartphone.getRam());
            preparedStatement.setInt(5, smartphone.getRom());
            preparedStatement.setInt(6, smartphone.getShape_id());
            preparedStatement.setInt(7, smartphone.getColor_id());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
