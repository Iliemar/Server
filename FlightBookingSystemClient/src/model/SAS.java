package model;

import java.io.Serializable;

public class SAS extends FlightCompany implements Serializable {
	
	private static final long serialVersionUID = 9158823721494998741L;

	public SAS(int id, String name, int cost) {
		super(id, name, cost);
	}
	
	public SAS()
	{
		super();
	}
	
	public String toString()
	{
		return super.toString();
	}
}
