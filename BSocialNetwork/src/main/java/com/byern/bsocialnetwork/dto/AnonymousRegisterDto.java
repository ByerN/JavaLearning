package com.byern.bsocialnetwork.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotNull;

/**
 * Created by ByerN on 30.07.2017.
 */

@AllArgsConstructor
@Getter
public class AnonymousRegisterDto {

    @NotNull
    private String name;

}
