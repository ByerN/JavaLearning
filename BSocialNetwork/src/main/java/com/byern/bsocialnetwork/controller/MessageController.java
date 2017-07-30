package com.byern.bsocialnetwork.controller;

import com.byern.bsocialnetwork.dao.BaseDao;
import com.byern.bsocialnetwork.domain.AnonymousUser;
import com.byern.bsocialnetwork.domain.Message;
import com.byern.bsocialnetwork.dto.AnonymousUserDto;
import com.byern.bsocialnetwork.dto.MessageCreateDto;
import com.byern.bsocialnetwork.dto.MessageDto;
import com.byern.bsocialnetwork.exception.SessionExpiredException;
import com.byern.bsocialnetwork.service.LoggedUserService;
import com.byern.bsocialnetwork.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by ByerN on 30.07.2017.
 */
@RestController
@Scope(WebApplicationContext.SCOPE_SESSION)
public class MessageController {

    private final BaseDao<Message> messageDao;
    private final MessageService messageService;

    @Autowired
    public MessageController(BaseDao<Message> messageDao,
                             MessageService messageService1) {
        this.messageDao = messageDao;
        this.messageService = messageService1;
    }

    @RequestMapping(value = "/messages", method = RequestMethod.POST)
    public MessageDto createMessage(@RequestBody MessageCreateDto messageCreateDto) throws SessionExpiredException {
        Message message = messageService.createMessage(messageCreateDto);
        AnonymousUser user = message.getUser();
        return new MessageDto(
            message.getText(),
            new AnonymousUserDto(
                user.getName(),
                user.getGlobalId()
            )
        );
    }

    @RequestMapping("/messages")
    public List<MessageDto> getAllMessages() {
        List<MessageDto> result = new ArrayList<>();

        List<Message> messageList = messageService.getMessages();
        for (Message message : messageList){
            result.add(
                new MessageDto(
                    message.getText(),
                    new AnonymousUserDto(
                        message.getUser().getName(),
                        message.getUser().getGlobalId()
                    )
                )
            );
        }

        return result;
    }

}
