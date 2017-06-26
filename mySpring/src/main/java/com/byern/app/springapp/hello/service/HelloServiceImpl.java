package com.byern.app.springapp.hello.service;

import com.byern.app.springapp.hello.api.HelloEntity;
import com.byern.app.springapp.hello.api.dao.HelloMessageRepository;
import com.byern.app.springapp.hello.api.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ByerN on 18.06.2017.
 */
@Service
public class HelloServiceImpl implements HelloService {

    private final HelloMessageRepository helloMessageRepository;

    @Autowired
    public HelloServiceImpl(HelloMessageRepository helloMessageRepository) {
        this.helloMessageRepository = helloMessageRepository;
    }

    @Override
    public String getHelloMessage(String name) {
        return "Hello " + name + "!";
    }

    @Override
    public void registerNewName(String name){
        helloMessageRepository.save(new HelloEntity(name));
    }

    @Override
    public List<HelloEntity> getAllNames(){
        List<HelloEntity> result = new ArrayList<>();
        helloMessageRepository.findAll().iterator().forEachRemaining(helloEntity -> result.add(helloEntity));
        return result;
    }


}
