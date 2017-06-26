package com.byern.app.springapp.di.service;

import com.byern.app.springapp.di.core.BaseLoggableBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.PostConstruct;

/**
 * Created by ByerN on 25.06.2017.
 */
@Slf4j
@Component
@Scope(WebApplicationContext.SCOPE_SESSION)
public class HttpSessionBean  extends BaseLoggableBean {

}
