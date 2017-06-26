package com.wiktor.SpringApp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by c-wiktor on 26/06/2017.
 */
@Controller
public class Hello {
    @RequestMapping(value = "/hello/{name}")
    @ResponseBody
    public String getHello(@PathVariable("name") String name){
        return "Hello " + name + "!";
    }
}
