package com.byern.app.springapp.hello.api.service;

import com.byern.app.springapp.hello.api.HelloEntity;

import java.util.List;

/**
 * Created by ByerN on 18.06.2017.
 */
public interface HelloService {

    String getHelloMessage(String name);

    void registerNewName(String name);

    List<HelloEntity> getAllNames();
}
