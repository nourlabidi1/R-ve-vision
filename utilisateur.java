/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modele.personnel;

import Modele.formation.cours;
import Modele.formation.matiere;
import Modele.personnel.administrateur;
import Modele.personnel.enseignant;
import Modele.personnel.etudiant;
import Modele.formation.test;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
/**
 *
 * @author LENOVO
 */
import java.util.Objects;

public sealed class  utilisateur permits etudiant,administrateur,enseignant{
    private String nom;
    private String prenom;
    private String email;
    private String mot_de_passe;
     

    
       
public utilisateur(){};
        
//********************************************************************************//********************************************************************************
    
    
    public utilisateur(String nom, String prenom, String email, String mot_de_passe) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.mot_de_passe = mot_de_passe;
        
    }   
    
//********************************************************************************
    
    
    public void set_nom(String nom) {
        this.nom = nom;
    }
     
//********************************************************************************
    
       
    public String get_nom() {
        return nom;
    }
     
//********************************************************************************
    
       
    public void set_prenom(String prenom) {
        this.prenom = prenom;
    }
    
//********************************************************************************
    
    
    public String get_prenom() {
        return prenom;
    }
    
//********************************************************************************
    
    
    public String get_email() {
        return email;
    }
     
//********************************************************************************
    
       
    public void set_email(String email) {
        this.email = email;
    }
     
//********************************************************************************
    
       
    public void set_mot_de_passe(String mot_de_passe) {
        this.mot_de_passe = mot_de_passe;
    }
      
//********************************************************************************
    
      
    public String get_mot_de_passe() {
        return mot_de_passe;
    }
    
//********************************************************************************
    
    
    @Override
    public String toString() {
        return "\nLe nom est " + nom + "\nLeprenom est " + prenom + "\nLe email est " + email + "\n";
    }
       
//********************************************************************************
    
     
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
        final utilisateur other = (utilisateur) obj;
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.prenom, other.prenom)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return Objects.equals(this.mot_de_passe, other.mot_de_passe);
    }
    
//********************************************************************************
    public void set_validation(boolean c){
        //System.out.println("\n ici classe utilisateur \n");

        
    }
    
    public boolean chercher_utilisateur(ArrayList<utilisateur> t,String email, String mdp) 
    {
        for(int i=0;i<t.size();i++){
                 if((t.get(i).email==email)&&(t.get(i).mot_de_passe==mdp))
                { return true;} }
       return false;}

   
//********************************************************************************
    
      
    public void identification(ArrayList<utilisateur> t,ArrayList <matiere> m,ArrayList<cours> co,ArrayList<test> te) 
    {   
        String email;
        String mdp;
        boolean c=false;
   do{
            //saisie
            Scanner sc = new Scanner(System.in); 
            System.out.print("saisir l'email \n");
            email=sc.nextLine();
            System.out.print("saisir le mot de passe \n");
            mdp=sc.nextLine();
            for(int k=0;k<t.size();k++)
            {    
                 if((t.get(k).mot_de_passe.equals(mdp))&&(t.get(k).email.equals(email)))
                     {t.get(k).se_connecter(t,m,co,te);// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                            c=true;
                            break;
                           }
            }
            if(c==false) {System.out.print("email ou  mot de passe incorrecte , veuillez les resaisir \n");};

      
   } while(c==false);
    }
     

    
//********************************************************************************
    
    
        public void inscription(ArrayList<utilisateur> t,int c) 
        {  Scanner sc = new Scanner(System.in); 
         System.out.print("saisir le nom \n");
          String nom=sc.next();
         System.out.print("saisir le prenom \n");
          String prenom=sc.next();
         System.out.print("saisir l'email \n");
          String email=sc.next();
         System.out.print("saisir le mot de passe \n");
          String mot_de_passe=sc.next();
          
          
          if (c==1)// compte etudiant
          {  System.out.print("saisir le niveau \n");
              String niveau=sc.next();
             etudiant e=new etudiant( nom,  prenom,  email,  mot_de_passe, niveau);
              t.add(e); 
          }
            if (c==2)
          { System.out.print("saisir l'etablissement \n");
            String etablissement=sc.next();
              enseignant e=new enseignant( nom,  prenom,  email,  mot_de_passe, etablissement);
              t.add(e);
          }
              if (c==3)
          {  
              administrateur a=new administrateur( nom,  prenom,  email,  mot_de_passe);
               t.add(a);
          }
       
        }

      public void consulter_cours(ArrayList<cours> c){
          System.out.println("les cours disponibles sont: \n\n");
          for(int i=0;i<c.size();i++){
              System.out.println(c.get(i));
          }
      };
      
      public void consulter_test(ArrayList<test> t){
          System.out.println("les Test disponibles sont: \n\n");
          for(int i=0;i<t.size();i++){
              System.out.println(t.get(i));
          }
          
      };
      
      //public void reclamer_test(){};
    
//********************************************************************************
   public void se_connecter(ArrayList<utilisateur> u,ArrayList <matiere> m,ArrayList<cours> c,ArrayList<test> t)
{

          System.out.print("        BIENVENUE  "+this.get_nom()+" "+this.get_prenom()+"\n");
          System.out.print("\n  * * * * * * *   MENU  * * * * * * * * * \n");
          System.out.print("  *                                        *\n");
          System.out.print("  *      1-Consulter cours                 *\n" );
          System.out.print("  *      2-Consulter Test                  *\n");
          System.out.print("  *      3-Reclamer Test                   *\n");
          

        
}


        
//********************************************************************************
    
        
//********************************************************************************
    
        
//********************************************************************************
    
        
//********************************************************************************
    
        
//********************************************************************************
    
        
//********************************************************************************
    
    }