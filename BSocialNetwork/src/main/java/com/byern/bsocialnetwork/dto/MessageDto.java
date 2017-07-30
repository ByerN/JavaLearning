package com.byern.bsocialnetwork.dto;

import lombok.Getter;

/**
 * Created by ByerN on 30.07.2017.
 */
@Getter
public class MessageDto {

    private final String text;

    private final AnonymousUserDto user;

    public MessageDto(String text, AnonymousUserDto user) {
        this.text = text;
        this.user = user;
    }
}
