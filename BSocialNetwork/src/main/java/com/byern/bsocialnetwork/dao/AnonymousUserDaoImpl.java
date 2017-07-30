package com.byern.bsocialnetwork.dao;

import com.byern.bsocialnetwork.domain.AnonymousUser;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by ByerN on 30.07.2017.
 */
@Repository
public class AnonymousUserDaoImpl extends BaseGlobalIdDaoImpl<AnonymousUser> implements AnonymousUserDao {

    @Override
    public AnonymousUser findByName(String name) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<AnonymousUser> cq = cb.createQuery(AnonymousUser.class);
        Root<AnonymousUser> root = cq.from(AnonymousUser.class);
        cq.select(root).where(cb.equal(root.get("name"), name));
        List<AnonymousUser> resultList = entityManager.createQuery(cq).getResultList();
        return resultList.isEmpty() ? null : resultList.get(0);
    }
}
