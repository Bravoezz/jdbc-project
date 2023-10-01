package com.jdbcproject;

import java.sql.*;

public class UpdateNames {
    Connection connection = null;
    public UpdateNames(Connection connection){
        this.connection = connection;
    }

    public Integer updateNamesById(Integer id,String nameUpdate){
        int rowsAfecteds = 0;
        try {
            String sql = "UPDATE products SET name = ? WHERE idproducts = ?";
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setString(1,nameUpdate);
            preparedStatement.setInt(2,id);
            rowsAfecteds = preparedStatement.executeUpdate();

        }catch (SQLException error){
            System.out.println(error.getMessage());
            error.printStackTrace();
        }
        return  rowsAfecteds;
    }

}
