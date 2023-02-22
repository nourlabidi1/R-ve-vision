/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modele.personnel;
//singleton 
/**
 *
 * @author LENOVO
 */
public final class user {
    private String email;
    private String mot_de_passe;
    private String nom;
    private String prenom;
    public static final user instance = new user();

    private user() {
    }
    
        
              
    
public static user getInstance(){
    return instance;
}
    @Override
    public String toString() {
        return "user{" + "email=" + email + ", mot_de_passe=" + mot_de_passe + ", nom=" + nom + ", prenom=" + prenom + '}';
    }

    public void setInstance(String email, String mot_de_passe, String nom, String prenom) {
        this.email = email;
        this.mot_de_passe = mot_de_passe;
        this.nom = nom;
        this.prenom = prenom;
        
    
    }
     public void set_mot_de_passe(String mdp)
     {this.mot_de_passe=mdp;}

    public String getEmail() {
        return instance.email;
    }

    public String getMot_de_passe() {
        return instance.mot_de_passe;
    }

    public String getNom() {
        return instance.nom;
    }

    public String getPrenom() {
        return instance.prenom;
    }


    
    
}
