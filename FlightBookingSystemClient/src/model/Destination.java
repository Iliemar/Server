package model;

public class Destination {

	private String destination;
	private int zone;

	public Destination(String destination, int zone) {
		this.destination = destination;
		this.zone = zone;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getZone() {
		return zone;
	}

	public void setZone(int zone) {
		this.zone = zone;
	}

	public String toString(String name) {
		return name;
	}

}
