package com.byern.bsocialnetwork.dao;

import com.byern.bsocialnetwork.domain.BaseEntity;
import com.byern.bsocialnetwork.domain.BaseGlobalEntity;

import java.util.UUID;

/**
 * Created by ByerN on 30.07.2017.
 */
public interface BaseGlobalIdDao<T extends BaseGlobalEntity> extends BaseDao<T> {

    T findByGlobalId(Class<T> clazz, UUID globalId);


}
