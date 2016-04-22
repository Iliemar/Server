package Grupp1.Newton.Flight.Hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import Grupp1.Newton.FlightBookingSystem.Hibernate.HibernateUtil;
import Grupp1.Newton.FlightBookingSystem.models.Adult;
import Grupp1.Newton.FlightBookingSystem.models.Booking;
import Grupp1.Newton.FlightBookingSystem.models.Child;
import Grupp1.Newton.FlightBookingSystem.models.Emirates;
import Grupp1.Newton.FlightBookingSystem.models.Norwegian;
import Grupp1.Newton.FlightBookingSystem.models.RyanAir;
import Grupp1.Newton.FlightBookingSystem.models.SAS;



public class HibernateDemo {
	private static SessionFactory sessionFactory;
	private static Session session;
	public static void main(String[] args)
	{
		SAS sas = new SAS("SAS", 350);
		Emirates emirates = new Emirates("Emirates", 450);
		Norwegian norwegian = new Norwegian("Norwegian-Air", 200);
		RyanAir ryanair = new RyanAir("Ryan-Air", 150);
		
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(sas);
		session.save(emirates);
		session.save(norwegian);
		session.save(ryanair);
		session.getTransaction().commit();
		session.close();
	}
}