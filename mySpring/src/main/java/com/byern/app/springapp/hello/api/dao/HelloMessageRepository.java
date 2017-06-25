package com.byern.app.springapp.hello.api.dao;

import com.byern.app.springapp.hello.api.HelloEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by ByerN on 18.06.2017.
 */
public interface HelloMessageRepository extends CrudRepository<HelloEntity, Long>{

    List<HelloEntity> findByName(String name);

}
