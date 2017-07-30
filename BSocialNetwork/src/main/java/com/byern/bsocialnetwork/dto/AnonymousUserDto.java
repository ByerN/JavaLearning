package com.byern.bsocialnetwork.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

/**
 * Created by ByerN on 30.07.2017.
 */

@AllArgsConstructor
@Getter
public class AnonymousUserDto {

    private String name;

    private UUID globalId;
}
