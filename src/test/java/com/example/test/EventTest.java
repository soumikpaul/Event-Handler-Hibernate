package com.example.test;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;

import com.example.config.AppConfig;
import com.example.model.Event;
import com.example.model.EventDaoImpl;

@ContextConfiguration(
        classes = { AppConfig.class })
public class EventTest {
	EventDaoImpl eventDao;
    @BeforeEach
    public void beforeEachTest() {
        ApplicationContext appCntxt = new AnnotationConfigApplicationContext(com.example.config.AppConfig.class);
        eventDao = appCntxt.getBean(EventDaoImpl.class);
        
        eventDao.insertEvent(new Event("cricket","sports","kolkata",100,200));
        
    }

    @Test
    public void retrieveAllRecords() {
        int actualResult = eventDao.getAllEvents().size();
        int expectedResult = 1;
        Assertions.assertEquals(actualResult,expectedResult);
        
    }
    @Test
    public void testingIllegalObjInsertion()
    {
    	Event event=null;
        Assertions.assertThrows(IllegalArgumentException.class, ()->eventDao.insertEvent(event));
    }
    @Test
    public void retrieveById() {
    	int x=1;
        int actualResult = eventDao.getById(x).size();
        int expectedResult = 1;
        Assertions.assertEquals(actualResult,expectedResult);
    	
    }
    @Test
    public void testingMaxId() {
    	int x=100;
    	int actualResult=eventDao.getById(x).size();
        Assertions.assertEquals(actualResult,0);

       // Assertions.assertThrows(IllegalArgumentException.class, ()->eventDao.getById(x));
    }

}
