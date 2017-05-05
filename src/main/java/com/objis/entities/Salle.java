/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.objis.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author yeo-sglo
 */
@Entity
public class Salle implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int nbrPlace;
    private String designation;

    @OneToMany(mappedBy = "salle")
    private List<Speaker> listSpeaker;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNbrPlace() {
        return nbrPlace;
    }

    public void setNbrPlace(int nbrPlace) {
        this.nbrPlace = nbrPlace;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public List<Speaker> getListSpeaker() {
        return listSpeaker;
    }

    public void setListSpeaker(List<Speaker> listSpeaker) {
        this.listSpeaker = listSpeaker;
    }

    public Salle() {
    }

    public Salle(int nbrPlace, String designation) {
        this.nbrPlace = nbrPlace;
        this.designation = designation;
    }

    @Override
    public String toString() {
        return "Salle{" + "id=" + id + ", nbrPlace=" + nbrPlace + ", designation=" + designation + '}';
    }

}
