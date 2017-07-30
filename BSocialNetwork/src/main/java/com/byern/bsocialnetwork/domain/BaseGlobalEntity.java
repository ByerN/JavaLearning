package com.byern.bsocialnetwork.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

/**
 * Created by ByerN on 30.07.2017.
 */
@MappedSuperclass
@Getter
public class BaseGlobalEntity extends BaseEntity{

    @Column(name = "GLOBAL_ID", unique = true)
    private UUID globalId;

    public BaseGlobalEntity() {
        this.globalId = UUID.randomUUID();
    }
}
