/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.objis.DAO;

import com.objis.IDAO.IDAO;
import com.objis.entities.Speaker;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author yeo-sglo
 */
public class SpeakerDAO implements IDAO<Speaker, Long> {

    EntityManager em;

    public SpeakerDAO() {
        em = SingletonConnexion.getEntityManagerFactory().createEntityManager();
    }

    @Override
    public Speaker save(Speaker s) {
        if (s != null) {
            em.getTransaction().begin();
            em.persist(s);
            em.flush();
            em.getTransaction().commit();
        }
        return s;
    }

    @Override
    public Speaker update(Speaker s) {
        em.getTransaction().begin();
        em.merge(s);
        em.flush();
        em.getTransaction().commit();
        return s;
    }

    @Override
    public boolean delete(Long k) {
        Speaker speaker = em.find(Speaker.class, k);
        if (speaker != null) {
            em.getTransaction().begin();
            em.remove(speaker);
            em.flush();
            em.getTransaction().commit();
            return true;
        }
        return false;

    }

    @Override
    public Speaker findOne(Long k) {
        return em.find(Speaker.class, k);
    }

    @Override
    public List<Speaker> findAll() {
        return em.createQuery("SELECT s FROM Speaker s").getResultList();
    }

}
