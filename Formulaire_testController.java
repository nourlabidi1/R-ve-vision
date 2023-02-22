package Controller;

import Modele.formation.cours;
import Modele.formation.test;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Formulaire_testController {

    @FXML
    private Button btn_importer_file;

    @FXML
    private TextField form_fichier;

    @FXML
    private TextField form_cours;
@FXML
    private Button poster;
    @FXML
    private Button page_precedente;
      @FXML
    public void on_page_precedente(ActionEvent event) throws Exception{
         Stage stage = (Stage) page_precedente.getScene().getWindow();
         Parent root = FXMLLoader.load(getClass().getResource("Home_enseignant.fxml"));
                    stage.setScene(new Scene(root,1050,576));} 
    
    
   
    @FXML
    public void on_btn_poster_test(ActionEvent event) throws Exception{
        
        System.out.println(form_cours.getText());
        System.out.println(form_fichier.getText());
        Random random = new Random();
        int nb;
        nb = random.nextInt(100);
        test test=new test();
        test.setId_cours(1);
        test.setPath_file(form_fichier.getText());
        test.setId_test(nb);
                test.setNbr_utilisateurs(0);
        test.setScore(0);
        
            try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projet_java_db", "root", "root");

            String query = "insert into test  values ('"+nb+"','"+0+"','"+0+"','"+1+"','"+form_fichier.getText()+"');";
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
    void on_textfield_file(ActionEvent event) {
        
                FileChooser fc = new FileChooser();
        //Stage stage = (Stage) btn_valider.getScene().getWindow();
        File file=fc.showOpenDialog(null);
        String file_name=file.getPath();
        //System.out.println(file_name);
        form_fichier.setText(file_name);
        

    }

    @FXML
    private void on_btn_poster_cours(ActionEvent event) {
    }

}