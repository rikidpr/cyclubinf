package an.dpr.cyclubinf.dao;

import java.util.Date;
import java.util.List;

import an.dpr.cyclubinf.domain.CalendarEvent;
import an.dpr.cyclubinf.exception.CyclubinfException;

public interface CalendarEventDAO {

    public List<CalendarEvent> findAll() throws CyclubinfException;

    /**
     * Find activities by id
     * @param id
     * @return
     * @throws CyclubinfException
     */
    public CalendarEvent findById(Long id) throws CyclubinfException;

    /**
     * By activities list by year
     * @param year
     * @return
     * @throws CyclubinfException
     */
    public List<CalendarEvent> findByYear(short year) throws CyclubinfException;
    
    /**
     * Find activities by month
     * @param year
     * @param month
     * @return
     * @throws CyclubinfException
     */
    public List<CalendarEvent> findByMonth(short year, short month) throws CyclubinfException;

    /**
     * Find activities between two dates
     * @param init
     * @param finish
     * @return
     * @throws CyclubinfException
     */
    public List<CalendarEvent> findByDateBetween(Date init, Date finish) throws CyclubinfException;
    
    /**
     * Find the next club's activities 
     * @param init
     * @return
     * @throws CyclubinfException
     */
    public List<CalendarEvent> findNextActivities(Date init) throws CyclubinfException;

}
