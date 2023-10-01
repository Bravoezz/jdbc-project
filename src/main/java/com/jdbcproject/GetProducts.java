package com.jdbcproject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GetProducts {
    Connection connection = null;
    public  GetProducts(Connection connection){
        this.connection = connection;
    }

    public List<String> getNames(){
        List<String> productNames = new ArrayList<>();
        try {
            Statement statement = this.connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM products");

            while (resultSet.next()){
                productNames.add(resultSet.getString("name"));
            }
        }catch (SQLException error){
            System.out.println("error sql ----------->");
            error.printStackTrace();
        }
        return  productNames;
    }


}
