package com.jdbc;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

            public static void main(final String[] args) {
                testDatabase();

    }
            private static void testDatabase() {
        try {
            System.out.println("Тест связи");
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/mobile_shop";
            String login = "postgres";
            String password = "postgres";
            Connection con = DriverManager.getConnection(url, login, password);
            try {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT product_id FROM mobile_shop.public.smartphone");
                while (rs.next()) {
                    String str = rs.getString("smartphone_id = ") + ":" + rs.getString(2);
                    System.out.println("Тест:" + str);
                }
                rs.close();
                stmt.close();
            } finally {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}