package com.byern.app.springapp.hello.controller;

import com.byern.app.springapp.hello.api.HelloEntity;
import com.byern.app.springapp.hello.api.HelloMessageDto;
import com.byern.app.springapp.hello.api.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by ByerN on 18.06.2017.
 */
@Controller
@RequestMapping("/hello")
public class HelloController {

    private final HelloService helloService;

    @Autowired
    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @ResponseBody
    @RequestMapping("/{name}")
    public HelloMessageDto sayHello(@PathVariable String name){
        return new HelloMessageDto(helloService.getHelloMessage(name));
    }

    @ResponseBody
    @RequestMapping("/register/{name}")
    public void registerNewName(@PathVariable String name){
        helloService.registerNewName(name);
    }

    @ResponseBody
    @RequestMapping("/all")
    public List<HelloEntity> getAllNames(){
        return helloService.getAllNames();
    }


}
