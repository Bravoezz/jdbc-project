package com.jdbcproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {
    private static String urlConnection = "jdbc:mysql://localhost:3306/jdbc?serverTimezone=UTC";
    private static String userName = "root";
    private static String password = "toor";
    private static Connection connection = null;


    public  static Connection getConnection(){
        try {
            connection = DriverManager.getConnection(urlConnection,userName,password);
        }catch (SQLException error){
            System.out.println("Ocurrio un error en la coneccion");
            error.printStackTrace();
        }
        return  connection;
    }
}
