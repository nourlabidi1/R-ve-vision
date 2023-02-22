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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */

public class Mot_de_passe_modificationController implements Initializable {
         @FXML
    private Button Home_button ;
   @FXML
        public void btn_home(ActionEvent event) throws Exception{
        Stage stage = (Stage) Home_button.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        stage.setScene(new Scene(root,750,500));
        
    }
            @FXML
    private Button btn_connection ;
   @FXML
           public void btn_se_connecter(ActionEvent event) throws Exception{
        Stage stage = (Stage) btn_connection.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        stage.setScene(new Scene(root,750,500));
        
    }

       @FXML
    private Button btn_inscription;
       @FXML
    public void handle_btn_inscription(ActionEvent event) throws Exception {
        //System.out.println("Nour");
        Stage stage = (Stage) btn_inscription.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("inscription.fxml"));
        stage.setScene(new Scene(root,750,500));

    }
   user u=user.getInstance();
    @FXML
    private TextField email;
    @FXML
  private Label non_identiques;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        email.setText(u.getEmail());
    }    

 @FXML
    private TextField nouveau_mdp;
  @FXML
    private TextField verif_mdp;
         @FXML
    private Button valider ;
         
   @FXML
        public void on_btn_valider(ActionEvent event) throws Exception{
       
           String var_nouv_mdp=nouveau_mdp.getText();
          String var_verif_mdp =verif_mdp.getText(); 
          System.out.println(u.getEmail());
          if (var_nouv_mdp.equals(var_verif_mdp)){
        Stage stage = (Stage) valider.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        stage.setScene(new Scene(root,750,500));
          u.set_mot_de_passe(var_nouv_mdp);
          // modifier la valeur du mot de passe dans la bd
  
          
         String  var_email= u.getEmail();
         String var_password=var_verif_mdp;
         
          System.out.print("ici nouv mot de passe "+var_password);
          System.out.print("ici user "+u.getMot_de_passe());
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
            
            // verifier si le compte est un compte etudiant
            
            String query = "select * from etudiant where  email like '"+var_email+"';";
            Statement statement = connection.createStatement();
            ResultSet rs=statement.executeQuery(query); 
      
            if(rs.next()==false)  //si il n'est pas un compte etudiant
            { 
                    // verifier si le compte est un compte enseignant
                    query = "select * from enseignant where email like '"+var_email+"';";
                    statement = connection.createStatement();
                    rs=statement.executeQuery(query);
                    
                    if(rs.next()==false){ // si le compte n'est ni un compte etudiant , ni enseignanat mais un compte administrateur
                        query = "select * from administrateur where  email like '"+var_email+"';";
                        statement = connection.createStatement();
                        rs=statement.executeQuery(query); 
                        //un compte administrateur
                             if(rs.next())
                             {   query ="update administrateur set mot_de_passe='"+var_password+"' where email like '"+var_email+"';";
                                    statement = connection.createStatement();
                                   rs=statement.executeQuery(query); }
                            
                            
                                                  }
                    else{ // si le compte est compte enseignant
                         {   query ="update enseignant set mot_de_passe='"+var_password+"' where email like '"+var_email+"';";
                                    statement = connection.createStatement();
                                   rs=statement.executeQuery(query); } 
                    }
                    
                    
            }
            else{ // si il est un compte etudiant
              
                   {   query ="update etudiant set mot_de_passe='"+var_password+"' where email like '"+var_email+"';";
                                    Statement preparedStmt = connection.createStatement();
                                    // execute the java preparedstatement
                                    preparedStmt.executeUpdate(query);} 
               
         
  
                   
                   
                   
                   
                   
                   
                   
                   
                   
                   
                   
                   
            }
          
            
             connection.close();
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
          
          
          }
          else{non_identiques.setText("les 2 mot de passes donnés ne sont pas identiques !!!");}
        
    }

    
}
