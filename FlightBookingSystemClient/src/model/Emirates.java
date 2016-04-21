package model;

import java.io.Serializable;

public class Emirates extends FlightCompany implements Serializable {
	
	private static final long serialVersionUID = 9158823721494998741L;

	public Emirates(int id, String name, int cost) {
		super(id, name, cost);
	}
	
	public Emirates()
	{
		super();
	}
}
