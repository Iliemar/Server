package Grupp1.Newton.FlightBookingSystem.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
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
	public Traveler(String firstName, String lastName, int age, long persNR)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.persNR = persNR;
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
	private long persNR;
	
	@Type(type="yes_no")
	@Column(name = "disablity")
	private boolean izHandicapped;
	
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
	
	@ManyToMany(cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private Collection<Booking> bookingList = new ArrayList<Booking>();
	
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

	public long getPersNR()
	{
		return persNR;
	}

	public void setPersNR(long persNR)
	{
		this.persNR = persNR;
	}
	
	public Collection<Booking> getBookingList()
	{
		return bookingList;
	}
	
	public void setBookingList(Collection<Booking> bookingList)
	{
		this.bookingList = bookingList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public boolean isIzHandicapped()
	{
		return izHandicapped;
	}

	public void setIzHandicapped(boolean izHandicapped)
	{
		this.izHandicapped = izHandicapped;
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
