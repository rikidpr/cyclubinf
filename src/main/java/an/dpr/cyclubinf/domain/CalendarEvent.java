package an.dpr.cyclubinf.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.log4j.Logger;


/**
 * Bean para informacion de Salidas al exterior
 * @author rsaez
 *
 */
@Entity
@Table(name = "events")
@XmlRootElement(name = "CalendarEvent")
@XmlAccessorType(XmlAccessType.FIELD)
public class CalendarEvent implements Serializable{
    
    private static final long serialVersionUID = -5016580463092316282L;
    private static final Logger log = Logger.getLogger(CalendarEvent.class);
    
    @XmlElement
    private Long id;
    @XmlElement
    private Integer num;
    @XmlElement
    private Date date;
    @XmlElement
    private String route;
    @XmlElement
    private String returnRoute;
    @XmlElement
    private String stop;
    @XmlElement
    private Float km;
    @XmlElement
    private Integer elevationGain;
    @XmlElement
    private String difficulty;
    @XmlElement
    private String type;
    @XmlElement
    private Club club;
    private Set<Member> members;
//    private Orache orache;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    public Long getId(){
	return id;
    }
    
    public void setId(Long id){
	this.id=id;
    }

    /**
     * @return the date
     */
    @Column
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the route
     */
    @Column
    public String getRoute() {
        return route;
    }

    /**
     * @param route the route to set
     */
    public void setRoute(String route) {
        this.route = route;
    }

    /**
     * @return the returnRoute
     */
    @Column
    public String getReturnRoute() {
        return returnRoute;
    }

    /**
     * @param returnRoute the returnRoute to set
     */
    public void setReturnRoute(String returnRoute) {
        this.returnRoute = returnRoute;
    }

    /**
     * @return the stop
     */
    @Column
    public String getStop() {
        return stop;
    }

    /**
     * @param stop the stop to set
     */
    public void setStop(String stop) {
        this.stop = stop;
    }

    /**
     * @return the km
     */
    @Column
    public Float getKm() {
        return km;
    }

    /**
     * @param km the km to set
     */
    public void setKm(Float km) {
        this.km = km;
    }

    /**
     * @return the elevationGain
     */
    @Column
    public Integer getElevationGain() {
        return elevationGain;
    }

    /**
     * @param elevationGain the elevationGain to set
     */
    public void setElevationGain(Integer elevationGain) {
        this.elevationGain = elevationGain;
    }

    /**
     * @return the difficulty
     */
    @Column
    public String getDifficulty() {
        return difficulty;
    }

    /**
     * @param difficulty the difficulty to set
     */
    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    /**
     * @return the type
     */
    @Column
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }


    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return "SalidaInfo [date=" + date + ", route=" + route
		+ ", returnRoute=" + returnRoute + ", stop=" + stop + ", km="
		+ km + ", elevationGain=" + elevationGain + ", difficulty="
		+ difficulty + ", type=" + type + "]";
    }

    @Column
    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @ManyToOne
    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public Set<Member> getMembers() {
        return members;
    }

    public void setMembers(Set<Member> members) {
        this.members = members;
    }

}
