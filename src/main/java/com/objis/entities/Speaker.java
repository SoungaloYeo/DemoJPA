/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.objis.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author yeo-sglo
 */
@Entity
@Table(name = "speaker")
public class Speaker {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nom;
    private String prnom;
    
    @ManyToOne
    @JoinColumn(name = "id_salle")
    private Salle salle;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrnom() {
        return prnom;
    }

    public void setPrnom(String prnom) {
        this.prnom = prnom;
    }

    public Salle getSalle() {
        return salle;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }
    
    public Speaker(){
        
    }

    public Speaker(String nom, String prnom, Salle salle) {
        this.nom = nom;
        this.prnom = prnom;
        this.salle = salle;
    }

    @Override
    public String toString() {
        return "Speaker{" + "id=" + id + ", nom=" + nom + ", prnom=" + prnom + ", salle=" + salle + '}';
    }

      
    

}
