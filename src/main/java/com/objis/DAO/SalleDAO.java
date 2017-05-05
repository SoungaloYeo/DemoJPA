/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.objis.DAO;

import com.objis.IDAO.IDAO;
import com.objis.entities.Salle;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author yeo-sglo
 */
public class SalleDAO implements IDAO<Salle, Long> {

    public EntityManager em;

    /**
     * un constructure de la classe SalleDAO qui permet d'initialiser notre 
     * "em" EntityManager
     *
     */
    public SalleDAO() {
        em = SingletonConnexion.getEntityManagerFactory().createEntityManager();
    }

    @Override
    public Salle save(Salle salle) {
        em.getTransaction().begin();
        em.persist(salle);
        em.flush();
        em.getTransaction().commit();
        return salle;
    }

    @Override
    public Salle update(Salle salle) {
        em.getTransaction().begin();
        em.merge(salle);
        em.flush();
        em.getTransaction().commit();
        return salle;
    }

    @Override
    public boolean delete(Long pk) {
        Salle salle = em.find(Salle.class, pk);
        if (salle != null) {
            em.getTransaction().begin();
            em.remove(salle);
            em.flush();
            em.getTransaction().commit();
            return true;
        }
        return false;
    }

    @Override
    public Salle findOne(Long pk) {
        return em.find(Salle.class, pk);
    }

    @Override
    public List<Salle> findAll() {
        return em.createQuery("SELECT s FROM Salle s").getResultList();
    }

}
