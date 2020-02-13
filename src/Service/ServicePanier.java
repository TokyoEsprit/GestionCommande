/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.Client;
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
public class ServicePanier {
     Connection c= ConnexionBD.getInstance().getCnx();
    public void creePanier(Client C) throws SQLException {
       Statement st = c.createStatement();
       String requeteInsert = "INSERT INTO panier (`client_id`, `Prix`) VALUES ('" + C.getId() + "', '" + 0.0 + "');";
        try {
            st=c.createStatement();
            st.executeUpdate(requeteInsert);
            
            
        } catch (SQLException ex) {
        System.out.println(ex.getMessage());
        }
         String rq = "select * from panier where id =(Select max(id) from panier)" ;
            Statement stt = c.createStatement() ;
            ResultSet rs = stt.executeQuery(rq) ;
            if (rs.first()) {
                
           
         try {
       
             String upd = "update client set id_panier ='"+rs.getInt(1)+"' where id ='"+C.getId()+"'" ;
            Statement st1 = c.createStatement() ;
            st1.executeUpdate(upd) ;
        } catch (SQLException ex) {
        System.out.println(ex.getMessage());
        }
         }
    }
    public void AjouterProduit (Produit Pd, Panier P) throws SQLException
    {
       Statement st = c.createStatement();
       String requeteInsert = "INSERT INTO panier_produit (`panier_id`, `produit_id`) VALUES ('" + P.getId() + "', '" + Pd.getId() + "');";
        try {
            st=c.createStatement();
            st.executeUpdate(requeteInsert);
            P.getProduits().add(Pd);
        } catch (SQLException ex) {
        System.out.println(ex.getMessage());
        }
        
                
    }
     public  List<Produit> getPanier (Panier p) throws SQLException {
             List<Produit> Prod = new ArrayList<>();
             p.setProduits(Prod);
      PreparedStatement pt2 = c.prepareStatement("select * from panier_produit where panier_id ='"+p.getId()+"'");
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
     
      public double calculePrix (Panier p) throws SQLException {
          double somme = 0 ;
      PreparedStatement pt2 = c.prepareStatement("select * from panier_produit where panier_id ='"+p.getId()+"'");
            ResultSet rs2 = pt2.executeQuery();
            while (rs2.next()) { 

                   PreparedStatement pt3 = c.prepareStatement("select * from produit where id ='"+rs2.getInt(2)+"'");
            ResultSet rs3 = pt3.executeQuery();
            
            while (rs3.next()) { 
                somme += rs3.getInt(2);
              
            } }
            return somme ;
     }
     
     public void AjouterProduitPanier (Produit Pd, Panier P) throws SQLException
    {
          List<Produit> Prod = P.getProduits() ;
          if (Prod == null )  {
              Prod = new ArrayList<>() ;
                 Prod.add(Pd);
               P.setProduits(Prod);
          }
          else {
                Prod.add(Pd);
               P.setProduits(Prod);
          }
       

            
  
    }
 
 public void effaceProduit (Panier p,Produit P)
    {
        try {
            PreparedStatement pt = c.prepareStatement("delete from panier_produit where produit_id='"+P.getId()+"' and panier_id='"+p.getId()+"'");
            pt.executeUpdate();
        } catch (SQLException ex) {
                    System.out.println(ex.getMessage());

        }
    }    
    public void viderPanier (Panier p)
    {
        try {
            PreparedStatement pt = c.prepareStatement("delete from panier_produit where panier_id='"+p.getId()+"'");
            pt.executeUpdate();
        } catch (SQLException ex) {
                    System.out.println(ex.getMessage());

        }
    }    
 
        
      
    }

