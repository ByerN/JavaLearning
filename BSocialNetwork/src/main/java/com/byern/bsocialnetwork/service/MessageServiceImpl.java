package com.byern.bsocialnetwork.service;

import com.byern.bsocialnetwork.dao.MessageDao;
import com.byern.bsocialnetwork.domain.AnonymousUser;
import com.byern.bsocialnetwork.domain.Message;
import com.byern.bsocialnetwork.dto.MessageCreateDto;
import com.byern.bsocialnetwork.exception.SessionExpiredException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by ByerN on 30.07.2017.
 */
@Service
@Scope(WebApplicationContext.SCOPE_SESSION)
public class MessageServiceImpl implements MessageService {

    private final MessageDao messageDao;
    private final LoggedUserService loggedUserService;

    @Autowired
    public MessageServiceImpl(MessageDao messageDao,
                              LoggedUserService loggedUserService) {
        this.messageDao = messageDao;
        this.loggedUserService = loggedUserService;
    }


    @Override
    @Transactional
    public Message createMessage(MessageCreateDto messageCreateDto) throws SessionExpiredException {
        AnonymousUser loggedUser = loggedUserService.getLoggedUser();
        Message message = new Message(
            messageCreateDto.getText(),
            loggedUser
        );
        messageDao.persist(message);
        return message;
    }

    @Override
    public List<Message> getMessages() {
        List<Message> messageList = messageDao.findAll(Message.class);
        Collections.sort(messageList, new Comparator<Message>() {
            @Override
            public int compare(Message o1, Message o2) {
                return o1.getDateTime().compareTo(o2.getDateTime());
            }
        });
        return messageList;
    }
}
