package utilities;

import java.sql.*;

public class DatabaseUtils {
    static String url = ConfigReader.getConfigProperty("db.url");
    static String username = ConfigReader.getConfigProperty("db.username");
    static String password = ConfigReader.getConfigProperty("db.password");
    static Connection connection;
    static Statement stmt;
    static ResultSet rs;
    public static void initializeDBProperties() {           // ONE TIME SETUP

        try {
            // Register Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // connect to DB
            connection = DriverManager.getConnection(url, username, password);
            stmt = connection.createStatement();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ResultSet executeQuery(String query){     // REUSABLE CODE
        try {
            rs = stmt.executeQuery(query);
        } catch (Exception e){
            e.printStackTrace();
        }
        return rs;
    }

    public static void closeDatabaseConnection() {          // ONE TIME SETUP
        try {
            stmt.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
