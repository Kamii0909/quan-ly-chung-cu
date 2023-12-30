package edu.hust.it3180.DBconnection;

import java.sql.*;

public class DBconnection {
    public static DBconnection connection = new DBconnection();

    private Connection con;

    private DBconnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String DBUrl = "jdbc:mysql://localhost:3306/apartment_management";
            String DBUser = "root";
            String DBPassword = "12345678";
            this.con = DriverManager.getConnection(DBUrl, DBUser, DBPassword);
        } catch (Exception ignored) {
            System.out.println("Connect database failed!");
            System.exit(0);
        }
    }

    public static ResultSet executeQuery(String query) {
        try {
            Statement stm = connection.con.createStatement();
            return stm.executeQuery(query);
        } catch (Exception ignored) {

        }
        return null;
    }

}
