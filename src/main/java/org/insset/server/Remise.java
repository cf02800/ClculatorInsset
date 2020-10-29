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
    
    public ArrayList CalculRemise(float prixInitial, int taux) {
        float remise = (prixInitial * taux) / 100;
        float prixFinal = prixInitial - remise;
        ArrayList lst = new ArrayList();
        lst.add(prixFinal);
        lst.add(remise);
        return lst;
    }
}
