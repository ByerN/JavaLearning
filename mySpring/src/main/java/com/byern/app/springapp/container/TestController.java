package com.byern.app.springapp.container;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;

/**
 * Created by ByerN on 25.06.2017.
 */
@Controller
@RequestMapping("/container")
public class TestController {

    @Autowired
    private ApplicationContext applicationContext;

    @RequestMapping("/hi")
    @ResponseBody
    public String sayHi(){
        return Arrays.toString(applicationContext.getBeanDefinitionNames());
    }
}
