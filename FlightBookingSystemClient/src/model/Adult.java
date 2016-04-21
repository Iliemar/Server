package model;

import java.io.Serializable;




public class Adult extends Traveler implements Serializable
{
	private String firstName;
	private String lastName;
	private int age;
	private long persNR;
	private String handicap;
	
	public Adult(String firstName, String lastName, String persNR, String handicap)
	{
		super(firstName, lastName, persNR, handicap);
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

	public String getPersNR()
	{
		return super.getPersNR();
	}

	public void setPersNR(String persNR)
	{
		super.setPersNR(persNR);
	}
}
