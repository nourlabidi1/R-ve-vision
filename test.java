/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modele.formation;

/**
 *
 * @author LENOVO
 */
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class test {
    
    private int id_test ;
    private ArrayList<question> questions;
    private int nbr_utilisateurs;
    private float score;
    private String path_file;
    private ArrayList<String> commentaires;
    private int id_cours ; //

    public test(int id_test,  int nbr_utilisateurs, float score,int  id_cours) {
        this.id_test = id_test;
      this.questions=new ArrayList();
        this.nbr_utilisateurs = nbr_utilisateurs;
        this.score = score;
     this.id_cours=id_cours;
    }
    
public test(){}
    

    public void saisie_test(){
        Scanner sc = new Scanner(System.in); 
        System.out.print("\nDonner le id du test\n");
        this.id_test=sc.nextInt();
        System.out.print("Donner le id du cours de ce test \n");
        this.id_cours=sc.nextInt();
        this.nbr_utilisateurs =0;
        this.score =0;
        System.out.print("Donner le nombre des questions à ajoutées dans ce test  \n");
        int nbr_test=sc.nextInt();
         for (int i=0 ; i<nbr_test;i++){
             question q=new question();
         this.questions.add(q.saisie_question());
         
         
    }
    System.out.print("\nTest inseré !\n");     
  }
    public ArrayList<String> get_commentaires(){
        return this.commentaires;
    }

   public void setId_cours(int id_cours) {
        this.id_cours = id_cours;
    }
    public void setId_test(int id_test) {
        this.id_test = id_test;
    }

    public void setQuestions(ArrayList<question> questions) {
        this.questions = questions;
    }

        public void setNbr_utilisateurs(int nbr_utilisateurs) {
        this.nbr_utilisateurs = nbr_utilisateurs;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public void setCommentaires(ArrayList<String> commentaires) {
        this.commentaires = commentaires;
    }

    public int getId_test() {
        return id_test;
    }
   public int getId_cours() {
        return id_cours;
    }
    public ArrayList<question> getQuestions() {
        return questions;
    }

    public int getNbr_utilisateurs() {
        return nbr_utilisateurs;
    }

    public float getScore() {
        return score;
    }

    public ArrayList<String> getCommentaires() {
        return commentaires;
    }


 public void ajouter_questions(question q)
 {
 this.questions.add(q);
 
 }
 
 public void incrementer_nbr_utiliseurs()
 {this.nbr_utilisateurs+=1;}

    public String getPath_file() {
        return path_file;
    }

    public void setPath_file(String path_file) {
        this.path_file = path_file;
    }
 
 
 
    @Override
    public String toString() {
        return "\nle id du test est: " + id_test + "\n les questions de ce test sont: " + questions + "\n le nombre des utilisateurs qui ont passer ce test est " + nbr_utilisateurs + "\nLe score de ce test est  score: " + score + "\nLes commentaires :\n " + commentaires ;
    }

      public int recherche_test(int id_cours)
{ if (this.id_cours == id_cours ){ return this.id_test;}
   else  return -1;}
    
      public void passer_test(notebook n1)
      { ArrayList<String> resume_faute;
       resume_faute=new ArrayList();
          Scanner sc = new Scanner(System.in); 
          for (int i=0 ; i<this.questions.size();i++)
      {   System.out.println("\nla "+(i+1)+"éme question est :\n\n");
         System.out.println( this.questions.get(i));
         
         
         //si la question est sous forme de qcm
         if ( this.questions.get(i).getType_question().equals("QCM"))
         {System.out.println("\nveuillez inserer l'indice correspondant à la reponse correcte.");
         int indice_q=sc.nextInt();
         if(this.questions.get(i).getChoix_reponse().get(indice_q).equals(this.questions.get(i).getReponse_correcte()))
         { System.out.println("\n BRAVO!! REPONSE CORRECTE \n") ;}
         else{
         System.out.println("\n MAUVAISE REPONSE! \n");
         resume_faute.add(this.questions.get(i).get_resume());
         System.out.println("\nLa bonne reponse est :"+this.questions.get(i).getReponse_correcte());
         }
             }
         // si la question est d'autre forme 
         else
         {System.out.println("\nVeuillez inserez la bonne  reponse\n");
         String reponse=sc.next();
         if(this.questions.get(i).getReponse_correcte().equals(reponse))
         { System.out.println("\n BRAVO!! REPONSE CORRECTE \n") ;}
         else{
         System.out.println("\n MAUVAISE REPONSE! \n");
         resume_faute.add(this.questions.get(i).get_resume());
         System.out.println("\nLa bonne reponse est :"+this.questions.get(i).getReponse_correcte());
         }
         }
      }
      // le test est terminé
      System.out.println("\n BRAVO , VOUS AVEZ TERMINEZ LE TEST \n VOTRE SCORE EST : "+
              (this.questions.size()-resume_faute.size() )*100/this.questions.size()   +"\n");
      
      //afficher les resumés des questions non correctes:echouées
                    if (resume_faute.size()>0)
                    {System.out.println("\n Voici les résumée(s) de vos reponses incorrectes: \n");
                   //affichage des résumées
                    for (int i=0 ; i<resume_faute.size();i++)
                   {System.out.println(i+1+"-"+resume_faute.get(i)+"\n");}
                   // ecriture des resumées dans le notebook correspondant
                   System.out.println("\n Tapez l'indices de resumé que vous voulez ajouter à votre notebook de matiere, sinon tapez '0' \n");
                   int indice_resume=sc.nextInt();
                   if ( (indice_resume>=1)&&(indice_resume<=resume_faute.size()))
                   {
                       n1.ajouter_resume(resume_faute.get(indice_resume-1));
                   }
                   System.out.println("si vous voulez ajouter un autre resume tapez 'oui' sinon 'non'  ");
                  String continuer=sc.next();
                   while(continuer.equals("oui")  ) 
                    {
                     System.out.println("\n Tapez l' indice de resumé que vous voulez ajouter à votre notebook de matiere, sinon tapez'0' \n");
                     indice_resume=sc.nextInt();
                     if (indice_resume==0){break;}
                     else{
                     n1.ajouter_resume(resume_faute.get(indice_resume-1));}
                    }
     
     
      }
       System.out.println("\n Si vous voulez noter ce test , donnez une note sur 10 sinon tapez '-1' \n");
       int note=sc.nextInt();
       if (note!=-1){this.score+=note;}
      
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
        final test other = (test) obj;
        if (this.id_test != other.id_test) {
            return false;
        }
         if (this.id_cours != other.id_cours) {
            return false;
        }
        if (this.nbr_utilisateurs != other.nbr_utilisateurs) {
            return false;
        }
        if (Float.floatToIntBits(this.score) != Float.floatToIntBits(other.score)) {
            return false;
        }
        if (!Objects.equals(this.questions, other.questions)) {
            return false;
        }
        return Objects.equals(this.commentaires, other.commentaires);
    }


}
