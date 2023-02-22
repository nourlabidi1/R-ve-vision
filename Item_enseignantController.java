/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import Modele.personnel.enseignant;
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
public class Item_enseignantController implements Initializable {

    @FXML
    private HBox itemC;
    @FXML
    private Label nom;
    @FXML
    private Label prenom;
    @FXML
    private Label email;
    @FXML
    private Label etablissement;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
         public void setData(enseignant enseignant){
        email.setText(enseignant.get_email());
        nom.setText(enseignant.get_nom());
        prenom.setText(enseignant.get_prenom());
      etablissement.setText(enseignant.get_etablissement());
    } 
    
}
