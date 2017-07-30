package com.byern.bsocialnetwork.dao;

import com.byern.bsocialnetwork.domain.BaseEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

/**
 * Created by ByerN on 30.07.2017.
 */
@Repository
public class BaseDaoImpl<T extends BaseEntity> implements BaseDao<T> {

    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    public void persist(T entity) {
        entityManager.persist(entity);
        entityManager.flush();
    }

    @Override
    public T merge(T entity) {
        return entityManager.merge(entity);
    }

    @Override
    public void refresh(T entity) {
        entityManager.refresh(entity);
    }

    @Override
    public T find(Class<T> clazz, Long id) {
        return entityManager.find(clazz, id);
    }

    @Override
    public List<T> findAll(Class<T> clazz) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(clazz);
        return entityManager.createQuery(cq.select(cq.from(clazz))).getResultList();
    }

    @Override
    public void remove(T entity) {
        entityManager.remove(entity);
    }
}
