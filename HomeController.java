/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Majdi Khalil
 */
public class HomeController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    
          @FXML
    private Button nous_contacter;
    @FXML
    private void on_nous_contacter(ActionEvent event) throws IOException {
        
        Stage stage = (Stage) nous_contacter.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("contact.fxml"));
        stage.setScene(new Scene(root,750,500));
        
    }
@FXML
    private Button btn_inscri;
    
       @FXML
    public void on_action_inscri(ActionEvent event) throws Exception {
        //System.out.println("Nour");
        Stage stage = (Stage) btn_inscri.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("inscription.fxml"));
        stage.setScene(new Scene(root,750,500));

    }
    @FXML
    private Button btn_conn;
    
    public void on_action_conn(ActionEvent event) throws Exception{
        Stage stage = (Stage) btn_conn.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        stage.setScene(new Scene(root,750,500));
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
