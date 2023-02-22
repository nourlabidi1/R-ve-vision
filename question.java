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
import java.util.logging.Logger;
public class question {
    
    private int id_question  ;
    private String question;
    private ArrayList<String>choix_reponse; // on peut faire un set 
    private String reponse_correcte;
    private String type_question ;
    private String resume;
    public question(){}
    public     question(int id_question, String question, String reponse_correcte, String type_question, String resume) {
        this.choix_reponse= new ArrayList(); 
        this.id_question = id_question;
        this.question = question;
        this.reponse_correcte = reponse_correcte;
        this.type_question = type_question;
        this.resume = resume;
    }
        public question saisie_question(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Veuillez saisir l'id question");
        this.id_question=sc.nextInt();
        System.out.println("Veuillez saisir la question");
        this.question=sc.next();
        System.out.println("Veuillez saisir le type de question  ");
        this.type_question=sc.next();
        if(this.type_question.equals("QCM")){
            System.out.println("Veuillez saisir les réponses possibles: ");
            String choix_reponse_saisie;
            String reponse_ajout_choix_reponse;
            boolean sortie=false;
            do{
                choix_reponse_saisie=sc.next();
                this.choix_reponse.add(choix_reponse_saisie);
                System.out.println("Voulez vous ajouter d'autres choix de réponses ?(oui/non) ");
                reponse_ajout_choix_reponse=sc.next();
                if(reponse_ajout_choix_reponse.equals("non")){
                    sortie=true;
                } 
            }
            while(sortie==false);
        }
        System.out.println("Veuillez saisir la Bonne réponse");
        this.reponse_correcte=sc.next();
        System.out.println("Veuillez saisir le résumé de cette question");
        this.resume=sc.next();
        return this;
    }
 

    public ArrayList<String> getChoix_reponse() {
        return choix_reponse;
    }

    public int getId_question() {
        return id_question;
    }

    public String getQuestion() {
        return question;
    }

    public String getReponse_correcte() {
        return reponse_correcte;
    }

    public String getType_question() {
        return type_question;
    }

    public String get_resume() {
        return resume;
    }

    public void setId_question(int id_question) {
        this.id_question = id_question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setChoix_reponse(ArrayList<String> choix_reponse) {
        this.choix_reponse = choix_reponse;
    }

    public void setReponse_correcte(String reponse_correcte) {
        this.reponse_correcte = reponse_correcte;
    }

    public void setType_question(String type_question) {
        this.type_question = type_question;
    }

    public void setResume(String resume) {
        this.resume = resume;
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
        final question other = (question) obj;
        if (this.id_question != other.id_question) {
            return false;
        }
        if (!Objects.equals(this.question, other.question)) {
            return false;
        }
        if (!Objects.equals(this.reponse_correcte, other.reponse_correcte)) {
            return false;
        }
        if (!Objects.equals(this.type_question, other.type_question)) {
            return false;
        }
        if (!Objects.equals(this.resume, other.resume)) {
            return false;
        }
        return Objects.equals(this.choix_reponse, other.choix_reponse);
    }

    @Override
    public String toString() {
       if(this.choix_reponse.size()>0) {return " la question est \n" + question + "\n les choix de reponses sont: \n" + afficher_choix()  ;}
       else return " la question est \n" + question  ;
    }
    
    public void ajouter_reponse(String reponse){
        this.choix_reponse.add(reponse);    
    }
    
  public String afficher_choix()
  {  String ch="";
  //   for (int i=0 ; i<this.choix_reponse.size();i++)
 // { ch+=i+"-"+this.choix_reponse.get(i)+"\n";
   //   }
   
choix_reponse.stream().forEach(System.out::println);
  return ch;  
  }
}
