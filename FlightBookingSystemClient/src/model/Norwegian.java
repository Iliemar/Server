package model;

import java.io.Serializable;

public class Norwegian extends FlightCompany implements Serializable {
	
	private static final long serialVersionUID = 9158823721494998741L;

	public Norwegian(int id, String name, int cost) {
		super(id, name, cost);
	}
	
	public Norwegian()
	{
		super();
	}
}
