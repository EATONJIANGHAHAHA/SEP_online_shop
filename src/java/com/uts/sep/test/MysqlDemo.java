/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uts.sep.test;

import com.mysql.jdbc.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
/**
 *
 * @author lzy
 */
public class MysqlDemo {
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost:3306/sep";
       static final String USER = "root";
   static final String PASS = "123456";
    
    public static void main(String[] args){
           Connection conn = null;
           Statement stmt = null;
     try{
         Class.forName("com.mysql.jdbc.Driver");
         System.out.println("Connecting to database...");
        conn = DriverManager.getConnection(DB_URL,USER,PASS);
       System.out.println("Creating statement...");
      stmt = conn.createStatement();
     String sql;
     sql = "SELECT * FROM customer_tbl";
     ResultSet rs = stmt.executeQuery(sql);
     
     while(rs.next()){
     int id = rs.getInt("customer_id");
     String name = rs.getString("customer_name");
     
     System.out.print("ID: " + id);
     System.out.print("name: " + name);
     }
     
      rs.close();
      stmt.close();
      conn.close();
     
     }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
     }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
     }
        
        
     }
}
