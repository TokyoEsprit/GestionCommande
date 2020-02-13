/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import Service.ServicePanier;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.ConnexionBD;

/**
 *
 * @author Malvin
 */
public class Panier {
   int id ;
  List<Produit> Produits ;
   Client c ;
   double  Prix;
       static Panier instance;
private Panier(Client c ){
     this.id = id;
 this.c = c;
 this.Prix = 0.00 ;
 Produits = new ArrayList<>() ;
         
    }
 private Panier(int id ,Client c ){
     this.id = id;
 this.c = c;
 this.Prix = 0.00 ;
 Produits = new ArrayList<>() ;
         
    }
        public static Panier getInstance(Client C) throws SQLException {
                 Connection c= ConnexionBD.getInstance().getCnx();

           
                 
            PreparedStatement pt = c.prepareStatement("select * from panier where client_id ='"+C.getId()+"'");
           ResultSet rs = null;
             rs = pt.executeQuery();
               
                if (rs.first()  == false) {
                    
                    ServicePanier sp = new ServicePanier();
                    sp.creePanier(C);
                    Panier P = new Panier(C);
                    return P ;
                }
                else {
                    Panier Pn = new Panier(rs.getInt(1),C);
                                        ServicePanier sp = new ServicePanier();
                    sp.getPanier(Pn);
                     return  Pn;
                 }
           
                 
        }
        
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Produit> getProduits() {
        return Produits;
    }

    public void setProduits(List<Produit> Produits) {
        this.Produits = Produits;
    }

    public Client getC() {
        return c;
    }

    public void setC(Client C) {
        this.c = C;
    }

    public double getPrix() {
        return Prix;
    }

    public void setPrix(double Prix) {
        this.Prix = Prix;
    }

    
}
