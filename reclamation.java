/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modele.personnel;

import java.util.Objects;
public record  reclamation(int id_reclamation ,String email_reclamant,String contenu) {}// les appels des getteurs:  en .id_reclamation()(lexemple de lattribut id_reclamation



/*public class reclamation {
    private int id_reclamation;
    private int id_reclamant;
    private String contenu;

    public reclamation(int id_reclamation, int id_reclamant, String contenu) {
        this.id_reclamation = id_reclamation;
        this.id_reclamant = id_reclamant;
        this.contenu = contenu;
    }
    
    

    public int getId_reclamation() {
        return id_reclamation;
    }

    public void setId_reclamation(int id_reclamation) {
        this.id_reclamation = id_reclamation;
    }

    public int getId_reclamant() {
        return id_reclamant;
    }

    public void setId_reclamant(int id_reclamant) {
        this.id_reclamant = id_reclamant;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    @Override
    public String toString() {
        return "reclamation{" + "id_reclamation=" + id_reclamation + ", id_reclamant=" + id_reclamant + ", contenu=" + contenu + '}';
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
        final reclamation other = (reclamation) obj;
        if (this.id_reclamation != other.id_reclamation) {
            return false;
        }
        if (this.id_reclamant != other.id_reclamant) {
            return false;
        }
        return Objects.equals(this.contenu, other.contenu);
    }
    
    
}
*/