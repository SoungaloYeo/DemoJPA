/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.objis.DAO;

import com.objis.IDAO.IDAO;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author yeo_sglo la classe Service comporte la logic Metier commune à toute
 * nos classe d'ou l'implementation des methodes du CRUD
 * @param <T>
 * @param <PK>
 */
public abstract class  DAO<T, PK extends Serializable> implements IDAO<T, PK>{

    public String PERSISTENCE_UNIT_NAME = "pu-demo";

    protected EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    protected EntityManager em = emf.createEntityManager();
    
    /**
     * pour le gestion dynamique des classes pouvant contenir le parametre T de
     * notre classe, nous utilisons l'API Reflexion à fin de permetre
     * l'introspection:charger une classe ou même creer une instance sans
     * connaitre cette classe à fin de beneficier de ces savoir faire
     */
    private final Class<T> entityClass;

    /**
     * un constructure de la classe Service qui prend en parametre un objet
     * toujour avec l'API Reflexion declaré dynamy
     *
     * @param entityClass represente la classe sur laquelle portera le
     * traitement
     */
    public DAO(Class<T> entityClass) {
        this.entityClass = entityClass;
        em = emf.createEntityManager();
    }
    
    public T save(T t) {
        em.getTransaction().begin();
        em.persist(t);
        em.flush();
        em.getTransaction().commit();
        return t;
    }
    
    public T update(T t) {
        em.getTransaction().begin();
        em.merge(t);
        em.flush();
        em.getTransaction().commit();
        return t;
    }
    
    public boolean delete(PK pk) {
        T t = em.find(entityClass, pk);
        if (t != null) {
            em.getTransaction().begin();
            em.remove(t);
            em.flush();
            em.getTransaction().commit();
//            em.close();
            return true;
        }
        return true;
    }
    
    @SuppressWarnings("JPQLValidation")
    public boolean deleteAll() {
        em.getTransaction().begin();
        int executQ = em.createQuery("DELETE FROM " + entityClass.getSimpleName()).executeUpdate();
        em.flush();
        em.getTransaction().commit();
//        em.close();
        return (executQ >= 0);
    }
    
    public T findOne(PK pk) {
        return em.find(entityClass, pk);
    }
    
    @SuppressWarnings("JPQLValidation")
    public List<T> findAll() {
        return em.createQuery("SELECT t FROM " + entityClass.getSimpleName() + " t").getResultList();
    }

}
