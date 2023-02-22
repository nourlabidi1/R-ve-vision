/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package Controller;

import javafx.scene.image.Image;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Projet_MVC_FX extends Application {
        private double x, y;
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        primaryStage.setScene(new Scene(root));
          primaryStage.getIcons().add(new Image(Projet_MVC_FX.class.getResourceAsStream("kk.png"))); 
        primaryStage.setTitle("Rêve&Vision");
        //set stage borderless
        //2
        //primaryStage.initStyle(StageStyle.UNDECORATED);
        //drag it here
        root.setOnMousePressed(event -> {
            x = event.getSceneX();
            y = event.getSceneY();
        });
        root.setOnMouseDragged(event -> {

            primaryStage.setX(event.getScreenX() - x);
            primaryStage.setY(event.getScreenY() - y);
        });
        //1 
        primaryStage.show();
 
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
 
        
        launch(args);
    }
    
}
