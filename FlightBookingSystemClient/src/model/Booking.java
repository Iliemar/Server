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
		this.setStartDestination(startDestination);
		this.setEndDestination(endDestination);
		this.setDate(new Date());
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
	public String getStartDestination() {
		return startDestination;
	}
	public void setStartDestination(String startDestination) {
		this.startDestination = startDestination;
	}
	public String getEndDestination() {
		return endDestination;
	}
	public void setEndDestination(String endDestination) {
		this.endDestination = endDestination;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Collection<Traveler> getTravelerList() {
		return travelerList;
	}
	public void setTravelerList(Collection<Traveler> travelerList) {
		this.travelerList = travelerList;
	}
	
		
	}
