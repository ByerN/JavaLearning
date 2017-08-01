package com.byern.bsocialnetwork.controller;

import com.byern.bsocialnetwork.domain.AnonymousUser;
import com.byern.bsocialnetwork.dto.AnonymousRegisterDto;
import com.byern.bsocialnetwork.dto.AnonymousUserDto;
import com.byern.bsocialnetwork.exception.UserAlreadyExistsException;
import com.byern.bsocialnetwork.exception.UserNotFoundException;
import com.byern.bsocialnetwork.service.AnonymousUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by ByerN on 30.07.2017.
 */

@Controller
@Scope(WebApplicationContext.SCOPE_SESSION)
@RequestMapping("/anonymous")
public class AnonymousProfileController {

    private final AnonymousUserService anonymousUserService;

    @Autowired
    public AnonymousProfileController(AnonymousUserService anonymousUserService) {
        this.anonymousUserService = anonymousUserService;
    }


    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public AnonymousUserDto registerUser(@Validated @RequestBody AnonymousRegisterDto anonymousRegisterDto)
        throws UserAlreadyExistsException {
        AnonymousUser anonymousUser = anonymousUserService.register(anonymousRegisterDto);
        return new AnonymousUserDto(anonymousUser.getName(), anonymousUser.getGlobalId());
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<AnonymousUserDto> findAllUsers() {
        List<AnonymousUser> anonymousUsers = anonymousUserService.getAll();
        List<AnonymousUserDto> result = new ArrayList<>(anonymousUsers.size());

        for(AnonymousUser anonymousUser : anonymousUsers){
            result.add(new AnonymousUserDto(anonymousUser.getName(), anonymousUser.getGlobalId()));
        }

        return result;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public AnonymousUserDto findUser(@PathVariable("id") UUID id) throws UserNotFoundException {
        AnonymousUser anonymousUser = anonymousUserService.getById(id);
        if(anonymousUser == null){
            throw new UserNotFoundException();
        }
        return new AnonymousUserDto(anonymousUser.getName(), anonymousUser.getGlobalId());
    }

}
