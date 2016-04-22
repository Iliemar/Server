package model;

public class FlightCompany {

	public FlightCompany(int id, String name, int cost){
		this.id = id;
		this.name = name;
		this.cost=cost;
	}
	public FlightCompany()
	{
		
	}
	
	private int id;
	private String name;
	private int cost;

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String toString()
	{
		return "Flightcompany: " + this.name + " Price: " + this.cost;
	}
}
