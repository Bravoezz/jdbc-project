package com.jdbcproject;


import org.w3c.dom.ls.LSOutput;

import java.sql.Connection;
import java.util.List;

public class JdbcProject {

    public static void main(String[] args) {
        try {
            Connection connection = JdbcConnection.getConnection();
            GetProducts products = new GetProducts(connection);

            products.getNames().forEach( name -> System.out.println(name));
            System.out.println("-----------------------------------------");

            UpdateNames updateNames = new UpdateNames(connection);
            Integer rowsAfected = updateNames.updateNamesById(1,"potatasos");

            if (rowsAfected == 0) {
                System.out.println("No se actualizo ninguna fila");
            }else {
                System.out.println("Se actulizo con exito");
            }

            System.out.println("-----------------------------------------");
            products.getNames().forEach(System.out::println);

            connection.close();
        }catch (Exception error){
            System.out.println(error);
        }
    }
}
