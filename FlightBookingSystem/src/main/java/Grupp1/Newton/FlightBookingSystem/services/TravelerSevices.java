package Grupp1.Newton.FlightBookingSystem.services;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import Grupp1.Newton.FlightBookingSystem.Hibernate.HibernateUtil;
import Grupp1.Newton.FlightBookingSystem.models.Traveler;

public class TravelerSevices {
	private SessionFactory sessionFactory;
	private Session session;
	
	public List<Traveler> getAllTraveler()
	{
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();
		
		List<Traveler> travelerList = session.createCriteria(Traveler.class).list();
		
		session.getTransaction().commit();
		
		return travelerList;
		
	}
	
	public Traveler getTraveler(int id)
	{
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();
		
		Traveler traveler = (Traveler)session.get(Traveler.class, id);
		
		session.getTransaction().commit();
		
		return traveler;
	}
	
	public Traveler addTraveler(Traveler traveler)
	{
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(traveler);
		session.getTransaction().commit();
		session.close();
		
		return traveler;
	}
	
	public Traveler editFirstnameOfTraveler(int id, String firstName)
	{
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();
		
		Traveler traveler = (Traveler)session.get(Traveler.class, id);
		traveler.setFirstName(firstName);
		
		session.update(traveler);
		session.getTransaction().commit();
		session.close();
		
		return traveler;
	}
	
	public Traveler editLastnameOfTraveler(int id, String lastName)
	{
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();
		
		Traveler traveler = (Traveler)session.get(Traveler.class, id);
		traveler.setLastName(lastName);
		
		session.update(traveler);
		session.getTransaction().commit();
		session.close();
		
		return traveler;
	}
	
	public Traveler deleteTraveler(int id)
	{
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();
		
		Traveler traveler = (Traveler)session.get(Traveler.class, id);
		
		session.delete(traveler);
		session.getTransaction().commit();
		session.close();
		
		return traveler;
	}
}
