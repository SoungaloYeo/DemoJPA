/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.objis.ui;

import com.objis.entities.Salle;
import com.objis.entities.Speaker;
import com.objis.DAO.SalleDAO;
import com.objis.DAO.SpeakerDAO;
import com.objis.DAO.ThemeDAO;
import com.objis.entities.Theme;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author yeo-sglo
 */
public class Lanceur {

    public static void main(String[] args) {

        //en fonction d'un traitement à realiser sur telle ou telle table vous pouvez utiliser l'un des objes suisvant
        SalleDAO salleDAO = new SalleDAO();
        ThemeDAO themeDAO = new ThemeDAO();
        SpeakerDAO speakerDao = new SpeakerDAO();

        Salle salle = new Salle(20, "AUTRE atelier");
        
        //enregistrer une salle
        salleDAO.save(salle);
        
        //afficher une salle
        System.out.println("******************* afficher une salle dont on connait l'Id *******************");
        System.out.println(salleDAO.findOne(1L)); // on met 1L car il s'agit d'un type Long
        

        Theme theme = new Theme("JPA :Java Persistence API", null);
        Theme theme2 = new Theme("API :Application Programming Interface", null);
        
        //enrg. d'un theme
        themeDAO.save(theme);
        themeDAO.save(theme2);
        
        //affichage de tous les themes
        System.out.println("***************************** affichage de tous les themes **************************");
        System.out.println(themeDAO.findAll());
        
    }

}
