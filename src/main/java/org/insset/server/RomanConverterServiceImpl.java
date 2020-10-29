/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.insset.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import org.insset.client.service.RomanConverterService;

/**
 *
 * @author user
 */
@SuppressWarnings("serial")
public class RomanConverterServiceImpl extends RemoteServiceServlet implements
        RomanConverterService {

    public static final String[] chiffresRomains= {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
    public static final Integer[] chiffresArabes={1000,900,500,400,100,90,50,40,10,9,5,4,1};
    @Override
    public String convertDateYears(String nbr) throws IllegalArgumentException {
        //Implement your code
        return "XV/III/MX";
    }

    @Override
    public Integer convertRomanToArabe(String nbr) throws IllegalArgumentException {
        //Implement your code
        return 3;
    }

    /*
    * Méthode convertArabeToRoman convertit un nombre décimal en chiffres romains.
    * @parameter nbr : Integer (nombre décimal à convertir)
    * @return resultat : String
    */

    @Override
    public String convertArabeToRoman(Integer nbr) throws IllegalArgumentException {
        String resultat = "";
        Integer index = 0;
        while (nbr != 0) {
            if ((nbr - chiffresArabes[index]) < 0){
                index += 1;
            }
            else {
                resultat = resultat + chiffresRomains[index];
                nbr = nbr - chiffresArabes[index];
            }
        }
        return resultat;
    }

}
