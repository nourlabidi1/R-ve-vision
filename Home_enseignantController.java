/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import Modele.formation.cours;
import Modele.formation.test;
import Modele.personnel.user;
import java.io.IOException;
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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class Home_enseignantController implements Initializable {

   user u;
      @FXML
    private Label nom_prenom;
    @FXML
    private Button cours ;
        @FXML
    private Button statistique ;
    @FXML
      private VBox pnItems;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      nom_prenom.setText(u.instance.getNom()+" "+u.instance.getPrenom());
    }   
     @FXML
    private Button cours_b ;
     @FXML
    private Button test_b ;

@FXML
    private void on_btn_ajouter_cours(ActionEvent event)throws IOException {
        Stage stage = (Stage) cours_b.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("formulaire_cours.fxml"));
        stage.setScene(new Scene(root,612,398));
    }
    
@FXML
    private void on_btn_ajouter_test(ActionEvent event)throws IOException {
        Stage stage = (Stage) test_b.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("formulaire_test.fxml"));
        stage.setScene(new Scene(root,612,398));
    }
     @FXML
    public void on_test(ActionEvent event) throws Exception{
        on_click(test,cours,btnOverview,btnSignout,statistique);
         pnItems.getChildren().clear();
          FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("item_test.fxml"));
              
                    HBox hbox=fxmlLoader.load();
                    Item_testController icc=fxmlLoader.getController();
                  
                    pnItems.getChildren().add(hbox);
            String url = "jdbc:mysql://localhost:3306/projet_java_db";
            String user = "root";
            String password = "root";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projet_java_db", "root", "root");
            if(connection!=null){
                System.out.println("Connected to the database ");
            }
            System.out.println("Connection is Successful to the database" + url);
            
            String query = "select * from test;";
            Statement statement = connection.createStatement();
            ResultSet rs=statement.executeQuery(query); 
            Node node ;
            test test=new test();
            while(rs.next())  
            {
                test.setId_test(rs.getInt(1));
                test.setNbr_utilisateurs(rs.getInt(2));
                test.setScore(rs.getFloat(3));
                test.setId_cours((rs.getInt(4)));
             
                //System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
                 fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("item_test.fxml"));
                try{
                     hbox=fxmlLoader.load();
                     icc=fxmlLoader.getController();
                    icc.setData(test);
                    pnItems.getChildren().add(hbox);
                                    
                }
                catch(IOException e){
                    e.printStackTrace();
                    
                }
                //node =FXMLLoader.load(getClass().getResource("item_cours.fxml"));

            }
            connection.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }}
    
    
    
     @FXML
    private Button test ;
  @FXML
    public void on_cours(ActionEvent event) throws Exception{
         on_click(cours,test,btnOverview,btnSignout,statistique);
      pnItems.getChildren().clear();
         FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("item_cours_1.fxml"));

                    HBox hbox=fxmlLoader.load();
                    Item_cours_1Controller icc=fxmlLoader.getController();
          pnItems.getChildren().add(hbox);
            String url = "jdbc:mysql://localhost:3306/projet_java_db";
            String user = "root";
            String password = "root";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projet_java_db", "root", "root");
            if(connection!=null){
                System.out.println("Connected to the database ");
            }
            System.out.println("Connection is Successful to the database" + url);
            
            String query = "select * from cours;";
            Statement statement = connection.createStatement();
            ResultSet rs=statement.executeQuery(query); 
            Node node ;
            cours cours=new cours();
            while(rs.next())  
            {
                cours.set_id_cours(rs.getInt(1));
                cours.setNom_cours(rs.getString(2));
                cours.setPath_file(rs.getString(3));
                cours.set_id_matiere((rs.getInt(4)));
                cours.set_score_cours(rs.getInt(5));
                cours.set_nbr_enregistrements(rs.getInt(6));
                //System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
                 fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("item_cours_1.fxml"));
                try{
                     hbox=fxmlLoader.load();
                     icc=fxmlLoader.getController();
                    icc.setData(cours);
                    pnItems.getChildren().add(hbox);
                                    
                }
                catch(IOException e){
                    e.printStackTrace();
                    
                }
                //node =FXMLLoader.load(getClass().getResource("item_cours.fxml"));

            }
            connection.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }}
   
       @FXML
    private Button btnOverview;
    @FXML
    private void on_btnOverview(ActionEvent event) throws IOException {
         on_click(btnOverview,btnSignout,test,cours,statistique);
        Stage stage = (Stage) btnOverview.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Home_enseignant.fxml"));
        stage.setScene(new Scene(root,750,500));
        
    }
       @FXML
    private Button btnSignout;
    @FXML
    private void on_btnSignout(ActionEvent event) throws IOException {
            on_click(btnSignout,test,cours,btnOverview,statistique);
        Stage stage = (Stage) btnSignout.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        stage.setScene(new Scene(root,750,500));
        
    }
 
       private void on_click(Button b,Button c,Button d,Button e,Button f ) throws IOException{
        
     b.setStyle("  -fx-font-weight: bold;\n" +
                             "  -fx-background-color: rgb(28, 94, 116) #3f729b84 !important ;\n" +
                             "  -fx-font-size: 15;\n" +
                             "  -fx-text-fill: rgb(255, 255, 255) #3f729b84;");
 
     c.setStyle("-fx-background-color: #034f#3F729B84#034f84");
    d.setStyle("-fx-background-color: #034f#3F729B84#034f84");
       e.setStyle("-fx-background-color: #034f#3F729B84#034f84");
    f.setStyle("-fx-background-color: #034f#3F729B84#034f84");
      
  

    } 
}
