package org.byern.javalearning.lesson15.ocp.good.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by krzyspo on 10/06/2017.
 */
@AllArgsConstructor
@Getter
@Setter
public class Message{
    private String subject;
    private String body;
    private String from;
    private String to;
}