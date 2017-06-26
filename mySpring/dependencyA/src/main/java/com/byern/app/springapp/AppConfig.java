package com.byern.app.springapp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * Created by ByerN on 25.06.2017.
 */
@Slf4j
@Configuration
@ComponentScan(basePackages = "some.pack.a")
public class AppConfig {

    @PostConstruct
    public void postInit(){
        log.debug("initialized");
    }
}
