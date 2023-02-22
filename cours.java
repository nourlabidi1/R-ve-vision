/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modele.formation;

import java.util.ArrayList;
import java.util.Objects;
//import java.io.File;  // Import the File class
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.*;

import java.util.Scanner;

public class cours {
private   int id_cours; 
private String nom_cours;
// fichier : le contenu 
private String path_file;
private int id_matiere;
 private  float score_cours;
 private int nbr_enregistrements;
 private  ArrayList<String> commentaires;
    private File contenu ;
 
 //*******************************************************************************************************************************
    
    
 public cours(){}
 public cours(int id_cours,int id_matiere,float score_cours,int nbr_enregistrements,String nom_cours,String path_file)
 {this.id_cours=id_cours;
 this.nom_cours=nom_cours;
 this.id_matiere=id_matiere;
 this.path_file=path_file;
 this.nbr_enregistrements=nbr_enregistrements;
 this.score_cours= score_cours;
 commentaires = new ArrayList();
 try {
     
        File contenu = new File(this.path_file);

        if (contenu.createNewFile()) {
          System.out.println("File created: " + contenu.getName());
        } else {
          System.out.println("File already exists.");
        }
      } catch (IOException e) {
        System.out.println("An error occurred.");

      }}
 
 
  //*******************************************************************************************************************************
  public void setNom_cours(String nom_cours) {
        this.nom_cours = nom_cours;
    }
 public int get_id_cours(){ return this.id_cours;}
  //public String contenu(){return this.contenu;}
   public float score_cours(){return this.score_cours;}
    public int nbr_enregistrements(){return this.nbr_enregistrements;}
    public int get_id_matiere(){return this.id_matiere;}
    public void set_id_cours(int id_cours)
    {this.id_cours=id_cours;
    }
    public ArrayList<String> get_commentaires(){return (this.commentaires);}
    
  //  public void set_contenu(String contenu)
  //  {this.contenu=contenu ;
 //   }
    
    public void set_score_cours(float score_cours)
            
    {this.score_cours=score_cours;}
     
    public void set_nbr_enregistrements(int nbre_enregistrements)
    {this.nbr_enregistrements=nbr_enregistrements;}

    public void set_id_matiere(int id_matiere)
            
    {
        this.id_matiere=id_matiere;
    }
    
    
    
     //*******************************************************************************************************************************
    
    
@Override
public String toString()
{return "Le id de ce cours est "+this.id_cours+"\n le nom de ce cours est"+this.nom_cours+"\nLa matiere de ce cours est"
        +this.id_matiere
      // +"\n le contenu de ce cours est "+this.contenu
        + "\n le score de ce cours est"+ this.score_cours+"\nle nombre d_enregistrements de ce cours est"+
        this.nbr_enregistrements+"\net le contenu du cours est\n\n\n\n"+this.afficher_cours()+ "\n\n\n Les commentaires :\n " + this.commentaires
        ;
}
   //*******************************************************************************************************************************      
  public String getNom_cours() {
        return nom_cours;
    }
  
   //*******************************************************************************************************************************
  public String recherche_cours(int cours)
{ if (this.id_cours == cours ){ return this.nom_cours;}
else  return "aucun cours trouvé";}

   
    

 //*******************************************************************************************************************************
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
        final cours other = (cours) obj;
        if (this.id_cours != other.id_cours) {
            return false;
        }
        if (this.id_matiere != other.id_matiere){
            return false;
        }
          if (this.nom_cours !=nom_cours) {
            return false;
        }
        if (Float.floatToIntBits(this.score_cours) != Float.floatToIntBits(other.score_cours)) {
            return false;
        }
        if (this.nbr_enregistrements != other.nbr_enregistrements) {
            return false;
        }
       // if (!Objects.equals(this.contenu, other.contenu)) {
       //     return false;
       // }
        return Objects.equals(this.commentaires, other.commentaires);
    }
    
     //*******************************************************************************************************************************
    public void setPath_file(String path_file) {
        this.path_file = path_file;
    }
 public void ajouter_cours(String ch) 
 {
   
     try
{
 String filename=this.path_file;
 FileWriter fw = new FileWriter(filename,true);   
 
 fw.write(ch);
 fw.close();
}
catch(IOException ioe)
{

}
     
     
     
     
     
     }                    
 //*******************************************************************************************************************************
 public String afficher_cours()
 { try
    {
      // Le fichier d'entrée
      File file = new File(this.path_file);    
      // Créer l'objet File Reader
      FileReader fr = new FileReader(file);  
      // Créer l'objet BufferedReader        
      BufferedReader br = new BufferedReader(fr);  
      StringBuffer sb = new StringBuffer();    
      String line;
      while((line = br.readLine()) != null)
      {
        // ajoute la ligne au buffer
        sb.append(line);      
        sb.append("\n");     
      }
      fr.close();    
     return (sb.toString()+"\n*********************************************************\n");  
    }
    catch(IOException e)
    {
      return "";
    }
 }



 //*******************************************************************************************************************************
public void saisie_cours()
{Scanner sc = new Scanner(System.in); 
System.out.println("\ndonner le id du cours\n");
int id_cours=sc.nextInt();
this.id_cours=id_cours;


System.out.println("\ndonner le nom du cours\n");
String nom_cours=sc.next();
this.nom_cours=nom_cours;
System.out.println("\ndonner le path du fichier du contenu du cours\n");
String path_cours=sc.next();
this.path_file=path_cours;
 String rep;
do {
 System.out.println("\ndonner le contenu du cours\n");
String ch=sc.next();   
this.ajouter_cours(ch);
 System.out.println("\nTapez oui si vous voulez ajouter du contenu , sinon tapez 'non'\n");
rep=sc.next();
}while (!rep.equals("non"));


System.out.println("\ndonner le id de la matiere\n");
int id_matiere=sc.nextInt();
this.id_matiere=id_matiere;
this.score_cours=0;
this.nbr_enregistrements=0;
this.commentaires=new ArrayList();
 System.out.println("\n cours inseré !\n");

}
}
