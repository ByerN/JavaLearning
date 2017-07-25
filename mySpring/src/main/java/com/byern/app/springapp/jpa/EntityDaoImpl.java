package com.byern.app.springapp.jpa;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

/**
 * Created by ByerN on 24.07.2017.
 */

@Repository
public class EntityDaoImpl implements EntityDao{

    @PersistenceContext
    private EntityManager entityManager;

    public MyEntity getById(long id){
        return entityManager.find(MyEntity.class, id);
    }

    public List<MyEntity> getAll(){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<MyEntity> query = criteriaBuilder.createQuery(MyEntity.class);
        query.select(query.from(MyEntity.class));
        return entityManager.createQuery(query).getResultList();
    }


    public void persist(MyEntity myEntity){
        entityManager.persist(myEntity);
    }

    public void merge(MyEntity myEntity){
        entityManager.merge(myEntity);
    }

    public void refresh(MyEntity myEntity){
        entityManager.refresh(myEntity);
    }

    public void remove(MyEntity myEntity){
        entityManager.remove(myEntity);
    }

    public void detach(MyEntity myEntity){
        entityManager.detach(myEntity);
    }

}
