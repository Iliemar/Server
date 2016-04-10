package Grupp1.Newton.FlightBookingSystem.services;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import Grupp1.Newton.FlightBookingSystem.Hibernate.HibernateUtil;
import Grupp1.Newton.FlightBookingSystem.models.FlightCompany;

public class FlightCompanyService
{
	private SessionFactory sessionFactory;
	private Session session;
	
	public List<FlightCompany> getAllFlights()
	{
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();
		
		List<FlightCompany> flightList = session.createCriteria(FlightCompany.class).list();
		
		
		session.getTransaction().commit();
		return flightList;
		
	}
	
	public FlightCompany getFlight(int id)
	{
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();
		
		FlightCompany flight = (FlightCompany)session.get(FlightCompany.class, id);
		
		session.getTransaction().commit();
		
		return flight;
	}
	
	public FlightCompany addFlight(FlightCompany flight)
	{
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(flight);
		session.getTransaction().commit();
		session.close();
		
		return flight;
	}

	public FlightCompany deleteFlight(int id)
	{
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();
		
		FlightCompany flight = (FlightCompany)session.get(FlightCompany.class, id);
		
		session.delete(flight);
		session.getTransaction().commit();
		session.close();
		
		return flight;
	}
}
