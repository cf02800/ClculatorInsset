/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.insset.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 *
 * @author user
 */
@SuppressWarnings("serial")
public class Remise extends RemoteServiceServlet {
    
    //méthode pour calculer une remise en fonction d'un prix de départ et d'un taux
    public float CalculRemise(float prixInitial, int taux) {
        //on fait un produit en croix et on retourne directement le résultat
        return (prixInitial * taux) / 100;
    }
    
    //méthode pour calculer un prix final en fonction d'un prix de départ et d'un taux
    public float CalculPrixFinal(float prixInitial, int taux) {
        //on appelle la méthode précédente pour avoir la remise...
        float remise = this.CalculRemise(prixInitial, taux);
        //...et on la soustrait au prix initial pour obtenir le résultat
        return prixInitial - remise;
    }
    
    //méthode pour retrouver le prix de départ en fonction d'un prix final et d'un taux
    public float calculPrixInitial(float prixFinal, int taux) {
        //on fait un produit en croix pour avoir la remise en soustrayant le taux à 100 (pourcentage)
        float remise = (prixFinal * taux) / (100 - taux);
        //on ajoute la remise au prix final pour retrouver le prix initial
        return prixFinal + remise;
    }
}
