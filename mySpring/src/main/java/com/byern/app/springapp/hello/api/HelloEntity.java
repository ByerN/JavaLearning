package com.byern.app.springapp.hello.api;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by ByerN on 18.06.2017.
 */
@Entity
@Getter
@NoArgsConstructor
public class HelloEntity {

    @Id
    @GeneratedValue
    private long id;

    @Column
    private String name;

    public HelloEntity(@NonNull String name) {
        this.name = name;
    }
}
