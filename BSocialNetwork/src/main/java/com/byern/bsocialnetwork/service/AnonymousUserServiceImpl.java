package com.byern.bsocialnetwork.service;

import com.byern.bsocialnetwork.dao.AnonymousUserDao;
import com.byern.bsocialnetwork.domain.AnonymousUser;
import com.byern.bsocialnetwork.dto.AnonymousRegisterDto;
import com.byern.bsocialnetwork.exception.UserAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import javax.transaction.Transactional;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

/**
 * Created by ByerN on 30.07.2017.
 */

@Service
@Scope(WebApplicationContext.SCOPE_SESSION)
public class AnonymousUserServiceImpl implements AnonymousUserService{

    private final AnonymousUserDao anonymousUserDao;
    private final LoggedUserService loggedUserService;

    @Autowired
    public AnonymousUserServiceImpl(AnonymousUserDao anonymousUserDao,
                                    LoggedUserService loggedUserService) {
        this.anonymousUserDao = anonymousUserDao;
        this.loggedUserService = loggedUserService;
    }

    @Override
    @Transactional
    public AnonymousUser register(AnonymousRegisterDto registerDto) throws UserAlreadyExistsException {
        String name = registerDto.getName();
        AnonymousUser oldUser = anonymousUserDao.findByName(name);
        AnonymousUser result;
        if(oldUser != null){
            result = processExistingUser(oldUser);
        } else {
            result = createNewUser(name);
        }
        loggedUserService.setAnonymousUser(result);
        return result;
    }

    @Override
    @Transactional
    public AnonymousUser getById(UUID anonymousUserId){
        AnonymousUser byGlobalId = anonymousUserDao.findByGlobalId(AnonymousUser.class, anonymousUserId);
        return byGlobalId;
    }

    @Override
    @Transactional
    public List<AnonymousUser> getAll(){
        return anonymousUserDao.findAll(AnonymousUser.class);
    }

    private AnonymousUser processExistingUser(AnonymousUser oldUser) throws UserAlreadyExistsException {
        AnonymousUser result;
        if(oldUser.getLastActivityTime().isAfter(ZonedDateTime.now().minusSeconds(10))){
            anonymousUserDao.remove(oldUser);
            result = createNewUser(oldUser.getName());
        } else {
            throw new UserAlreadyExistsException();
        }

        return result;
    }

    private AnonymousUser createNewUser(String name) {
        AnonymousUser newUser = new AnonymousUser(name);
        anonymousUserDao.persist(newUser);
        return newUser;
    }

}
