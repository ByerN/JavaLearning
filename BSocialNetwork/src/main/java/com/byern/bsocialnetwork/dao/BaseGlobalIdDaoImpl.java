package com.byern.bsocialnetwork.dao;

import com.byern.bsocialnetwork.domain.BaseGlobalEntity;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.UUID;

/**
 * Created by ByerN on 30.07.2017.
 */
@Service
public class BaseGlobalIdDaoImpl<T extends BaseGlobalEntity>
    extends BaseDaoImpl<T> implements BaseGlobalIdDao<T> {

    @Override
    public T findByGlobalId(Class<T> clazz, UUID globalId) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(clazz);
        Root<T> root = cq.from(clazz);
        List<T> resultList = entityManager.createQuery(
            cq.select(
                root
            ).where(
                cb.equal(root.get("globalId"), globalId)
            )
        ).getResultList();
        return resultList.isEmpty() ? null : resultList.get(0);
    }
}
