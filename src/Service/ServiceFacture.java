/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.Commande;
import Entity.Facture;
import Entity.Panier;
import Entity.Produit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utils.ConnexionBD;

/**
 *
 * @author Malvin
 */
public class ServiceFacture {
                      Connection c= ConnexionBD.getInstance().getCnx();

     public  void passerCommande (Commande C) throws SQLException {

     Facture F = new Facture(C,C.getMontant());

          String rq1 = "INSERT INTO facture (`commande_id`, `prix_total`) values ('"+C.getId()+"','"+C.getMontant()+"')" ;
           Statement st1 = c.createStatement() ;
            st1.executeUpdate(rq1) ;
}
     public Facture ConsulterFacture(Facture F) throws SQLException {
          String rq = "select * from facture where id ='"+F.getId()+"'" ;
            Statement st = c.createStatement() ;
            ResultSet rs = st.executeQuery(rq) ;
                             Facture c1 = new Facture() ;

            if (rs.first()) { 
                c1.setId(rs.getInt(1));
                c1.setPrix_total(rs.getDouble("montant"));
                 String rq1 = "select * from commande where id='"+rs.getInt(2)+"'" ;
            Statement st1 = c.createStatement() ;
            ResultSet rs1 = st1.executeQuery(rq1) ;
            if (rs1.first()) { 
                            ServiceCommande sc = new ServiceCommande();
                  Commande com = new Commande() ;
                com.setId(rs.getInt(1));
                com.setD(rs.getString("date"));
                com.setMontant(rs.getDouble("montant"));
                com.setProduits(sc.getProduitCommande(com));
                c1.setC(com);
            }
            } 
                            return c1;

     }
     
            public List<Facture> afficherFacture() {
         List<Facture> list = new ArrayList<>() ;
        try {
            String rq = "select * from facture" ;
            Statement st = c.createStatement() ;
            ResultSet rs = st.executeQuery(rq) ;
            while(rs.next()) {
                Facture c1 = new Facture() ;
                c1.setId(rs.getInt(1));
                c1.setPrix_total(rs.getDouble("montant"));
                String rq1 = "select * from commande where id='"+rs.getInt(2)+"'" ;
            Statement st1 = c.createStatement() ;
            ResultSet rs1 = st1.executeQuery(rq1) ;
            if (rs1.first()) { 
                            ServiceCommande sc = new ServiceCommande();
                  Commande com = new Commande() ;
                com.setId(rs.getInt(1));
                com.setD(rs.getString("date"));
                com.setMontant(rs.getDouble("montant"));
                com.setProduits(sc.getProduitCommande(com));
                c1.setC(com);
            }
            }
        } catch (SQLException ex) {
        }
                    return list ; }
     }

