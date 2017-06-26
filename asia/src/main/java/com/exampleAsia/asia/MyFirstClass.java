package com.exampleAsia.asia;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by asiasit on 23/06/2017.
 */
@Controller
public class MyFirstClass {

    @RequestMapping(value = "/hello/{name}")
    @ResponseBody
    public String getMyName(@PathVariable("name") String name) {
        return "Hello YOU :) " + name;
    }
}
