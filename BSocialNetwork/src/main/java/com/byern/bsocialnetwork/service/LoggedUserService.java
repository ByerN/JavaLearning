package com.byern.bsocialnetwork.service;

import com.byern.bsocialnetwork.domain.AnonymousUser;
import com.byern.bsocialnetwork.exception.SessionExpiredException;

/**
 * Created by ByerN on 30.07.2017.
 */
public interface LoggedUserService {

    AnonymousUser getAnonymousUser();

    AnonymousUser getLoggedUser() throws SessionExpiredException;

    void setAnonymousUser(AnonymousUser anonymousUser);

}
