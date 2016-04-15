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
	public Child(String firstName, String lastName, int age, long persNR, String handicap)
	{
		super(firstName, lastName, age, persNR, handicap);
	}
	
	public Child()
	{
		
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
	public long getPersNR()
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
	public void setPersNR(long persNR)
	{
		super.setPersNR(persNR);
	}
}