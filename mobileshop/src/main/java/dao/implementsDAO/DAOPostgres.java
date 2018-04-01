package dao.implementsDAO;

import dao.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOPostgres extends DAO {
    public static final String DEFAULT_HOST = "localhost";
    public static final String DEFAULT_DATABASE = "mobile_shop";
    public static final String DEFAULT_LOGIN = "postgres";
    public static final String DEFAULT_PASSWORD = "postgres";
    public static final int DEFAULT_PORT = 5432;

    public DAOPostgres() {
        super("org.postgresql.Driver");
            try{Class.forName("org.postgresql.Driver");}catch (ClassNotFoundException e2) {e2.printStackTrace(); }
            }

    @Override
    public void setURL(String host, String database, int port) {
        if (database.length() > 0)
            this.url = "jdbc:postgresql://" + host + ":" + port + "/" + database;
        else
            this.url = "jdbc:postgresql://" + host + ":" + port;
    }

    @Override
    public Connection getConnection() {
        try{Class.forName("org.postgresql.Driver");}catch (ClassNotFoundException e2) {e2.printStackTrace();}
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, properties);
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }


    @Override
    public void connect(String login, String password) {
        super.connect(login, password);
    }


    // не нужен, т.к. в блоке Try автоматически закрывается соединение
    @Override
    public void closeConnection() {
        this.closeConnection();
    }
}