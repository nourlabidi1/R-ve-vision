/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import Modele.formation.notebook;
import Modele.personnel.reclamation;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class Item_reclamationController implements Initializable {

    @FXML
    private HBox itemC;
    @FXML
    private Label id;
    @FXML
    private Label email;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
              
         public void setData(reclamation reclamation){
        id.setText(Integer.toString(reclamation.id_reclamation()));
        id.setText(reclamation.email_reclamant());

    } 
}
