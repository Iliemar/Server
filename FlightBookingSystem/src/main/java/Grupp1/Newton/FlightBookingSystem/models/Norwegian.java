package Grupp1.Newton.FlightBookingSystem.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class Norwegian extends FlightCompany implements Serializable {

	private static final long serialVersionUID = 2389812381825670858L;

	public Norwegian(int id, String name, int cost) {
		super(id, name, cost);
	}
}
