package com.byern.app.springapp.qualifier.service;

import com.byern.app.springapp.qualifier.api.MyService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by ByerN on 25.06.2017.
 */
@Service("A")
public class AService implements MyService {

    @Override
    public String sayHi() {
        return this.toString();
    }

}
