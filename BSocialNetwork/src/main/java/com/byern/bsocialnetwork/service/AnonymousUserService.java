package com.byern.bsocialnetwork.service;

import com.byern.bsocialnetwork.domain.AnonymousUser;
import com.byern.bsocialnetwork.dto.AnonymousRegisterDto;
import com.byern.bsocialnetwork.exception.UserAlreadyExistsException;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

/**
 * Created by ByerN on 30.07.2017.
 */
public interface AnonymousUserService {

    AnonymousUser register(AnonymousRegisterDto registerDto) throws UserAlreadyExistsException;

    AnonymousUser getById(UUID anonymousUserId);

    List<AnonymousUser> getAll();
}
