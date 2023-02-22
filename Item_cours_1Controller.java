/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import Modele.formation.cours;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class Item_cours_1Controller implements Initializable {

    @FXML
    private HBox itemC;
    @FXML
    private Label id_cours;
    @FXML
    private Label nom_cours;
    @FXML
    private Label matiere_cours;
    @FXML
    private Button btn_supprimer_cours1;
    @FXML
   private Button btn_consulter_cours1 ;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     public void setData(cours cours){
        id_cours.setText( Integer.toString(cours.get_id_cours()));
        nom_cours.setText(cours.getNom_cours());
        matiere_cours.setText(Integer.toString(cours.get_id_matiere()));
    }
               @FXML
            public void btn_consulter_handler(ActionEvent event){
        try {
                    try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projet_java_db", "root", "root");
            if(connection!=null){
                System.out.println("Connected to the database ");
            }
            String query = "select path_file from cours where id_cours='"+id_cours.getText()+"'";
            Statement statement = connection.createStatement();
            ResultSet rs=statement.executeQuery(query); 
            System.out.println("houni");
            if(rs.next())
                System.out.println(rs.getString(1));
            
            File myObj = new File(rs.getString(1));
            if (Desktop.isDesktopSupported()) {Desktop.getDesktop().open(myObj);}

            connection.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
            
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
}
}
