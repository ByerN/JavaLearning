package com.byern.app.springapp.mavendi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ByerN on 25.06.2017.
 */
@RestController
@RequestMapping("/maven-di")
public class MavenDiController {

    private final HelloService helloService;

    @Autowired
    public MavenDiController(HelloService helloService) {
        this.helloService = helloService;
    }

    @RequestMapping("/hi")
    public String sayHi(){
        return helloService.getMessage();
    }
}
