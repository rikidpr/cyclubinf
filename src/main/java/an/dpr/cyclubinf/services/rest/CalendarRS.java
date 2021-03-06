package an.dpr.cyclubinf.services.rest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import an.dpr.cyclubinf.bean.CalendarEventList;
import an.dpr.cyclubinf.dao.CalendarEventDAO;
import an.dpr.cyclubinf.domain.CalendarEvent;
import an.dpr.cyclubinf.exception.CyclubinfException;

@Path("/calendar")
public class CalendarRS {
    private static final Logger log = LoggerFactory.getLogger(CalendarRS.class);
    @Autowired
    private CalendarEventDAO calendarDAO;

    @GET
    @Produces(MediaType.APPLICATION_XML)
//    @Produces(MediaType.APPLICATION_JSON)
    @Path("/get/{id}")
    public Response getActivityInfo(@PathParam("id") String id) {
	CalendarEvent ca = new CalendarEvent();
	ca.setNum(Integer.valueOf(id));
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	try {
	    ca.setDate(sdf.parse("01/02/2015 09:00"));
	} catch (ParseException e) {
	    log.error("fecha no reconocida");
	}
	ca.setKm(101.36f);
	ca.setStop("Gallur");
	ca.setRoute("Alagon-Remolinos-Gallur-Cabañas");
	ca.setReturnRoute("Cabañas");
	ca.setType("ROAD");
	ca.setDifficulty("EASY");
	ca.setElevationGain(0);

	return Response.ok().entity(ca).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_XML)
//    @Produces(MediaType.APPLICATION_JSON)
    @Path("/nextActivities/{clubId}")
    public Response getNextActivities(@PathParam("clubId") String clubId) {
	List<CalendarEvent> nextList;
	Calendar c = Calendar.getInstance();
	Date initDate = c.getTime();
	c.add(Calendar.DAY_OF_YEAR, 7);
	Date finishDate = c.getTime();
	try {
	    Long lClubId = Long.valueOf(clubId);
	    nextList = calendarDAO.findByDateBetween(initDate, finishDate, lClubId);
	} catch (NumberFormatException e) {
	    log.error("Error getting the next activities, clubId isn't a number", e);
	    nextList = new ArrayList<CalendarEvent>();
	} catch (CyclubinfException e) {
	    log.error("Error getting the next activities", e);
	    nextList = new ArrayList<CalendarEvent>();
	}
	CalendarEventList listado = new CalendarEventList();
	listado.setList(nextList);

	return Response.ok().entity(listado).build();

    }

    private List<CalendarEvent> getNextActivitiesMock() {
	List<CalendarEvent> nextList = new ArrayList<CalendarEvent>();
	for (int i = 1; i < 3; i++) {
	    CalendarEvent ca = new CalendarEvent();
	    ca.setNum(Integer.valueOf(i));
	    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	    try {
		ca.setDate(sdf.parse("0" + i + "/02/2015 09:00"));
	    } catch (ParseException e) {
		log.error("fecha no reconocida");
	    }
	    ca.setKm(101.36f);
	    ca.setStop("Stop" + i);
	    ca.setRoute("Route" + i);
	    ca.setReturnRoute("Return Route" + i);
	    ca.setType("ROAD");
	    ca.setDifficulty("EASY");
	    ca.setElevationGain(i * 100);
	    nextList.add(ca);
	}
	return nextList;
    }

}
