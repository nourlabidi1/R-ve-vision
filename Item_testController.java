/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import Modele.formation.cours;
import Modele.formation.test;
import java.net.URL;
import java.util.ResourceBundle;
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
public class Item_testController implements Initializable {

    @FXML
    private HBox itemC;
   
    @FXML
    private Label id_test;
    @FXML
    private Label id_cours;
    @FXML
    private Label nbr_utilisateurs_test;
    @FXML
    private Label score_test;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
      public void setData(test test){
        id_test.setText( Integer.toString(test.getId_test()));
        id_cours.setText( Integer.toString(test.getId_cours()));
        nbr_utilisateurs_test.setText(Integer.toString(test.getNbr_utilisateurs()));
      score_test.setText(Float.toString(test.getScore()));
    }
    
}
