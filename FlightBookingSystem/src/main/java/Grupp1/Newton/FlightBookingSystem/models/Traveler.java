package Grupp1.Newton.FlightBookingSystem.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Type;

@XmlRootElement
@Entity
@Table(name = "Traveler")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Traveler implements Serializable
{
	public Traveler(String firstName, String lastName, String persNR, String handicap)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.persNR = persNR;
		this.handicap = handicap;
	}
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column(name = "firstName")
	private String firstName;
	
	@Column(name = "lastName")
	private String lastName;
	
	@Column(name = "age")
	private int age;
	
	@Column(name = "persNR")
	private String persNR;
	
	@Column(name = "disablity")
	private String handicap;
	
	@Type(type="yes_no")
	@Column(name = "wifi")
	private boolean wifi;
	
	@Type(type="yes_no")
	@Column(name = "food")
	private boolean food;
	
	@Type(type="yes_no")
	@Column(name = "powerSupply")
	private boolean powerSupply;
	
	@Type(type="yes_no")
	@Column(name = "extraSpace")
	private boolean extraSpace;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Booking booking;

	
	//Use if you want to create an object with no set data or attributes.
	public Traveler()
	{
		
	}
	
	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	public String getPersNR()
	{
		return persNR;
	}

	public void setPersNR(String persNR)
	{
		this.persNR = persNR;
	}
	
	public Booking getBooking()
	{
		return booking;
	}
	
	public void setBooking(Booking booking)
	{
		this.booking = booking;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}
	
	public String getHandicap() {
		return handicap;
	}

	public void setHandicap(String handicap) {
		this.handicap = handicap;
	}

	public boolean isWifi()
	{
		return wifi;
	}

	public void setWifi(boolean wifi)
	{
		this.wifi = wifi;
	}

	public boolean isFood()
	{
		return food;
	}

	public void setFood(boolean food)
	{
		this.food = food;
	}

	public boolean isPowerSupply()
	{
		return powerSupply;
	}

	public void setPowerSupply(boolean powerSupply)
	{
		this.powerSupply = powerSupply;
	}

	public boolean isExtraSpace()
	{
		return extraSpace;
	}

	public void setExtraSpace(boolean extraSpace)
	{
		this.extraSpace = extraSpace;
	}
}
