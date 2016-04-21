package Grupp1.Newton.FlightBookingSystem.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class FlightCompany
{
	public FlightCompany(String name, int cost){
		this.name = name;
		this.cost=cost;
	}
	public FlightCompany()
	{
		
	}
	
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private int cost;
	
	@OneToOne()
	private Booking booking;

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public Booking getBooking()
	{
		return booking;
	}
	public void setBooking(Booking booking)
	{
		this.booking = booking;
	}
	public String toString(){
		return "Name of the company: " + this.name + 
				" Price to fly: " + this.cost;
	}
}
