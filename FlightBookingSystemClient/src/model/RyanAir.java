package model;

import java.io.Serializable;

public class RyanAir extends FlightCompany implements Serializable {
	
	private static final long serialVersionUID = 9158823721494998741L;

	public RyanAir(int id, String name, int cost) {
		super(id, name, cost);
	}
}
