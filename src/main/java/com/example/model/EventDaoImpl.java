package com.example.model;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hibernateExer.annotation.eventHibernate.App;



@Repository
@Transactional(readOnly = true)
public class EventDaoImpl {
	final Logger Log = Logger.getLogger(App.class.getName());

	@Autowired
	private SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public void insertEvent(Event event) throws IllegalArgumentException
    {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        session.save(event);
        session.getTransaction().commit();
        session.close();
    }
    public List<Event> getAllEvents() {
    	try {
        Session session = sessionFactory.openSession();
        String hql = "FROM Event";
        Query query = session.createQuery(hql);
        List<Event> emList = query.list();
        session.close();
        return emList;
    	}
    	catch(Exception e)
    	{
    		Log.error("Error occured while getting all events   "+e);
    		return null;
    	}
  }
    public List<Event> getByEventType(String type){
    	try {
    	Session session = sessionFactory.openSession();
        String hql = "FROM Event E WHERE E.eveType=:dummyType";
        
        Query query = session.createQuery(hql);
        query.setParameter("dummyType", type);

        List<Event> emList = query.list();
        session.close();
        return emList;
    	}
    	catch(Exception e)
    	{
    		Log.error("Error occured while getting all events by type  "+e);
    		return null;
    	}
    	
    }
    public List<Event> getByCity(String city){
    	try {
    	Session session = sessionFactory.openSession();
        String hql = "FROM Event E WHERE E.city=:dummyCity";
        
        Query query = session.createQuery(hql);
        query.setParameter("dummyCity", city);

        List<Event> emList = query.list();
        session.close();
        return emList;
    	}
    	catch(Exception e)
    	{
    		Log.error("Error occured while getting all events   "+e);
    		return null;
    	}
    }
    public List<Event> getById(int id) throws IllegalArgumentException{
    	Session session = sessionFactory.openSession();
        String hql = "FROM Event E WHERE E.id=:dummyId";
        
        Query query = session.createQuery(hql);
        query.setParameter("dummyId", id);

        List<Event> emList = query.list();
        session.close();
        return emList;
    	
    }
    public void updateEvent(String oldName,String newName)
    {
    	Session session = sessionFactory.openSession();
        session.beginTransaction();
        String hql="UPDATE Event E SET E.eveName=:newname WHERE E.eveName=:oldname";
        Query query = session.createQuery(hql);
        query.setParameter("newname", newName);
        query.setParameter("oldname", oldName);
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
        
    }
    public void deleteEvent(String name)
    {
    	Session session = sessionFactory.openSession();
        session.beginTransaction();
        String hql="DELETE from Event E WHERE E.eveName=:dumname";
        Query query = session.createQuery(hql);
        query.setParameter("dumname", name);
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

}
