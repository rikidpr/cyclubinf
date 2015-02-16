/**
 * 
 */
package an.dpr.cyclubinf.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import an.dpr.cyclubinf.domain.CalendarEvent;
import an.dpr.cyclubinf.domain.Club;

/**
 * @author rsaez
 *
 */
public interface CalendarEventsRepository extends CrudRepository<CalendarEvent, Long> {
    
    List<CalendarEvent> findAll();
    CalendarEvent findById(Long id);
    List<CalendarEvent> findByDateBetweenAndClub(Date init, Date finish, Club club);
}
