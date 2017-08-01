package com.byern.bsocialnetwork.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by ByerN on 30.07.2017.
 */

@Service
@Getter
public class ChatConfig {

    @Value("${BSocialNetwork.user.anonymousTimeOut}")
    private Integer anonymousUserTimeout;

}
