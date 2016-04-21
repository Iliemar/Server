package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Booking
{
	private String startDestination;
	private String endDestination;
	private Date date;
	private int price;
	private int id;
	private Collection<Traveler> travelerList = new ArrayList<Traveler>();
	private FlightCompany flightCompany;
	
	
	public Booking(FlightCompany company, String startDestination, String endDestination, int price)
	{
		this.setFlightCompany(company);
		this.setStartDestination(startDestination);
		this.setEndDestination(endDestination);
		this.price = price;
		this.setDate(new Date());
	}
	
	public Booking()
	{
		
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
		public FlightCompany getFlightCompany()
		{
			return flightCompany;
		}
		public void setFlightCompany(FlightCompany flightCompany)
		{
			this.flightCompany = flightCompany;
		}
		public int getId()
		{
			return id;
		}
		public void setId(int id)
		{
			this.id = id;
		}

	
	}
