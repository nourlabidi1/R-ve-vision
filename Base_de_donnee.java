/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author LENOVO
 */
public interface Base_de_donnee {
    
    /**
     *
     */
    default void connx_base()
  {
      String url = "jdbc:mysql://localhost:3306/projet_java_db";
            String user = "root";
            String password = "root";
            
            
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            if(connection!=null){
                System.out.println("Connected to the database ");
                
            }
            System.out.println("Connection is Successful to the database" + url);
            
          /*  String query = requete;
            Statement statement = connection.createStatement();
            ResultSet rs=statement.executeQuery(query); 
            while(rs.next())  
             System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
            connection.close();*/

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }}
}
