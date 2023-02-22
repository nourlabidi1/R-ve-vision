/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modele.formation;
//notebook collectif à revoir lideee 
import java.io.File;  // Import the File class
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
 import java.io.*;
import java.util.Scanner;
import java.util.Objects;

public class notebook {
  private int   id_note ;
      private int id_cours ;
     private  String path_file;
   private File contenu ;
   
       public notebook(){}
    public notebook(int id_note, int id_cours,String path_file) {
        this.id_note = id_note;
        this.id_cours = id_cours;
        this.path_file=path_file;
         
        try {
         
        File f = new File(this.path_file);
        //File myObj = new File("filename.txt");
        if (f.createNewFile()) {
          System.out.println("File created: " + f.getName());
        } else {
          System.out.println("File already exists.");
        }
      } catch (IOException e) {
        System.out.println("An error occurred.");

      }
             
    }

  

    public String get_path_file() {
        return path_file;
    }

    public int get_id_note() {
        return id_note;
    }

    public int get_id_cours() {
        return id_cours;
    }

    public void set_id_cours(int id_cours) {
        this.id_cours = id_cours;
    }
     public void set_id_cours(String path_file) {
        this.path_file = path_file;
    }

    public void set_id_note(int id_note) {
        this.id_note = id_note;
    }



    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final notebook other = (notebook) obj;
        if (this.id_note != other.id_note) {
            return false;
        }
        if (this.id_cours != other.id_cours) {
            return false;
        }
           if (this.path_file != other.path_file) {
            return false;
        }
        
        return Objects.equals(this.contenu, other.contenu);
    }


    @Override
    public String toString() {

        return "L'identifiant de ce notebook "  + id_note + " \n La matiere de ce notebook" + 
                "\n le nom du cours est "+this.id_cours +"\n le contenu du notebook est "+afficher_contenu();
    }
   //*******************************************************************************************************************************  
  
   public void ajouter_resume(String ch) {
         try
{
 String filename=this.path_file;
 FileWriter fw = new FileWriter(filename,true);   
 
 fw.write(ch);
 fw.close();
}
catch(IOException ioe)
{

} }
 //*******************************************************************************************************************************  

 public String afficher_contenu()
 { try {   Path fileName = Path.of(
            this.path_file);
        String file_content = Files.readString(fileName);
return file_content
       ; 
 } catch (IOException e) {
        return "An error occurred.";
}
 }
   
   
   
   
   
   
 //*******************************************************************************************************************************  
   
public void supprimer_resume (String resume)
{     }



}