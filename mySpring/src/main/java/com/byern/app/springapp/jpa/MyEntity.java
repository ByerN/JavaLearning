package com.byern.app.springapp.jpa;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by ByerN on 24.07.2017.
 */

@Entity(name = "MY_ENTITY")
@Setter
@Getter
public class MyEntity {

    //has to be here
    private MyEntity() {
    }

    @Id
    @GeneratedValue
    private Long id;

    @Version
    private Long version;

    @Column(name = "FIELD_1")
    private String field1;

    private String field2;

    public MyEntity(String field1, String field2) {
        this.field1 = field1;
        this.field2 = field2;
    }
}
