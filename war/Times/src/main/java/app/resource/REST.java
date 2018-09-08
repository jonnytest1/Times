package app.resource;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import app.model.Calendar;
import app.model.Time;
import repositories.MariaDBRepository;

@Stateless
@Path("")
public class REST {

	@Inject
	public MariaDBRepository mdb;

	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public Response test() {
		List<Time> times = mdb.getTimes();
		return Response.status(200).entity(times).build();
	}

	@POST
	@Path("/set")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response save(Time time) {
		mdb.save(time);
		return Response.status(200).entity("id: " + time.getId()).build();
	}

	@GET
	@Path("/calendar")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCalendar() {
		List<Calendar> calendar = mdb.getCalender();
		return Response.status(200).entity(calendar).build();
	}

	@POST
	@Path("/calendar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveCal(Calendar calendar) {
		mdb.save(calendar);
		return Response.status(200).entity("id: " + calendar.getId()).build();
	}
}
