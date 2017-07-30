package com.byern.bsocialnetwork.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ByerN on 30.07.2017.
 */

@Entity
@Table(name = "ANONYMOUS_USER")
@NoArgsConstructor
@Getter
public class AnonymousUser extends BaseGlobalEntity {

    @Column(name = "NAME")
    private String name;

    @Column(name = "LAST_ACTIVITY_TIME")
    @Setter
    private ZonedDateTime lastActivityTime;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "user")
    private List<Message> messages = new ArrayList<>();

    public AnonymousUser(String name) {
        super();
        this.name = name;
        this.lastActivityTime = ZonedDateTime.now();
    }
}
