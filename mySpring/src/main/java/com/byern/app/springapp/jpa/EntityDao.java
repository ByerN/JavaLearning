package com.byern.app.springapp.jpa;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

/**
 * Created by ByerN on 24.07.2017.
 */
public interface EntityDao {

    MyEntity getById(long id);

    List<MyEntity> getAll();

    void persist(MyEntity myEntity);

    void merge(MyEntity myEntity);

    void refresh(MyEntity myEntity);

    void remove(MyEntity myEntity);

    void detach(MyEntity myEntity);

}
