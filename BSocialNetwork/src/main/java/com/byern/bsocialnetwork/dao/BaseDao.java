package com.byern.bsocialnetwork.dao;

import com.byern.bsocialnetwork.domain.BaseEntity;

import java.util.List;

/**
 * Created by ByerN on 30.07.2017.
 */
public interface BaseDao<T extends BaseEntity> {

    void persist(T entity);

    T merge(T entity);

    void refresh(T entity);

    T find(Class<T> clazz, Long id);

    List<T> findAll(Class<T> clazz);

    void remove(T entity);
}
