package app.resource;

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
		return Response.status(200).entity(mdb.getTimes()).build();
	}

	@POST
	@Path("/set")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response save(Time time) {
		mdb.save(time);
		return Response.status(200).entity("id: " + time.getId()).build();
	}

	@POST
	@Path("/set")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveCal(Calendar calendar) {
		mdb.save(calendar);
		return Response.status(200).entity("id: " + calendar.getId()).build();
	}
}
