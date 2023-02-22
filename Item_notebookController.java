/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import Modele.formation.notebook;
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
public class Item_notebookController implements Initializable {

    @FXML
    private HBox itemC;
  @FXML
    private Label id_notebook;
      @FXML
    private Label id_cours;
    @FXML
    private Label id;
    @FXML
    private Label email;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
          
         public void setData(notebook notebook){
        id_notebook.setText(Integer.toString(notebook.get_id_note()));
        id_cours.setText(Integer.toString(notebook.get_id_cours()));

    } 
}
