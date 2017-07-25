package com.byern.app.springapp.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ByerN on 24.07.2017.
 */
@RestController
@RequestMapping("/jpa")
public class CrudController {

    //http://localhost/h2-console
    //jdbc:h2:mem:testdb

    private final EntityDao entityDao;

    @Autowired
    public CrudController(EntityDao entityDao) {
        this.entityDao = entityDao;
    }


    @RequestMapping(value = "/entities", method = RequestMethod.GET)
    public List<MyEntity> getEntities(){
        return entityDao.getAll();
    }

    @RequestMapping(value = "/entities/{id}", method = RequestMethod.GET)
    public MyEntity getEntityById(@PathVariable long id){
        entityDao.getById(id);
        entityDao.getById(id);
        entityDao.getById(id);
        return entityDao.getById(id);
    }

    @Transactional
    @RequestMapping(value = "/entities", method = RequestMethod.POST)
    public MyEntity create(@RequestBody MyEntityDto myEntityDto){
        MyEntity myEntity = new MyEntity(myEntityDto.getField1(), myEntityDto.getField2());
        entityDao.persist(myEntity);
        return myEntity;
    }

    @Transactional
    @RequestMapping(value = "/entities", method = RequestMethod.PUT)
    public List<MyEntity> updateAll(@RequestBody MyEntityDto myEntityDto){
        List<MyEntity> entities = entityDao.getAll();
        for(MyEntity myEntity : entities) {
            myEntity.setField1(myEntityDto.getField1());
            myEntity.setField2(myEntityDto.getField2());
        }
        return entities;
    }

    @Transactional
    @RequestMapping(value = "/entities/{id}", method = RequestMethod.PUT)
    public MyEntity update(@PathVariable Long id,
                           @RequestBody MyEntityDto myEntityDto){
        MyEntity myEntity = entityDao.getById(id);
        entityDao.getById(id);
        entityDao.getById(id);
        entityDao.getById(id);
        myEntity.setField1(myEntityDto.getField1());
        myEntity.setField2(myEntityDto.getField2());
        return myEntity;
    }

    @Transactional
    @RequestMapping(value = "/entities", method = RequestMethod.DELETE)
    public void deleteAll(){
        List<MyEntity> entities = entityDao.getAll();
        for(MyEntity myEntity : entities) {
            entityDao.remove(myEntity);
        }
    }

    @Transactional
    @RequestMapping(value = "/entities/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        MyEntity myEntity = entityDao.getById(id);
        entityDao.remove(myEntity);
    }
}
