package an.dpr.cyclubinf.dao.springdatajpa;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import an.dpr.cyclubinf.dao.CalendarEventDAO;
import an.dpr.cyclubinf.domain.CalendarEvent;
import an.dpr.cyclubinf.domain.Club;
import an.dpr.cyclubinf.exception.CyclubinfException;
import an.dpr.cyclubinf.repository.CalendarEventsRepository;

/**
 * Todo extract interface
 * 
 * @author saez
 *
 */
public class CalendarEventDAOSpringDataJPA implements CalendarEventDAO{

    @Autowired
    private CalendarEventsRepository repo;

    public List<CalendarEvent> findAll()  throws CyclubinfException {
	return repo.findAll();
    }

    public CalendarEvent findById(Long id)  throws CyclubinfException {
	return repo.findById(id);
    }

    public List<CalendarEvent> findByYear(short year, long clubId)  throws CyclubinfException {
	Calendar c = Calendar.getInstance();
	c.set(Calendar.MILLISECOND, 0);
	c.set(Calendar.SECOND, 0);
	c.set(Calendar.MINUTE, 0);
	c.set(Calendar.HOUR, 0);
	c.set(Calendar.DAY_OF_YEAR, 1);
	c.set(Calendar.YEAR, year);
	Date init = c.getTime();
	c.add(Calendar.YEAR, 1);
	Date finish = c.getTime();
	return repo.findByDateBetweenAndClub(init, finish, getClub(clubId));
    }
    
    public List<CalendarEvent> findByMonth(short year, short month, long clubId)  throws CyclubinfException {
	Calendar c = Calendar.getInstance();
	c.set(Calendar.MILLISECOND, 0);
	c.set(Calendar.SECOND, 0);
	c.set(Calendar.MINUTE, 0);
	c.set(Calendar.HOUR, 0);
	c.set(Calendar.DAY_OF_MONTH, 1);
	c.set(Calendar.MONTH, month);
	c.set(Calendar.YEAR, year);
	Date init = c.getTime();
	c.add(Calendar.MONTH, 1);
	Date finish = c.getTime();
	return repo.findByDateBetweenAndClub(init, finish,getClub(clubId));
    }

    public List<CalendarEvent> findByDateBetween(Date init, Date finish, long clubId)  throws CyclubinfException {
	try{
	    return repo.findByDateBetweenAndClub(init, finish,getClub(clubId));
	} catch(Exception e){
	    throw new CyclubinfException("Error finding activities", e);
	}
    }
    
    private Club getClub(long clubId){
	Club c = new Club();
	c.setId(clubId);
	return c;
    }

    @Override
    public List<CalendarEvent> findNextActivities(Date init, long clubId) throws CyclubinfException {
	Calendar cal = Calendar.getInstance();
	if (init == null){
	    init = cal.getTime();
	}
	cal.add(Calendar.DAY_OF_YEAR, 7);
	Date finish = cal.getTime(); 
	return repo.findByDateBetweenAndClub(init, finish,getClub(clubId));
    }
}

