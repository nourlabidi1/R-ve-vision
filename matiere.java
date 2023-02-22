/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modele.formation;
import java.util.Objects;

/**
 *
 * @author LENOVO
 */
public class matiere {
private  int id_matiere;
 private String nom;
 private String theme;


public matiere(int id_matiere,String nom,String theme)
{this.id_matiere=id_matiere;
this.nom=nom;
this.theme=theme;
}

public void set_id_matiere(int id_matiere)
{this.id_matiere=id_matiere;}

public void set_nom(String nom)
{
this.nom=nom;
}

public void set_theme(String theme)
{
this.theme=theme;

}

public matiere recherche_matiere(int id_matiere)
{if (this.id_matiere==id_matiere)
                 return this ;
else return null;}

public int get_id_matiere(){return this.id_matiere;}
public String get_nom(){return this.nom;}
public String get_theme(){return this.theme;}

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
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
        final matiere other = (matiere) obj;
        if (this.id_matiere != other.id_matiere) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        return Objects.equals(this.theme, other.theme);
    }

    @Override
    public String toString() {
        return "\n Le id de la matiere est: " + id_matiere + "\n le  nom de la matiere est " + nom + "\n Le theme de la matiere est " + theme ;
    }




}
 
