package an.dpr.cyclubinf.bean;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import an.dpr.cyclubinf.domain.CalendarEvent;

/**
 * Clase root para la representacion de resultados via XML/JSON
 * @author saez
 *
 */
@XmlRootElement(name="calendarEventList")
@XmlAccessorType(XmlAccessType.FIELD)
public class CalendarEventList implements Serializable{

    private static final long serialVersionUID = -7969398942290465572L;
    
    @XmlElement
    private List<CalendarEvent> list;

    public List<CalendarEvent> getList() {
        return list;
    }

    public void setList(List<CalendarEvent> list) {
        this.list = list;
    }
}
