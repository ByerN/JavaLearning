package com.byern.app.springapp.di.core;

import lombok.extern.slf4j.Slf4j;

import javax.annotation.PostConstruct;

/**
 * Created by ByerN on 25.06.2017.
 */
@Slf4j
public class BaseLoggableBean {

    protected BaseLoggableBean(){
    }

    @PostConstruct
    public void doPostContruct(){
        log.info(this + " initialized.");
    }

}
