package Grupp1.Newton.FlightBookingSystem.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class SAS extends FlightCompany implements Serializable {
	
	private static final long serialVersionUID = 9158823721494998741L;

	public SAS(int id, String name, int cost) {
		super(id, name, cost);
	}
}
