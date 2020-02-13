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
public class Facture {
    int id;

   
    Commande C ;
    double prix_total;
     public Facture( Commande C, double prix_total) {
       
        this.C = C;
        this.prix_total = prix_total;
    }

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

    public double getPrix_total() {
        return prix_total;
    }

    public void setPrix_total(double prix_total) {
        this.prix_total = prix_total;
    }
     
}
