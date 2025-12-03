package com.examly.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class DBConnection{
    private static final String DbName="librarydb";
    private static final String username="root";
    private static final String password="1418";
    private static final String JDBC_URL="jdbc:mysql://localhost:3306/"+DbName;

    public static Connection getConnection() throws SQLException{
       
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(JDBC_URL,username,password);
        }
        catch(ClassNotFoundException e){
            throw new SQLException("MYSQL JDBC Driver not found",e);
        }
    }
    public static void closeConnection(Connection con){
        if(con!=null){
            try{
                con.close();
            }
            catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
}