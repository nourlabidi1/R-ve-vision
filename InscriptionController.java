/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import Modele.personnel.user;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class InscriptionController implements Initializable {
   
     @FXML
    private ComboBox combo_box_choix;
     
   
    @FXML
    private Button btn_connection ;
      @FXML
    private Button home;

    @FXML
    private Button Home_button ;
        public void btn_home(ActionEvent event) throws Exception{
        Stage stage = (Stage) Home_button.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        stage.setScene(new Scene(root,750,500));
        
    }
        
       
      @FXML
    public void btn_se_connecter(ActionEvent event) throws Exception{
        Stage stage = (Stage) btn_connection.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        stage.setScene(new Scene(root,750,500));
        
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> list = FXCollections.observableArrayList("Etudiant","Enseignant","Administrateur");
        combo_box_choix.setItems(list);
        combo_box_choix.getSelectionModel().select(1);
    }    
   
    // enregistrement de l'utilisateur dans la base de donnees 
        @FXML
      private TextField email;
                 @FXML
      private TextField password;
                  @FXML
      private TextField nom;
                    @FXML
      private TextField prenom;
                    @FXML
      private Button valider;
             @FXML         
    public void on_valider(ActionEvent event) throws Exception {
        
        //System.out.println("Nour");
        Stage stage ;
        
      String var_email=email.getText();
       String var_password =password.getText();
      String var_nom=nom.getText();
      String var_prenom=prenom.getText();
      String choix_compte = combo_box_choix.getSelectionModel().getSelectedItem().toString();
   user u=user.getInstance();
   u.setInstance(var_email, var_email, var_nom, var_nom);
      Parent root;
      
      switch (choix_compte)
      {         
  case"Etudiant":  
     
        stage = (Stage) valider.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("inscription_etudiant.fxml"));
        stage.setScene(new Scene(root,500,500));
       break;
      
       case"Enseignant":
         
         stage = (Stage) valider.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("inscription_enseignant.fxml")); 
        stage.setScene(new Scene(root,500,500));
        break;
      case"Administrateur":
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
        String query = "insert into administrateur(email,nom,prenom,mot_de_passe) values ('"+u.getEmail()+"','"+u.getNom()+"','"+u.getPrenom()+"','"+u.getMot_de_passe()+"');";
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
                     connection.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
                
                
                //////////////////////////
         stage = (Stage) valider.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("inscription_administrateur.fxml")); 
        stage.setScene(new Scene(root,500,500));
         break;
      
        
    }
    
    
    }
    
    
    
    
    
    
    
    
    
    
}

    
    
    
    
    
 
