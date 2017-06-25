package com.byern.app.springapp.qualifier;

import com.byern.app.springapp.qualifier.api.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by ByerN on 25.06.2017.
 */
@RestController
@RequestMapping("/qualifier")
public class QualifierController {

    private final MyService myService;
    private final List<MyService> allServices;

    @Autowired
    public QualifierController(@Qualifier("A") MyService myService,
                               List<MyService> allServices) {
        this.myService = myService;
        this.allServices = allServices;
    }

    @RequestMapping("/hi")
    public String sayHi(){
        return myService.sayHi();
    }

    @RequestMapping("/hi/all")
    public String sayHiAll(){
        return Arrays.toString(allServices.toArray());
    }
}
