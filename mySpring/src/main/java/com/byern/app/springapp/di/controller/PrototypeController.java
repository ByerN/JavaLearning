package com.byern.app.springapp.di.controller;

import com.byern.app.springapp.di.core.BaseLoggableBean;
import com.byern.app.springapp.di.service.PrototypeBean;
import com.byern.app.springapp.di.service.SingletonBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ByerN on 25.06.2017.
 */
@Slf4j
@RestController
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@RequestMapping("/di/prototype")
public class PrototypeController extends BaseLoggableBean {

    private final SingletonBean singletonBean;
    private final PrototypeBean prototypeBean;

    @Autowired
    public PrototypeController(SingletonBean singletonBean,
                               PrototypeBean prototypeBean) {
        this.singletonBean = singletonBean;
        this.prototypeBean = prototypeBean;
    }

    @RequestMapping("/hi")
    public String sayHi(){
        return "Hi";
    }
}
