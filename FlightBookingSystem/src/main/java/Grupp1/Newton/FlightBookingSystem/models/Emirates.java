package Grupp1.Newton.FlightBookingSystem.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class Emirates extends FlightCompany implements Serializable {

	private static final long serialVersionUID = -7112921686054359200L;

	public Emirates(String name, int cost) {
		super(name, cost);
	}
	
	public Emirates()
	{
		super();
	}
}
