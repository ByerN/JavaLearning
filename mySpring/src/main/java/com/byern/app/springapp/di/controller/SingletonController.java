package com.byern.app.springapp.di.controller;

import com.byern.app.springapp.di.core.BaseLoggableBean;
import com.byern.app.springapp.di.service.PrototypeBean;
import com.byern.app.springapp.di.service.SingletonBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by ByerN on 25.06.2017.
 */
@Slf4j
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
@RequestMapping("/di/singleton")
public class SingletonController extends BaseLoggableBean {

    private final SingletonBean singletonBean;
    private final PrototypeBean prototypeBean;

    @Autowired
    public SingletonController(SingletonBean singletonBean,
                               PrototypeBean prototypeBean) {
        this.singletonBean = singletonBean;
        this.prototypeBean = prototypeBean;
    }

    @RequestMapping("/hi")
    @ResponseBody
    public String sayHi(){
        return "Hi";
    }
}
