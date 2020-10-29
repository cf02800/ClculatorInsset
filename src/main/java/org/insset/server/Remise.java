/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.insset.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import java.util.ArrayList;

/**
 *
 * @author user
 */
@SuppressWarnings("serial")
public class Remise extends RemoteServiceServlet {
    
    public float CalculRemise(float prixInitial, int taux) {
        return (prixInitial * taux) / 100;
    }
    
    public float CalculPrixFinal(float prixInitial, int taux) {
        float remise = this.CalculRemise(prixInitial, taux);
        return prixInitial - remise;
    }
}
