/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.objis.IDAO;

import com.objis.entities.Salle;
import java.util.List;

/**
 *
 * @author yeo-sglo
 */
public interface IDAO<T, PK> {

    public T save(T t);

    public T update(T t);

    public boolean delete(PK k);

    public T findOne(PK k);

    public List<T> findAll();
}
