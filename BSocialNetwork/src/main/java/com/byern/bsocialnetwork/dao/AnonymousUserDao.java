package com.byern.bsocialnetwork.dao;

import com.byern.bsocialnetwork.domain.AnonymousUser;

/**
 * Created by ByerN on 30.07.2017.
 */
public interface AnonymousUserDao extends BaseGlobalIdDao<AnonymousUser>{

    AnonymousUser findByName(String name);

}
