package model;

import java.io.Serializable;




public class Adult extends Traveler implements Serializable
{
	private String firstName;
	private String lastName;
	private int age;
	private long persNR;
	
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
