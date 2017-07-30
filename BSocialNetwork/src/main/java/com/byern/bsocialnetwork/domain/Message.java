package com.byern.bsocialnetwork.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.ZonedDateTime;

/**
 * Created by ByerN on 30.07.2017.
 */

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Message extends BaseGlobalEntity {

    @Column(name = "TEXT")
    private String text;

    @Column(name = "DATE_TIME")
    private ZonedDateTime dateTime;

    @ManyToOne(optional = false)
    @JoinColumn(name = "USER_ID")
    private AnonymousUser user;

    public Message(String text, AnonymousUser user) {
        this.text = text;
        this.dateTime = ZonedDateTime.now();
        this.user = user;
    }
}
