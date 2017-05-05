/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.objis.DAO;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author yeo-sglo
 */
public class SingletonConnexion {
    
    private static final String PERSISTENCE_UNIT_NAME = "pu-demo";
    private static EntityManagerFactory emf = null; //chargé d'initialiser les objets definis dans le persistence unit 

    private SingletonConnexion() {
    }   
    
    public static EntityManagerFactory getEntityManagerFactory(){
        if(emf == null){
            emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        return emf;
    }
    
}
