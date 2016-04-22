package Grupp1.Newton.FlightBookingSystem.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlRootElement;

import Grupp1.Newton.FlightBookingSystem.services.BookingService;
import Grupp1.Newton.FlightBookingSystem.services.FlightCompanyService;
import Grupp1.Newton.FlightBookingSystem.models.Booking;
@XmlRootElement
@Path("/bookings")
public class BookingResource
{
	private BookingService bookingService = new BookingService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Booking>getAllBookings(){
		return bookingService.getAllBookings();
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{bookingId}")
	public Booking getBooking(@PathParam("bookingId") int id)
	{
		return bookingService.getBooking(id);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Booking addBooking(Booking booking)
	{
		return bookingService.addBooking(booking);
	}
}
	

