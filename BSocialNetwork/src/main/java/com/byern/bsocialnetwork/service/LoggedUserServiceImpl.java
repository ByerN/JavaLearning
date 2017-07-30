package com.byern.bsocialnetwork.service;

import com.byern.bsocialnetwork.dao.AnonymousUserDao;
import com.byern.bsocialnetwork.domain.AnonymousUser;
import com.byern.bsocialnetwork.exception.SessionExpiredException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import javax.transaction.Transactional;
import java.time.ZonedDateTime;

/**
 * Created by ByerN on 30.07.2017.
 */

@Service
@Scope(WebApplicationContext.SCOPE_SESSION)
public class LoggedUserServiceImpl implements LoggedUserService{

    private AnonymousUser anonymousUser;

    @Autowired
    private AnonymousUserDao userDao;

    @Override
    public AnonymousUser getAnonymousUser() {
        return anonymousUser;
    }

    @Override
    @Transactional
    public AnonymousUser getLoggedUser() throws SessionExpiredException {
        if(anonymousUser == null){
            throw new SessionExpiredException();
        }
        anonymousUser = userDao.merge(anonymousUser);
        userDao.refresh(anonymousUser);
        anonymousUser.setLastActivityTime(ZonedDateTime.now());
        return anonymousUser;
    }


    @Override
    public void setAnonymousUser(AnonymousUser anonymousUser) {
        this.anonymousUser = anonymousUser;
    }
}
