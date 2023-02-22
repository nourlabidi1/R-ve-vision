/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;


import Modele.personnel.user;
import Modele.formation.cours;
import Controller.Item_coursController;
import Modele.formation.notebook;
import Modele.formation.test;
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
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class Home_etudiantsController implements Initializable {
user u;
      @FXML
    private Label nom_prenom;
      @FXML
      private VBox pnItems;
    @FXML
    private Button cours ;
      @FXML
    private Button test ;
      
     
                      @FXML
    private Button btnOverview;
                             @FXML
    private Button btnSignout;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Affichage nom et prenom étudiant en haut a gauche de la page sous sa photo
        nom_prenom.setText(u.instance.getNom()+" "+u.instance.getPrenom());
       
    
        }
       
///////////////////////////////////////////////////////////////////////////////////
     @FXML
    private Button home;

    @FXML
    private Button btn_connection ;
    @FXML
    private Button Home_button ;
        public void btn_home(ActionEvent event) throws Exception{
        Stage stage = (Stage) Home_button.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        stage.setScene(new Scene(root,750,500));
        
    }
    
    public void btn_se_connecter(ActionEvent event) throws Exception{
        
        Stage stage = (Stage) btn_connection.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        stage.setScene(new Scene(root,750,500));
        
    }
    //////////////////////////////////////////////////////////


    @FXML
    private void on_btnOverview(ActionEvent event) throws IOException {
        on_click(btnOverview,test,cours,btnSignout,notebook);
        Stage stage = (Stage) btnOverview.getScene().getWindow();
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
         System.out.println(u.instance);  
        Parent root = FXMLLoader.load(getClass().getResource("Home_etudiants.fxml"));
        stage.setScene(new Scene(root,750,500));
        
    }

    @FXML
    private void on_btnSignout(ActionEvent event) throws IOException {
        on_click(btnSignout,btnOverview,test,cours,notebook);
        Stage stage = (Stage) btnSignout.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        stage.setScene(new Scene(root,750,500));
        
    }
      @FXML
    public void on_cours(ActionEvent event) throws Exception{
        on_click(cours,btnOverview,test,btnSignout,notebook);
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
    
    
    
    ////
    @FXML
    public void on_test(ActionEvent event) throws Exception{
        on_click(test,btnOverview,cours,btnSignout,notebook);
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
    private Button notebook;
     @FXML
    public void on_notebook(ActionEvent event) throws Exception{
     on_click(notebook,btnOverview,test,cours,btnSignout);
        pnItems.getChildren().clear();
         FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("item_notebook.fxml"));

                    HBox hbox=fxmlLoader.load();
                    Item_notebookController icc=fxmlLoader.getController();
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
            
            String query = "select * from notebook ;";
            Statement statement = connection.createStatement();
            ResultSet rs=statement.executeQuery(query); 
            Node node ;
            notebook notebook=new notebook();
            while(rs.next())  
            {     notebook.set_id_note(rs.getInt(1));
                notebook.set_id_cours(rs.getInt(2));
           
          
                //System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
                 fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("item_notebook.fxml"));
                try{
                     hbox=fxmlLoader.load();
                     icc=fxmlLoader.getController();
                    icc.setData(notebook);
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