package Grupp1.Newton.Flight.Hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import Grupp1.Newton.FlightBookingSystem.Hibernate.HibernateUtil;
import Grupp1.Newton.FlightBookingSystem.models.Adult;
import Grupp1.Newton.FlightBookingSystem.models.Booking;
import Grupp1.Newton.FlightBookingSystem.models.Child;
import Grupp1.Newton.FlightBookingSystem.models.SAS;



public class HibernateDemo {
	private static SessionFactory sessionFactory;
	private static Session session;
	public static void main(String[] args)
	{
		Booking b = new Booking();
		Adult adult = new Adult("Kevine", "Nemec", "19940617", "Inget");
		Child child = new Child("Mergime", "Zahiti", "19940215", "Inget");
		SAS sas = new SAS("Budget", 250);
		String start = "Malmo";
		String stop = "Stockholmn";
		
		b.setStartDestination(start);
		b.setEndDestination(stop);
		b.setFlightCompany(sas);
		b.getTravelerList().add(adult);
		b.getTravelerList().add(child);
		
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(b);
		session.getTransaction().commit();
		session.close();
	}
}
