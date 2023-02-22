/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import Modele.personnel.user;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class Inscription_etudiantController implements Initializable {
        user u=user.getInstance();

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField niveau;
        @FXML
    private Button inscription;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
      @FXML
  private Button Home_button ;
      @FXML
        public void btn_home(ActionEvent event) throws Exception{
        Stage stage = (Stage) Home_button.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        stage.setScene(new Scene(root,750,500));
        
    }  
        @FXML
    public void on_valider(ActionEvent event) throws Exception {
        String var_niveau=niveau.getText();
        
        
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
            
            String query = "insert into etudiant(email,nom,prenom,mot_de_passe,niveau) values ('"+u.getEmail()+"','"+u.getNom()+"','"+u.getPrenom()+"','"+u.getMot_de_passe()+"','"+var_niveau+"');";
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
          
            Stage   stage = (Stage) inscription.getScene().getWindow();
      Parent  root = FXMLLoader.load(getClass().getResource("inscription_administrateur.fxml")); 
        stage.setScene(new Scene(root,750,500));
            
           // ResultSet rs=statement.executeQuery(query); 
            //while(rs.next())  
             //System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
            connection.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        
        System.out.println("....................................................................Inserting");
    }
    
}
