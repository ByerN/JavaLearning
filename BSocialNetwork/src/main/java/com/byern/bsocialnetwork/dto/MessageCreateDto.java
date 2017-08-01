package com.byern.bsocialnetwork.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by ByerN on 30.07.2017.
 */
@AllArgsConstructor
@Getter
public class MessageCreateDto {

    @NotBlank
    private final String text;
}
