package com.byern.app.springapp.di.controller;

import com.byern.app.springapp.di.core.BaseLoggableBean;
import com.byern.app.springapp.di.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by ByerN on 25.06.2017.
 */
@Slf4j
@Controller
@Scope(WebApplicationContext.SCOPE_SESSION)
@RequestMapping("/di/session")
public class SessionController extends BaseLoggableBean {

    @Autowired
    private HttpRequestBean httpRequestBean;

    private HttpSessionBean httpSessionBean;
    private final SingletonBean singletonBean;
    private final PrototypeBean prototypeBean;

    @Autowired
    public SessionController(SingletonBean singletonBean,
                             PrototypeBean prototypeBean) {
        this.singletonBean = singletonBean;
        this.prototypeBean = prototypeBean;
    }

    @Autowired
    public void setHttpSessionBean(HttpSessionBean httpSessionBean) {
        this.httpSessionBean = httpSessionBean;
    }

    @RequestMapping("/hi")
    @ResponseBody
    public String sayHi(){
        return "Hi";
    }
}
