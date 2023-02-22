/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Modele.formation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author LENOVO
 */
@FunctionalInterface
public interface Interface_base_de_donnees {
      final String url = "jdbc:mysql://localhost:3306/projet_java_db";
               final   String user = "root";
               final String password = "root";
                void Interface_base_de_donnees();
           default  void connexion () throws ClassNotFoundException, SQLException 
           {
           
                    String url = "jdbc:mysql://localhost:3306/projet_java_db";
            String user = "root";
            String password = "root";
       
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            if(connection!=null){
                System.out.println("Connected to the database ");
            }
            System.out.println("Connection is Successful to the database" + url);
           
           
        }
                 
            
     
           
           
    
    
}
