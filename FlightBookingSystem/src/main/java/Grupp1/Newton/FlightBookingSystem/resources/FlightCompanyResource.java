package Grupp1.Newton.FlightBookingSystem.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import Grupp1.Newton.FlightBookingSystem.models.Booking;
import Grupp1.Newton.FlightBookingSystem.models.FlightCompany;
import Grupp1.Newton.FlightBookingSystem.services.FlightCompanyService;

@Path("/flightcompanies")
public class FlightCompanyResource
{
	private FlightCompanyService flightCompanyService= new FlightCompanyService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<FlightCompany>getAllFlights(){
		return flightCompanyService.getAllFlights();
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{flightId}")
	public FlightCompany getFlight(@PathParam("flightId") int id)
	{
		return flightCompanyService.getFlight(id);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public FlightCompany addFlightCompany(FlightCompany flight)
	{
		return flightCompanyService.addFlight(flight);
	}
}
