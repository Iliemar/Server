package Grupp1.Newton.FlightBookingSystem.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class RyanAir extends FlightCompany implements Serializable {

	private static final long serialVersionUID = -2033798705313047647L;

	public RyanAir(String name, int cost) {
		super(name, cost);
	}
	
	public RyanAir()
	{
		super();
	}
}
