/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev;
import Entity.Client;
import Entity.Commande;
import Entity.Panier;
import Entity.Produit;
import Service.ServiceCommande;
import Service.ServicePanier;
import java.sql.SQLException;
import utils.ConnexionBD;

/**
 *
 * @author Malvin
 */
public class PIDEV {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        Client c = new Client (1);
        Panier P = Panier.getInstance(c);
        ServicePanier SP = new ServicePanier();
        Produit pd = new Produit(1,12);
        Produit pd2 = new Produit(2,15);
        Commande C = new Commande(9,c,"1212",151.00);
      // SP.AjouterProduit(pd,P);
             ServiceCommande SC = new ServiceCommande() ;

       for(Commande c1 :   SC.afficherCommandes()) {
           System.out.println(c1.getId());
                  for(Produit P1 :  c1.getProduits()) {
           System.out.println(P1.getId());

       }
       //SC.passerCommande(P);
       // SP.effaceProduit(P, pd);
      // SP.viderPanier(P);
        
    }
    }}
