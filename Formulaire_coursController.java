/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import Modele.formation.cours;
import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Majdi Khalil
 */
public class Formulaire_coursController implements Initializable {
    @FXML
    private TextField form_matiere;
        @FXML
    private TextField form_nom_cours;
    @FXML
    private TextField form_fichier;
    @FXML
    private Button btn_importer_file;
    @FXML
    private Button page_precedente;
    @FXML
    private Button btn_poster_cours;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
    }    
    
    
      @FXML
    public void on_page_precedente(ActionEvent event) throws Exception{
         Stage stage = (Stage) page_precedente.getScene().getWindow();
         Parent root = FXMLLoader.load(getClass().getResource("Home_enseignant.fxml"));
                    stage.setScene(new Scene(root,1050,576));} 
        
        
    
    @FXML
    public void on_btn_poster_cours(ActionEvent event) throws Exception{
        
        System.out.println(form_matiere.getText());
        System.out.println(form_nom_cours.getText());
        System.out.println(form_fichier.getText());
        Random random = new Random();
        int nb,nb1;
        nb = random.nextInt(100);
        nb1= random.nextInt(100);
        cours cours=new cours();
        cours.set_id_cours(nb);
        cours.setNom_cours(form_nom_cours.getText());
        cours.setPath_file(form_fichier.getText());
        cours.set_id_matiere(nb1);
        cours.set_score_cours(0);
        cours.set_nbr_enregistrements(0);
            try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projet_java_db", "root", "root");

            String query = "insert cours  values ("+nb+",'"+form_nom_cours.getText()+"','"+form_fichier.getText()+"',"+nb1+","+"0"+","+"0"+");";
            System.out.println(query);
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            connection.close();

            } catch (ClassNotFoundException e) {
            e.printStackTrace();
            } catch (SQLException throwables) {
            throwables.printStackTrace();
            }
    }
    
     @FXML
    public void on_textfield_file(ActionEvent event) throws Exception{
        FileChooser fc = new FileChooser();
        //Stage stage = (Stage) btn_valider.getScene().getWindow();
        File file=fc.showOpenDialog(null);
        String file_name=file.getPath();
        //System.out.println(file_name);
        form_fichier.setText(file_name);
        
    }
    
}
