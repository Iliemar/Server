package Grupp1.Newton.FlightBookingSystem.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class Child extends Traveler implements Serializable
{
	public Child(String firstName, String lastName, String persNR, String handicap)
	{
		super(firstName, lastName, persNR, handicap);
	}
	
	public Child()
	{
		super();
	}
	
	public String getFirstName()
	{
		return super.getFirstName();
	}
	public String getLastName()
	{
		return super.getLastName();
	}
	public int getAge()
	{
		return super.getAge();
	}
	public String getPersNR()
	{
		return super.getPersNR();
	}
	public void setFirstName(String firstName)
	{
		super.setFirstName(firstName);
	}
	public void setLastName(String lastName)
	{
		super.setLastName(lastName);
	}
	public void setAge(int age)
	{
		super.setAge(age);
	}
	public void setPersNR(String persNR)
	{
		super.setPersNR(persNR);
	}
}