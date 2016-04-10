package Grupp1.Newton.FlightBookingSystem.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@Entity
public class Adult extends Traveler implements Serializable
{
	public Adult(String firstName, String lastName, int age, long persNR)
	{
		super(firstName, lastName, age, persNR);
	}
	
	public Adult()
	{
		
	}
	
	public String getFirstName()
	{
		return super.getFirstName();
	}

	public void setFirstName(String firstName)
	{
		super.setFirstName(firstName);
	}

	public String getLastName()
	{
		return super.getLastName();
	}

	public void setLastName(String lastName)
	{
		super.setLastName(lastName);
	}
	
	public int getAge()
	{
		return super.getAge();
	}

	public void setAge(int age)
	{
		super.setAge(age);
	}

	public long getPersNR()
	{
		return super.getPersNR();
	}

	public void setPersNR(long persNR)
	{
		super.setPersNR(persNR);
	}
}
