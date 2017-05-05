/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.objis.DAO;

import com.objis.IDAO.IDAO;
import com.objis.entities.Theme;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author yeo-sglo
 */
public class ThemeDAO implements IDAO<Theme, Long> {

    public EntityManager em;

    public ThemeDAO() {
        em = SingletonConnexion.getEntityManagerFactory().createEntityManager();
        
    }

    @Override
    public Theme save(Theme t) {
        if (t != null) {
            em.getTransaction().begin();
            em.persist(t);
            em.flush();
            em.getTransaction().commit();
        }
        return t;
    }

    @Override
    public Theme update(Theme t) {
        em.getTransaction().begin();
        em.merge(t);
        em.flush();
        em.getTransaction().commit();
        return t;
    }

    @Override
    public boolean delete(Long k) {
        Theme theme = em.find(Theme.class, k);
        if (theme != null) {
            em.getTransaction().begin();
            em.remove(theme);
            em.flush();
            em.getTransaction().commit();
            return true;
        }
        return false;
    }

    @Override
    public Theme findOne(Long k) {
        return em.find(Theme.class, k);
    }

    @Override
    public List<Theme> findAll() {
        return em.createQuery("SELECT t FROM Theme t").getResultList();
    }

}
