package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class Booking
{
	private String startDestination;
	private String endDestination;
	private Date date;
	private int price;
	private Collection<Traveler> travelerList = new ArrayList<Traveler>();
	
	public Booking(String startDestination, String endDestination)
	{
		this.startDestination = startDestination;
		this.endDestination = endDestination;
		this.date = new Date();
	}
	public Booking()
	{
		
	}
	public Booking(int i, String value, String value2, int adult, int kids, int handicaped, String string, int j) {
		// TODO Auto-generated constructor stub
	}
	public void setBooking(String updatedBooking) {
		this.setBooking(updatedBooking);
		
	
	}
	public Object getFromDestination() {
		// TODO Auto-generated method stub
		return null;
	}
	public Object getToDestination() {
		// TODO Auto-generated method stub
		return null;
	}
	
		
	}
