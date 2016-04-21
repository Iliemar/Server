package Grupp1.Newton.FlightBookingSystem.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@XmlRootElement
@Entity
@Table(name = "Booking")
public class Booking implements Serializable
{
	@Id
	@GeneratedValue
	private int id;
	
	@Column(name = "startDestination")
	private String startDestination;
	
	@Column(name = "endDestination")
	private String endDestination;
	
	@Column(name = "date")
	private Date date;
	
	@Column(name = "ticketPrice")
	private int price;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Collection<Traveler> travelerList = new ArrayList<Traveler>();
	
	@OneToOne(cascade = CascadeType.ALL)
	private FlightCompany flightCompany;
	
	//private Collection<Destination> destinationList = new ArrayList<Destination>();
	
	public Booking(FlightCompany flightCompany, String startDestination, String endDestination, int price)
	{
		this.startDestination = startDestination;
		this.endDestination = endDestination;
		this.price = price;
		this.flightCompany = flightCompany;
		this.date = new Date();
	}
	
	public Booking()
	{
		
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getStartDestination()
	{
		return startDestination;
	}
	public void setStartDestination(String startDestination)
	{
		this.startDestination = startDestination;
	}
	public String getEndDestination()
	{
		return endDestination;
	}
	public void setEndDestination(String endDestination)
	{
		this.endDestination = endDestination;
	}
	public Date getDate()
	{
		return date;
	}
	public void setDate(Date date)
	{
		this.date = date;
	}
	public int getPrice()
	{
		return price;
	}
	public void setPrice(int price)
	{
		this.price = price;
	}
	public Collection<Traveler> getTravelerList()
	{
		return travelerList;
	}
	public void setTravelerList(Collection<Traveler> travelerList)
	{
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

	/*public Collection<Destination> getDestinationList() {
		return destinationList;
	}

	public void setDestinationList(Collection<Destination> destinationList) {
		this.destinationList = destinationList;
	}*/
}
