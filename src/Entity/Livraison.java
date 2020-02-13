/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Malvin
 */
public class Livraison {
    int id ;
        Commande C ;
        String Etat;
        String livreur;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Commande getC() {
        return C;
    }

    public void setC(Commande C) {
        this.C = C;
    }

    public String getEtat() {
        return Etat;
    }

    public void setEtat(String Etat) {
        this.Etat = Etat;
    }

    public String getLivreur() {
        return livreur;
    }

    public void setLivreur(String livreur) {
        this.livreur = livreur;
    }

    public Livraison(Commande C, String Etat, String livreur) {
        this.C = C;
        this.Etat = Etat;
        this.livreur = livreur;
    }

}
