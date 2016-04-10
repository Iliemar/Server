package Grupp1.Newton.FlightBookingSystem.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlRootElement;

import Grupp1.Newton.FlightBookingSystem.models.Traveler;
import Grupp1.Newton.FlightBookingSystem.services.TravelerSevices;

@XmlRootElement
@Path("/travelers")
public class TravelerResource
{
	private TravelerSevices travelerService= new TravelerSevices();	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Traveler>getAllTraveler(){
		return travelerService.getAllTraveler();
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{travelerId}")
	public Traveler getTraveler(@PathParam("travelerId") int id)
	{
		return travelerService.getTraveler(id);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Traveler addTraveler(Traveler traveler)
	{
		return travelerService.addTraveler(traveler);
	}
	
	@DELETE 
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteTraveler(Traveler traveler)
	{
		System.out.println("Done");
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{travelerId}")
	public Traveler editFirstnameOfTraveler(@PathParam("travelerId") int id, String firstName)
	{
		return travelerService.editFirstnameOfTraveler(id, firstName);
	}
	
	
}
