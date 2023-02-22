/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modele.personnel;
import Modele.formation.cours;
import Modele.formation.matiere;
import Modele.formation.notebook;
import Modele.formation.test;
import java.util.Scanner;
/**
 *
 * @author LENOVO
 */
import java.util.Objects;
import java.util.ArrayList;



//import com.mycompany.projet_java.formation.cours;
public final class etudiant extends utilisateur{
    private String niveau;
    private ArrayList<Integer> cours_enregistres;
    private ArrayList<Integer> tests_effectues;
    private ArrayList<notebook> notes_books;

    public etudiant(String nom, String prenom, String email, String mot_de_passe,String niveau) {
        super(nom,prenom,email,mot_de_passe);
        this.niveau = niveau;
        cours_enregistres =new ArrayList();
        tests_effectues = new ArrayList();
        notes_books = new ArrayList();
    }
 public etudiant(){}
    
    public void ajouter_notes_books(notebook id_notebook)
    {this.notes_books.add(id_notebook);}
    public String get_niveau() {
       
      
        return niveau;
    }

    public void set_niveau(String niveau) {
        this.niveau = niveau;
    }

    public ArrayList<Integer> get_cours_enregistres() {
        return cours_enregistres;
    }
    
    public void ajouter_cours_enregistres(int id_cours){
        this.cours_enregistres.add(id_cours);
    }
    
    public ArrayList<Integer> get_tests_effectues() {
        return tests_effectues;
    }
    public void ajouter_tests_effectues(int id_test){
        this.tests_effectues.add(id_test);
    }

    public ArrayList<notebook> get_notes_books() {
        return notes_books;
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
        final etudiant other = (etudiant) obj;
        if (!Objects.equals(this.niveau, other.niveau)) {
            return false;
        }
        if (!Objects.equals(this.cours_enregistres, other.cours_enregistres)) {
            return false;
        }
        if (!Objects.equals(this.tests_effectues, other.tests_effectues)) {
            return false;
        }
        return Objects.equals(this.notes_books, other.notes_books);
    }

    
          //public void consulter_cours(){};
          //public void consulter_test(){};
          public void reclamer_test(){};
          
          public void  enregistrer_cours(ArrayList<cours> c){
            this.consulter_cours(c);
            System.out.print("  saisir l'id du cours que vous voulez enregistrer \n");
            Scanner sc = new Scanner(System.in);
            int id_cours=sc.nextInt();
            boolean trouve=false;
            for(int i=0;i<c.size();i++){
            if(c.get(i).get_id_cours()==(id_cours))
            {   trouve=true;
                this.ajouter_cours_enregistres(id_cours);
                System.out.print("\n cours enregistré ! \n");
                break;}
            }
            if ( trouve==false) {System.out.print("\n cours introuvable \n");}
           }
          public void ajouter_commentaire_cours(ArrayList<cours> c){
              
          this.consulter_cours(c);
          System.out.print("  saisir l'id du cours que vous voulez commenter \n");
          Scanner sc = new Scanner(System.in);
          int id_cours=sc.nextInt();
          boolean trouve=false;
          for(int i=0;i<c.size();i++){
          if(c.get(i).get_id_cours()==(id_cours))
          {   trouve=true;
              System.out.print("\n commentaire ajouté ! \n");
               String  commentaire=sc.next();
               commentaire+="\n"+this.get_nom()+" "+this.get_prenom()+"\n";
               c.get(i).get_commentaires().add(commentaire);
              break;}
          }
          if( trouve==false) {System.out.print("\n cours introuvable \n");}
          }
          
          public void ajouter_commentaire_test(ArrayList<test> t){
          this.consulter_test(t);
          System.out.print("  saisir l'id du test que vous voulez commenter \n");
          Scanner sc = new Scanner(System.in);
          int id_test=sc.nextInt();
          boolean trouve=false;
          for(int i=0;i<t.size();i++){
          if(t.get(i).getId_test()==(id_test))
          {   trouve=true;
              System.out.print("\n commentaire ajouté ! \n");
               String  commentaire=sc.next();
               commentaire+="\n"+this.get_nom()+" "+this.get_prenom()+"\n";
               t.get(i).get_commentaires().add(commentaire);
              break;}
          if( trouve==false) {System.out.print("\n test introuvable \n");}
          }}


          public void noter_qualite_cours(){};      
          public void noter_qualite_test(){};
          
          
          
          
          
          
          
          public void passer_test(ArrayList <matiere> m,ArrayList<cours> c,ArrayList<test> t){
              Scanner sc = new Scanner(System.in); 
              System.out.println("\nveuillez choisir l'indice de la matiere\n");
              for (int i=0 ; i<m.size();i++)
              { System.out.println(m.get(i));
              }
              
              int indice_matiere=sc.nextInt();
              System.out.println("\nveuillez choisir l'indice du cours\n");
             
               for (int i=0 ; i<c.size();i++)
                { System.out.println(c.get(i));
                }
               // ici
               int indice_cours=sc.nextInt();
                 // chercher le test ayant le id cours choisi
              for (int i=0 ; i<t.size();i++)
                        {if (t.get(i).recherche_test(indice_cours)!= -1)
                      //recherche du notebook n1
                                    {       t.get(i).incrementer_nbr_utiliseurs();
                                            for (int k=0 ; k<this.notes_books.size();k++)
                                              {
                                                  if (this.notes_books.get(k).get_id_cours()==indice_cours)
                                                   //  notebook existant
                                                  {
                                                      t.get(i).passer_test(this.notes_books.get(k));
                                                      break;
                                                  }
                                               
                                                else{
                                                     // id notebook aleatoire 
                                                     System.out.println("donner le path du file du notebook");
                                                     String patheee=sc.nextLine();
                                                     System.out.println(patheee);
                                                     notebook n2=new notebook(t.size(),indice_cours,patheee);
                                                     this.notes_books.add(n2);
                                                     t.get(i).passer_test(n2);

                                                    }
                                             }
                                    }


                  
                  
          
          
              }
          }

    public String getNiveau() {
        return niveau;
    }

    public ArrayList<Integer> getCours_enregistres() {
        return cours_enregistres;
    }

    public ArrayList<Integer> getTests_effectues() {
        return tests_effectues;
    }

    public ArrayList<notebook> getNotes_books() {
        return notes_books;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public void setCours_enregistres(ArrayList<Integer> cours_enregistres) {
        this.cours_enregistres = cours_enregistres;
    }

    public void setTests_effectues(ArrayList<Integer> tests_effectues) {
        this.tests_effectues = tests_effectues;
    }

    public void setNotes_books(ArrayList<notebook> notes_books) {
        this.notes_books = notes_books;
    }
              
             
          
          
          
       
    
    
    
          
          
          
          
    
    @Override
    public String toString() {
        return "l'etudiant est \nNom etudiant: "+this.get_nom()+" "+this.get_prenom()+ "\nniveau=" + niveau + ", cours_enregistres=" + cours_enregistres + ", tests_effectues=" + tests_effectues + ", notes_books=" + notes_books + '}';
    }
   @Override 
public void se_connecter(ArrayList<utilisateur> u,ArrayList <matiere> m,ArrayList<cours> c,ArrayList<test> t)
{  int choix;
         do{
        do {
super.se_connecter(u,m,c,t);

          System.out.print("  *      4-Enregistrer un cours            *\n");
          System.out.print("  *      5-Ecrire un commentaire à un cours*\n");
          System.out.print("  *      6-Ecrire un commentaire à un test *\n");
          System.out.print("  *      7-Noter la qualité d'un cours     *\n");
          System.out.print("  *      8-Noter la qualité d'un test      *\n");
          System.out.print("  *      9-Passer un test                  *\n");
          System.out.print("  *      10-Se deconnecter                 *\n");
          System.out.print("  *                                        *\n");
          System.out.print("  * * * * * * * * * * * * * * * * * * * * *\n");
          System.out.print("nos contacts \n Adresse:infoe12122@gmail.com \n rue des Entrepreneurs , 3eme etage ,Charguia II - 2035 TUNIS CARTHAGE \n Tel:+(216) 759 952 235\n\n\n ");
        

          Scanner sc = new Scanner(System.in); 
          choix=sc.nextInt();
 
        }   while((choix>10)&& (choix<1));
        
      switch (choix)
     
     {
 
          case 1 -> this.consulter_cours(c) ;
          case 2 -> this.consulter_test(t) ;
          case 3 -> this.reclamer_test();
          case 4 -> this.enregistrer_cours(c) ;
          case 5 -> this.ajouter_commentaire_cours(c);
          case 6 -> this.ajouter_commentaire_test(t) ;
          case 7 -> this.noter_qualite_cours();
          case 8 -> this.noter_qualite_test();
          case 9 -> this.passer_test(m,c,t);        
}



}
while(choix!=10);}

}