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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class LoginController implements Initializable {
   user u=user.getInstance();
    /**
     * Initializes the controller class.
     */
   
       @FXML
    private Button btn_inscription;
   @FXML
    private Button btn_se_connecter;
        @FXML
        private TextField email;
        @FXML
        private TextField password;
        @FXML
        private Button mdp_oublie;
        @FXML
        private Label email_introuv;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    @FXML
    public void handle_btn_se_connecter(ActionEvent event) throws Exception {
            if  (email.getText().equals("")){ 
                email_introuv.setText("tapez  votre email !!!");
            }
           
            else {
                
              
              if ( password.getText().equals(""))   
                { 
                email_introuv.setText("tapez  votre mot de passe ou cliquez sur mot de passe oublié !!!");
            }
                
                
        System.out.println("Nour");
        Stage stage = (Stage) btn_inscription.getScene().getWindow();
        
      String var_email=email.getText();
    
      String var_password =password.getText();
       boolean c=false;
//////////////////////////////////////////////////////////////// 

    System.out.println("nonnnnnnnnnnnnnnnnnnnnnnnnnn §§§§§§");
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
                            if(rs.next()==false){
                                // si le compte n'existe pas
                                c=true;
                               email_introuv.setText("le compte n'est pas trouvé !!! ");
                                                    }
                            else{
                                 do{
                  //  System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
                 
               //  u.instance.getInstance();
                u.setInstance(rs.getString(1),rs.getString(4),rs.getString(2),rs.getString(3));
                //  System.out.println("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
                  System.out.println(u);  
                  connection.close();
                    if (var_password.equals(u.getMot_de_passe())){
                     Parent root = FXMLLoader.load(getClass().getResource("Home_administrateur.fxml"));
                    stage.setScene(new Scene(root,1050,576));}
                    else {email_introuv.setText("mot de passe incorrecte!!!");}
                }while(rs.next());
                            
                            }
                                                  }
                    else{ // si le compte est compte enseignant
                         u.setInstance(rs.getString(1),rs.getString(4),rs.getString(2),rs.getString(3));
                       // System.out.println("ici enseignant");
                       System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
                        connection.close();
                         if (var_password.equals(u.getMot_de_passe())){
                        Parent root = FXMLLoader.load(getClass().getResource("Home_enseignant.fxml"));
                        stage.setScene(new Scene(root,1050,576));}
                         else {email_introuv.setText("mot de passe incorrecte!!!");}
                    }
                    
                    
            }
            else{ // si il est un compte etudiant
                do{
                  //  System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
                 
               //  u.instance.getInstance();
                u.setInstance(rs.getString(1),rs.getString(4),rs.getString(2),rs.getString(3));
                //  System.out.println("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
                  System.out.println(u);  
                  connection.close();
                    if (var_password.equals(u.getMot_de_passe())){
                     Parent root = FXMLLoader.load(getClass().getResource("Home_etudiants.fxml"));
                    stage.setScene(new Scene(root,1050,576));}
                    else {email_introuv.setText("mot de passe incorrecte!!!");}
                }while(rs.next());
            }
          
            
             connection.close();
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        
            }
    }
        
        
//////////////////////////////////////////////////////////////// 
      
    

    
    
     @FXML
    private Button Home_button ;
   @FXML
        public void btn_home(ActionEvent event) throws Exception{
        Stage stage = (Stage) Home_button.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        stage.setScene(new Scene(root,650,576));
        
    }

    
       @FXML
    public void handle_btn_inscription(ActionEvent event) throws Exception {
        //System.out.println("Nour");
        Stage stage = (Stage) btn_inscription.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("inscription.fxml"));
        stage.setScene(new Scene(root,1050,576));

    }

    public void on_mdp_oublie(ActionEvent event) throws Exception {
        //System.out.println("Nour");
        handle_btn_se_connecter( event);
        if( password.getText().equals("")&& !email.getText().equals(""))
        { Stage stage = (Stage) mdp_oublie.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("mot_de_passe_oublié.fxml"));
        stage.setScene(new Scene(root,1050,576));}
        else {email_introuv.setText("tapez  votre email ");}
        

    }
}
