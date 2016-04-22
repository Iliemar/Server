package Grupp1.Newton.FlightBookingSystem.services;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import Grupp1.Newton.FlightBookingSystem.Hibernate.HibernateUtil;
import Grupp1.Newton.FlightBookingSystem.models.Booking;
import Grupp1.Newton.FlightBookingSystem.models.Traveler;


public class BookingService
{

	private SessionFactory sessionFactory;
	private Session session;
	
	public List<Booking> getAllBookings()
	{
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();
		
		List<Booking> bookingList = session.createCriteria(Booking.class).list();
		
		session.getTransaction().commit();
		
		return bookingList;
		
	}
	
	public Booking getBooking(int id)
	{
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();
		
		Booking booking = (Booking)session.get(Booking.class, id);
		
		session.getTransaction().commit();
		
		return booking;
	}
	
	public Booking addBooking(Booking booking)
	{
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(booking);
		session.getTransaction().commit();
		session.close();
		
		return booking;
	}
	
	public Booking editFirstnameInBooking(int id, String firstName, int PNR)
	{
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();
		
		Booking booking = (Booking)session.get(Booking.class, id);
		List<Traveler> travelerList = (List<Traveler>)booking.getTravelerList();
		travelerList.get(PNR).setFirstName(firstName);
		
		session.update(booking);
		session.getTransaction().commit();
		session.close();
		
		return booking;
	}
	
	public Booking deleteBooking(int id)
	{
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();
		
		Booking booking = (Booking)session.get(Booking.class, id);
		
		session.delete(booking);
		session.getTransaction().commit();
		session.close();
		
		return booking;
	}
}
