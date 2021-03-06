package model;

import java.io.Serializable;

public class Traveler implements Serializable
{
	private String firstName;
	private String lastName;
	private int age;
	private String persNR;
	private String handicap;
	
	public Traveler(String firstName, String lastName, String persNR, String handicap)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.persNR = persNR;
		this.handicap = handicap;
	}
	
	public String getHandicap() {
		return handicap;
	}

	public void setHandicap(String handicap) {
		this.handicap = handicap;
	}

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
}
