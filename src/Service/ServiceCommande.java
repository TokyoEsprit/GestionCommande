/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.Client;
import Entity.Commande;
import Entity.Facture;
import Entity.Panier;
import Entity.Produit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.ConnexionBD;

/**
 *
 * @author Malvin
 */
public class ServiceCommande {
         Connection c= ConnexionBD.getInstance().getCnx();
     ServicePanier sp = new ServicePanier();
    public  void passerCommande (Panier p) throws SQLException {
        Commande C = new Commande(p.getC(),"aaaa",sp.calculePrix(p));
                C.setProduits(sp.getPanier(p));

          String rq1 = "INSERT INTO commande (`date`, `client_id`, `montant`) values ('"+"20/04/04"+"','"+C.getC().getId()+"','"+C.getMontant()+"')" ;
            Statement st1 = c.createStatement() ;
            st1.executeUpdate(rq1) ;
              String rq = "select * from commande where id =(Select max(id) from commande)" ;
            Statement stt = c.createStatement() ;
            ResultSet rs = stt.executeQuery(rq) ;
            if (rs.first()) {
        for (Produit P : C.getProduits()) {
             String rq3 = "insert into commande_produit (commande_id,produit_id) values ('"+rs.getInt(1)+"','"+P.getId()+"')" ;
            Statement st3 = c.createStatement() ;
            st3.executeUpdate(rq3) ;
        }}
    }
      public  List<Produit> getProduitCommande (Commande p) throws SQLException {
             List<Produit> Prod = new ArrayList<>();
             p.setProduits(Prod);
      PreparedStatement pt2 = c.prepareStatement("select * from commande_produit where commande_id ='"+p.getId()+"'");
            ResultSet rs2 = pt2.executeQuery();
            while (rs2.next()) { 

                   PreparedStatement pt3 = c.prepareStatement("select * from produit where id ='"+rs2.getInt(2)+"'");
            ResultSet rs3 = pt3.executeQuery();
            
            while (rs3.next()) { 
                Produit P = new Produit(rs3.getInt(1),rs3.getInt(2));
               p.getProduits().add(P);
              
            }
     }
     return p.getProduits();}
       public void effaceCommande (Commande C )
    {
        try {
            PreparedStatement pt = c.prepareStatement("delete from commande_produit where commande_id='"+C.getId()+"'");
            pt.executeUpdate();
             PreparedStatement pt1 = c.prepareStatement("delete from commande where commande_id='"+C.getId()+"'");
            pt1.executeUpdate();
        } catch (SQLException ex) {
                    System.out.println(ex.getMessage());

        }
    }   
       public List<Commande> afficherCommandes() {
         List<Commande> list = new ArrayList<>() ;
        try {
            ServiceCommande sc = new ServiceCommande();
            String rq = "select * from commande" ;
            Statement st = c.createStatement() ;
            ResultSet rs = st.executeQuery(rq) ;
            while(rs.next()) {
                Commande c1 = new Commande() ;
                c1.setId(rs.getInt(1));
                c1.setD(rs.getString("date"));
                c1.setMontant(rs.getDouble("montant"));
                c1.setProduits(sc.getProduitCommande(c1));
                list.add(c1) ;
            }
        } catch (SQLException ex) {
        }
                    return list ;
     }
        public Commande ConsulterCommande(Commande F) throws SQLException {
                              Commande c1 = new Commande() ;
       
            ServiceCommande sc = new ServiceCommande();
            String rq = "select * from commande where id='"+F.getId()+"'" ;
            Statement st = c.createStatement() ;
            ResultSet rs = st.executeQuery(rq) ;
            while(rs.next()) {
                c1.setId(rs.getInt(1));
                c1.setD(rs.getString("date"));
                c1.setMontant(rs.getDouble("montant"));
                c1.setProduits(sc.getProduitCommande(c1));
            }
            return c1;
        }
        
}
     
     
