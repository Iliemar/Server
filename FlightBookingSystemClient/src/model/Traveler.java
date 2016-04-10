package model;

import java.io.Serializable;



public abstract class Traveler implements Serializable
{
	private String firstName;
	private String lastName;
	private int age;
	private long persNR;
	
	public Traveler(String firstName, String lastName, int age, long persNR)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.persNR = persNR;
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

	public long getPersNR()
	{
		return persNR;
	}

	public void setPersNR(long persNR)
	{
		this.persNR = persNR;
	}
}
