/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Malvin
 */
public class Commande {
    int id ;
    Livraison L ;
    Facture F ;
    Client C ;
    String Date; 
    List<Produit> Produits ;
    double montant;
public Commande() {};
    public Commande(Client C,String Daten,double montant) {
        this.montant = montant ;
        this.C = C;
        Produits = new ArrayList<Produit> ();
        this.Date = Date;
    }
     public Commande(int id ,Client C,String Daten,double montant) {
         this.id = id;
        this.montant = montant ;
        this.C = C;
        Produits = new ArrayList<Produit> ();
        this.Date = Date;
    }

    public Client getC() {
        return C;
    }

    public void setC(Client C) {
        this.C = C;
    }

    public List<Produit> getProduits() {
        return Produits;
    }

    public void setProduits(List<Produit> Produits) {
        this.Produits = Produits;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Livraison getL() {
        return L;
    }

    public void setL(Livraison L) {
        this.L = L;
    }

    public Facture getF() {
        return F;
    }

    public void setF(Facture F) {
        this.F = F;
    }

    public String getD() {
        return Date;
    }

    public void setD(String Date) {
        this.Date = Date;
    }
}
