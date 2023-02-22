/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modele.personnel;
import Modele.formation.cours;
import Modele.formation.matiere;
import Modele.formation.test;
import java.util.Scanner;

import java.util.ArrayList;
/**
 *
 * @author LENOVO
 */
public final class administrateur extends utilisateur{
    
    public administrateur(String nom, String prenom, String email, String mot_de_passe){
        super(nom,prenom,email,mot_de_passe);    
    }
    public administrateur(){}
    
    public void alterer_validation_enseignant(ArrayList<utilisateur> u){
        Scanner sc = new Scanner(System.in);
        System.out.println("donner l'email du compte enseignant à valider: \n");
        String email_compte_enseignant=sc.next();
        for(int i=0;i<u.size();i++){
            
            if(u.get(i).get_email().equals(email_compte_enseignant)){
                u.get(i).set_validation(true);
            }
        }
    }
    
  
    
    
      //public void consulter_cours(){}
      //public void consulter_test(){}
      public void reclamer_test(){}
      public void consulter_reclamation(){}
      
      public void supprimer_test(ArrayList<test> t ){
          Scanner sc = new Scanner(System.in);
          consulter_test(t);
          System.out.println("Insérez l'id test à supprimer");
          int id_test_a_supprimer=sc.nextInt();
          boolean trouve=false;
          for(int i=0;i<t.size();i++){
              if(t.get(i).getId_test()==id_test_a_supprimer){
                  t.remove(i);
                  System.out.println("Cours ayant l'indice"+id_test_a_supprimer+"est supprimé !");
                  trouve=true;
                  break;
              }
          }
          if (trouve==false){
            System.out.println("Aucun test ayant cet indice est trouvé !! ");
          }
      }
      
      public void supprimer_cours(ArrayList<cours> c ){
          Scanner sc = new Scanner(System.in); 
          consulter_cours(c);
          System.out.println("Insérez l'id cours à supprimer");
          int id_cours_a_supprimer=sc.nextInt();
          boolean trouve=false;
          for(int i=0;i<c.size();i++){
              if(c.get(i).get_id_cours()==id_cours_a_supprimer){
                  c.remove(i);
                  System.out.println("Cours ayant l'indice"+id_cours_a_supprimer+"est supprimé !");
                  trouve=true;
                  break;
              }
          }
          if (trouve==false){
            System.out.println("Aucun cours ayant cet indice est trouvé !! ");
          }
      }
      
        public void consulter_utilisateur(ArrayList<utilisateur> u){
            System.out.println("les utilisateurs sont: \n\n");
            for(int i=0;i<u.size();i++){
                System.out.println(u.get(i));
            }
        }
      
      public void supprimer_utilisateur(ArrayList<utilisateur> u ){
          Scanner sc = new Scanner(System.in); 
          consulter_utilisateur(u);
          System.out.println("Insérez l'email de l'utilisateur à supprimer");
          String email_utilisateur_a_supprimer=sc.next();
          boolean trouve=false;
          administrateur dummy_user=new administrateur();
          for(int i=0;i<u.size();i++){
              if(u.get(i).get_email().equals(email_utilisateur_a_supprimer)){
                  if(u.get(i).getClass().equals(dummy_user.getClass())){
                    System.out.println("Vous ne pouvez pas supprimer un compte utilisateur");
                  }
                  else{
                  u.remove(i);
                  System.out.println("L'utilisateur ayant l'email"+email_utilisateur_a_supprimer+"est supprimé !");
                  trouve=true;
                  break;
                    }
                }

            }
            if (trouve==false){
            System.out.println("Aucun utilisateur ayant cet email est trouvé !! ");
          }
      }
  
    @Override
    public void se_connecter(ArrayList <utilisateur> u,ArrayList <matiere> m,ArrayList<cours> c,ArrayList<test> t)
    {  
         int choix;
         do{
        do{
          super.se_connecter(u,m,c,t);
          System.out.print("  *      4- valider_compte_enseignant     *\n ");
          System.out.print("  *      5- Consulter reclamation         *\n ");
          System.out.print("  *      6- Supprimer test                *\n ");
          System.out.print("  *      7- Supprimer cours               *\n ");
          System.out.print("  *      8- Supprimer utilisateur         *\n ");
          System.out.print("  *      9- consulter utilisateurs        *\n ");
          System.out.print("  *      10- Se deconnecter               *\n ");
          System.out.print("  *                                       *\n ");
          System.out.print("  * * * * * * * * * * * * * * * * * * * * *\n ");
          System.out.print("nos contacts \n Adresse:enicaringinfoc269@gmail.com \n rue des Entrepreneurs , 3eme etage ,Charguia II - 2035 TUNIS CARTHAGE \n Tel:+(216) 759 952 235 ");
          Scanner sc = new Scanner(System.in); 
          choix=sc.nextInt();
          }   
        while((choix>10)&& (choix<1));

        
      switch (choix)
     
     {
 
          case 1 -> this.consulter_cours(c) ;
          case 2 -> this.consulter_test(t) ;
          case 3 -> this.reclamer_test();
          case 4 -> this.alterer_validation_enseignant(u) ;
          case 5 -> this.consulter_reclamation();
          case 6 -> this.supprimer_test(t) ;
          case 7 -> this.supprimer_cours(c);
          case 8 -> this.supprimer_utilisateur(u);
          case 9 ->this.consulter_utilisateur(u);
          default ->  System.out.println("");
      }
         }
         while(choix!=10);
    
    }
    
    
      
      

}