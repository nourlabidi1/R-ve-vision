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

import java.util.Objects;
import java.util.ArrayList;
import java.util.stream.Stream;
public final class enseignant extends utilisateur {
    private String etablissement;
    private ArrayList<matiere> matieres;
    private boolean validation;// Un compte enseingant doit etre validé par un administrateur avant qu'il puisse poster un test ou cours ou autres
    
    public enseignant(String nom,String prenom,String email,String mot_de_passe,String etablissement){
        super(nom,prenom,email,mot_de_passe);
        this.etablissement=etablissement;
        validation=false;
        matieres= new ArrayList();
    }
 public enseignant(){}
    public String get_etablissement() {
        return etablissement;
    }

    public boolean get_validation() {
        return validation;
    }

    @Override
    public void set_validation(boolean validation) {
        this.validation = validation;
    }
    

    public Stream<matiere> get_matieres() {
        return matieres.stream();
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
        final enseignant other = (enseignant) obj;
        if (!Objects.equals(this.etablissement, other.etablissement)) {
            return false;
        }
        return Objects.equals(this.matieres, other.matieres);
    }

    @Override
    public String toString() {
        return "\nNom enseignant: "+this.get_nom()+" "+this.get_prenom()+"\n"+"L'etablissement est " + etablissement +"\n La Validation="+ validation +" \n Les matieres enseignées par ce proffesseur sont\n" + matieres ;
    }
   
    
    

public void reclamer_test(){};

// à developper
public void ajouter_test(ArrayList<test> te){
   test t=new test(); 
    t.saisie_test();
te.add(t);

};


public void ajouter_cours(ArrayList<cours> c){
cours co=new cours();
co.saisie_cours();
c.add(co);
};
public void modifier_test(){};
public void modifier_cours(){};
public void consulter_statistiques(){};

    public String getEtablissement() {
        return etablissement;
    }

    public ArrayList<matiere> getMatieres() {
        return matieres;
    }

    public boolean isValidation() {
        return validation;
    }

    public void setEtablissement(String etablissement) {
        this.etablissement = etablissement;
    }

    public void setMatieres(ArrayList<matiere> matieres) {
        this.matieres = matieres;
    }

    public void setValidation(boolean validation) {
        this.validation = validation;
    }
    
    
@Override
public void se_connecter(ArrayList <utilisateur> u,ArrayList <matiere> m,ArrayList<cours> c,ArrayList<test> t)
{   int choix;
        do{
        do {
 super.se_connecter(u,m,c,t);
          System.out.print("  *      4-Ajouter un Test               *\n");
          System.out.print("  *      5-Ajouter un cours              *\n");
          System.out.print("  *      6-Modifier un test              *\n");
          System.out.print("  *      7-Modifier un cours             *\n ");
          System.out.print("  *      8-Consulter les statistiques    *\n ");
          System.out.print("  *      9-Se connecter                       *\n ");
          System.out.print("  *                                      * \n");
          System.out.print("  * * * * * * * * * * * * * * * * * * * * *\n");
          System.out.print("nos contacts \n Adresse:infoe12122@gmail.com \n rue des Entrepreneurs , 3eme etage ,Charguia II - 2035 TUNIS CARTHAGE \n Tel:+(216) 759 952 235 ");
        
Scanner sc = new Scanner(System.in); 
          choix=sc.nextInt();
 
        }   while((choix>9)&& (choix<1));
        
      switch (choix)
     
     {
 
          case 1 -> this.consulter_cours(c) ;
          case 2 -> this.consulter_test(t) ;
          case 3 -> this.reclamer_test();
          case 4 -> this.ajouter_test(t) ;
          case 5 -> this.ajouter_cours(c);
          case 6 -> this.modifier_test() ;
          case 7 -> this.modifier_cours();
          case 8 -> this.consulter_statistiques() ;
          default -> System.out.print("");


}


}while(choix!=9);}

}