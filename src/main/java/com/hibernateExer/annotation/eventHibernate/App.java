package com.hibernateExer.annotation.eventHibernate;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.config.AppConfig;
import com.example.model.Event;
import com.example.model.EventDaoImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
			EventDaoImpl eventDaoImpl = context.getBean(EventDaoImpl.class);
			try {
			Event event=new Event("cricket","sports","kolkata",100,200);
			
			eventDaoImpl.insertEvent(event);
			}
			catch(IllegalArgumentException e)
			{
				System.out.println("Illegal object trying to be inserted");
			}
//			List<Event> eventlist=eventDaoImpl.getAllEvents();
//			System.out.println(eventlist);
			List<Event> eventList=eventDaoImpl.getById(1);
			System.out.println(eventList.get(0).getEveName());

			}
}
