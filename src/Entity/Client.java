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
public class Client {
    int id ;
    Panier P ;

    public Panier getP() {
        return P;
    }

    public void setP(Panier P) {
        this.P = P;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Client(int id) {
        this.id = id;
    }
    
}
