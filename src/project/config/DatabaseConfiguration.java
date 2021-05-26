package project.config;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfiguration {
    private static final String dbUrl = "jdbc:mysql://localhost:3306/proiect_PAO";
    private static final String user = "root";
    private static final String password = "11111";

    private static Connection databaseConnection;

    private DatabaseConfiguration(){}

    public static Connection getDatabaseConnection(){
        try {
            if (databaseConnection == null || databaseConnection.isClosed()){
                databaseConnection = DriverManager.getConnection(dbUrl, user, password);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return databaseConnection;
    }

    public static void closeDatabaseConnection(){
        try {
            if (databaseConnection != null && !databaseConnection.isClosed()) {
                databaseConnection.close();
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
}
