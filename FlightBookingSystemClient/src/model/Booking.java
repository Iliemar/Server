package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Booking
{
	private StringProperty id=new SimpleStringProperty("Marius");;
	private String Company;
	public String getCompany() {
		return Company;
	}

	public void setCompany(String company) {
		Company = company;
	}
	private String startDestination;
	private String endDestination;
	private Date date;
	private String price;
	private Collection<Traveler> travelerList = new ArrayList<Traveler>();
	private String direct;
	
	
	public Booking(String company,String startDestination, String endDestination,String i,String id,String d )
	{
		this.setCompany(company);
		this.setStartDestination(startDestination);
		this.setEndDestination(endDestination);
		this.setDate(new Date());
		this.setPrice(i);
		this.setId(id);
		this.setDirect(d);
	
	}
	
	 
	        
	    
	    public String getDirect() {
		return direct;
	}

	public void setDirect(String direct) {
		this.direct = direct;
	}

	public void setId(StringProperty id) {
		this.id = id;
	}

		public Booking(int i, String value, String value2, int adult, int kids, int j, String string, int k) {
		// TODO Auto-generated constructor stub
	}

		public final String getId(){
	        return id.get();
	    }
	    public final void setId(String id2){
	        id.setValue(id2);
	    }
	    public StringProperty idProperty(){
	        return id;
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
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public Collection<Traveler> getTravelerList() {
		return travelerList;
	}
	public void setTravelerList(Collection<Traveler> travelerList) {
		this.travelerList = travelerList;
	}

	
	}
