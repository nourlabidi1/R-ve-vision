package Modele.formation;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
/*
package Modele;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;



import java.sql.ResultSet;


public class Projet_java {




      
    public static void main(String[] args) {
            String url = "jdbc:mysql://localhost:3306/projet_java_db";
            String user = "system";
            String password = "root";
            
            
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            if(connection!=null){
                System.out.println("Connected to the database ");
                
            }
            System.out.println("Connection is Successful to the database" + url);
            
            String query = "select * from etudiant;";
            Statement statement = connection.createStatement();
            ResultSet rs=statement.executeQuery(query); 
            while(rs.next())  
             System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3))
                     
                  
                     
                     
              ;

            connection.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        
        
        
     Scanner sc = new Scanner(System.in); 

     ArrayList<utilisateur> utilisateurs_bd =new ArrayList(); 
     ArrayList<cours> cours_bd =new ArrayList();   
     ArrayList<matiere> matiere_bd =new ArrayList(); 
     ArrayList<test> test_bd =new ArrayList(); 
     ArrayList<notebook> notebook_bd =new ArrayList();

                    // Peuplement statique des conteneurs
                            matiere java = new matiere(1,"java","programation oo");
                            matiere_bd.add(java);
                            cours cours_1=new cours(1,1,0,0,"Interface","D:\\test_java___le\\cours_1")    ;
                            cours cours_2=new cours(2,1,0,0,"conteneurs","D:\\test_java___le\\cours_2")    ;
                            cours_bd.add(cours_1);
                            cours_bd.add(cours_2);
                    /// questions du cours interface
                            cours_1.ajouter_cours("Une interface est définie de manière similaire à une\n classe, mais est caractérisée par le mot clé interface.\ninterface Printable {\nvoid print();\n");
                            cours_1.ajouter_cours("Une interface peut aussi hériter d'une ou plusieurs interfaces : elle hérite alors de l'ensemble des méthodes abstraites et constantes de ses ancêtres\n");
                            cours_2.ajouter_cours("Java dispose dans le package « java.util » des classes\npermettant de manipuler les principales structures de\ndonnées à savoir :\n les vecteurs dynamiques, les listes chainées, les ensembles, les\n queues et les tables associatives.\n");
                            cours_2.ajouter_cours("De nombreuses classes conteneurs implémentent les méthodes de\nl’interface Collection : Vector, Stack, ArrayList, LinkedList, HashSet, TreeSet,\n");
                            cours_2.ajouter_cours("Chacune de ces classes doit implémenter la méthode Iterator iterator() qui retourne un itérateur sur l’ensembles des éléments\n");
                            question q1=new question(1,"Tapez le mot incorrect :\nclass Point extends Object use Printable","use","synthax","on utilise le mot réservé 'implements' dans l'interface\n");
                            question q2=new question(2,"","une classe abstraite ne contenant que des méthodes abstraites et que des attributs final et static","QCM","une classe abstraite ne contenant que des méthodes abstraites et que des attributs final et static\n");
                            q2.ajouter_reponse("une classe abstraite ne contenant pas des méthodes");
                            q2.ajouter_reponse("une classe abstraite ne contenant des méthodes abstraites et non abstraite ainsi que des attributs final et static");
                            q2.ajouter_reponse("une classe ne contenant pas des attributs ");
                            q2.ajouter_reponse("une classe abstraite ne contenant que des méthodes abstraites et que des attributs final et static");
                            question q3=new question(3,"Une interface peut aussi hériter d'une ou plusieurs interfaces","oui","QCM","Une interface peut aussi hériter d'une ou plusieurs interfaces\n");
                            q3.ajouter_reponse("oui");
                            q3.ajouter_reponse("non");
                    /// questions du cours conteneurs

                            question q4=new question(4,"Pour parcourir un conteneur on utilise","iterator","QCM","Pour parcourir un conteneur on utilise un iterator\n");
                            q4.ajouter_reponse("Boucle For");
                            q4.ajouter_reponse("iterator");
                            question q5=new question(5,"On peut mettre des valeurs dupliqués dans le conteneur SET","oui","QCM","On ne peut mettre que des valeurs distinctes dans le conteneur SET\n");
                            q5.ajouter_reponse("oui");
                            q5.ajouter_reponse("non");
                            question q6=new question(3,"Est ce que tout les éléments de cette liste sont des contenaires : {ArrayList,Stack,Chaine}","oui","QCM","Une chaine n'est pas un conteneur\n");
                            q6.ajouter_reponse("oui");
                            q6.ajouter_reponse("non");
                    //creation des notebook
                            notebook n1 =new notebook(1,1,"D:\\test_java___le\\notebook_le_1");
                            notebook n2 =new notebook(2,2,"D:\\test_java___le\\notebook_le_2");
                            //n1.ajouter_resume(q1.get_resume());
                            //n1.ajouter_resume("\n");
                            //n1.ajouter_resume(q2.get_resume());
                            //n1.ajouter_resume("\n");
                    // remplir le fichier notebook 2
                           
                          //  n2.ajouter_resume(q4.get_resume());
                          //  n2.ajouter_resume("\n");
                          //  n2.ajouter_resume(q5.get_resume());
                           // n2.ajouter_resume("\n");
                    //creation des tests
                            test test_1=new  test(1,  0, 0,1) ;
                            test test_2=new  test(2, 0, 0,2) ;
                            test_bd.add(test_1);
                            test_bd.add(test_2);
                   //ajouter les questions aux tests correspondants
                            test_1.ajouter_questions(q1);
                            test_1.ajouter_questions(q2);
                            test_1.ajouter_questions(q3);
                            test_2.ajouter_questions(q4);
                            test_2.ajouter_questions(q5);
                            test_2.ajouter_questions(q6);
                            
                    //ajouter des etudiants (2)
                            etudiant e1=new etudiant( "LABIDI",  "nour el houda",  "nour@gmail.com", "i_can", "2 informatique");
                            etudiant e2=new etudiant( "KHALIL",  "majdi",  "majdi@gmail.com",  "we_can", "2 informatique");
                            e1.ajouter_notes_books(n1);
                            e2.ajouter_notes_books(n2);
                    //ajouter des enseignants (2)
                            enseignant en1=new enseignant( "SOUISSI",  "Mourade",  "mourade@gmail.com",  "informatique", "informatique");
                            enseignant en2=new enseignant( "KHEDHR",  "Asma",  "asma@gmail.com",  "informatique", "informatique");
                    //ajouter des administrateurs (2)
                            administrateur a1=new administrateur( "DHOUIBI",  "Nawel",  "nawel@gmail.com",  "1236");
                            administrateur a2=new administrateur( "JLASSI",  "Rami", "rami@gmail.com",  "12365");
                            utilisateurs_bd.add(e1);
                            utilisateurs_bd.add(e2);
                            utilisateurs_bd.add(en1);
                            utilisateurs_bd.add(en2);
                            utilisateurs_bd.add(a1);
                            utilisateurs_bd.add(a2);           






     

     System.out.print(" /$$      /$$ /$$$$$$$$ /$$        /$$$$$$   /$$$$$$  /$$      /$$ /$$$$$$$$          \n");
      System.out.print("| $$  /$ | $$| $$_____/| $$       /$$__  $$ /$$__  $$| $$$    /$$$| $$_____/           \n");
      System.out.print("| $$ /$$$| $$| $$      | $$      | $$  \\__/| $$  \\ $$| $$$$  /$$$$| $$               \n");
      System.out.print("| $$/$$ $$ $$2| $$$$$   | $$      | $$      | $$  | $$| $$ $$/$$ $$| $$$$$             \n");
      System.out.print("| $$$$_  $$$$| $$__/   | $$      | $$      | $$  | $$| $$  $$$| $$| $$__/              \n");
      System.out.print("| $$$/ \\  $$$| $$      | $$      | $$    $$| $$  | $$| $$\\  $ | $$| $$               \n");
      System.out.print("| $$/   \\  $$| $$$$$$$$| $$$$$$$$|  $$$$$$/|  $$$$$$/| $$ \\/  | $$| $$$$$$$$      \n ");
      System.out.print("|__/     \\__/|________/|________/ \\______/  \\______/ |__/     |__/|________/        \n");
      System.out.print("\n");
        System.out.print("\n");   System.out.print("\n");   System.out.print("\n");   System.out.print("\n");  

    int i;
    for( i=0;i<20;i++)
{
  System.out.print("\n\n\n");
  
      
        
     /*   
           System.out.print("     BIENVENUE \n ");
        System.out.print("\n  * * * * * * *   MENU  * * * * * * \n");
          System.out.print("  *                                *\n");
          System.out.print("  *      1-s'identifier            *\n" );
          System.out.print("  *      2- s'inscrire             *\n");
          System.out.print("  *      3- Quitter l'application  *\n");
          System.out.print("  * * * * * * * * * * * * * * * * * \n");
          System.out.print("nos contacts \n Adresse:infoe12122@gmail.com \n rue des Entrepreneurs , 3eme etage ,Charguia II - 2035 TUNIS CARTHAGE \n Tel:+(216) 759 952 235 \n");
        
          int choix;
             do
            {
               System.out.print("\n\n >>>> Veuillez choisir une des options donnees \n");
               choix=sc.nextInt();
   
             } 
         while(( choix!=1)&& (choix!=2)&&( choix!=3));
  
             
    // traitement du choix
    
      if (choix==1)//s'identifier
           {
            utilisateur u=new utilisateur();
                u.identification(utilisateurs_bd,matiere_bd,cours_bd,test_bd );                         
            }
      if (choix==2)//s'inscrire
            {   System.out.print("\n\n >>>> choisir un type de compte \n");
                System.out.print("\n\n >>>> 1-compte etudiant         \n");
                System.out.print("\n\n >>>> 2-compte enseignant       \n");
                System.out.print("\n\n >>>> 3-compte administrateur   \n");
                int choix_compte=sc.nextInt();
                utilisateur u=new utilisateur();
                u.inscription(utilisateurs_bd,choix_compte); 
            }
 if (choix==3) {break;} */
/*

    }
}
}

*/
























/*
          System.out.print("     BIENVENUE \n ");
          System.out.print("\n  * * * * * * *   MENU  * * * * * * * * * * \n");
          System.out.print("  *                                       * \n");
          System.out.print("  *      1-s'identifier            *\n" );
          System.out.print("  *      2- s'inscrire             *\n");
          System.out.print("  *      3-ajouter des hotel              *\n");
          System.out.print("  *      4-afficher les hotels            *\n");
          System.out.print("  *      5- le client de l'annee          *\n");
          System.out.print("  *      6- l'hotel de l'annee            *\n");
          System.out.print("  *      7- quitter                       *\n ");
          System.out.print(" *                                       * \n");
          System.out.print("  * * * * * * * * * * * * * * * * * * * * *\n");
          System.out.print("nos contacts \n Adresse:infoe12122@gmail.com \n rue des Entrepreneurs , 3eme etage ,Charguia II - 2035 TUNIS CARTHAGE \n Tel:+(216) 759 952 235 ");
        */