/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.insset.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import java.util.ArrayList;
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
    
    /*
    * Méthode convertDateYears convertit une date de naissance en chiffres romains.
    * @parameter nbr : Integer (nombre décimal à convertir)
    * @return resultat : String
    */
    
    @Override
    public String convertDateYears(String nbr) throws IllegalArgumentException {
        String resultat = "";
        String n = "";
        RomanConverterServiceImpl converter = new RomanConverterServiceImpl();
        for (int i = 0; i < nbr.length(); i++){
            if ("/".equals(String.valueOf(nbr.charAt(i)))) {
                resultat = resultat + converter.convertArabeToRoman(Integer.parseInt(n));
                resultat = resultat + "/";
                n = "";
            }
            else {
                n = n + String.valueOf(nbr.charAt(i));
            }
        }
        resultat = resultat + converter.convertArabeToRoman(Integer.parseInt(n));
        return resultat;
    }

    @Override
    public Integer convertRomanToArabe(String nbr) throws IllegalArgumentException {
        RomanConverterServiceImpl instance = new RomanConverterServiceImpl();
        Integer v1 = chiffresArabes[instance.findRomanIdByValue(String.valueOf(nbr.charAt(0)))];
        Integer v2 = 0;
        Integer resultat = v1;
        for (int i = 1; i < nbr.length(); i++){
            v2 = chiffresArabes[instance.findRomanIdByValue(String.valueOf(nbr.charAt(i)))];

            if (v2 <= v1){
                resultat = resultat + v2;
            }
            else {
                resultat = resultat + v2 - (2*v1);
            }
            v1 = v2;
        }
        System.out.print(resultat);
        return resultat;
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

    public Integer findRomanIdByValue(String value) {
        Integer id = 0;
        for (int i = 0; i < chiffresRomains.length; i++){
            if (chiffresRomains[i].equals(value)){
                id = i;
            }
        }
        return id;
    }
}
