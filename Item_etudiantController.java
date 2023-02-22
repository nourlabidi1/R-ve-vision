/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import Modele.formation.test;
import Modele.personnel.etudiant;
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
public class Item_etudiantController implements Initializable {

    @FXML
    private HBox itemC;
   @FXML
    private Label email;
    @FXML
    private Label nom;
    @FXML
    private Label prenom;
    @FXML
    private Label niveau;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
         public void setData(etudiant etudiant){
        email.setText(etudiant.get_email());
        nom.setText(etudiant.get_nom());
        prenom.setText(etudiant.get_prenom());
      niveau.setText(etudiant.getNiveau());
    }
}
