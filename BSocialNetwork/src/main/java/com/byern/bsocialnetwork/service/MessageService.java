package com.byern.bsocialnetwork.service;

import com.byern.bsocialnetwork.domain.Message;
import com.byern.bsocialnetwork.dto.MessageCreateDto;
import com.byern.bsocialnetwork.exception.SessionExpiredException;

import java.util.List;

/**
 * Created by ByerN on 30.07.2017.
 */
public interface MessageService {

    Message createMessage(MessageCreateDto messageCreateDto) throws SessionExpiredException;

    List<Message> getMessages();

}
