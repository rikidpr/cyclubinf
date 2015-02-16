package an.dpr.cyclubinf.domain;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "members")
public class Member {

    private Long id;
    private String nif;
    private String name;
    private String surname1;
    private String surname2;
    private Integer number;
    private Date addDate;
    private Date endDate;
    private Date birthDate;
    private String email;
    private String address;
    private String telephonNumber;
    private Club club;
    private Set<CalendarEvent> events;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
	this.id= id;
    }

    @Column(nullable=false)
    public String getNif() {
	return nif;
    }

    public void setNif(String nif) {
	this.nif = nif;
    }

    @Column(nullable=false)
    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    @Column
    public String getSurname1() {
	return surname1;
    }

    public void setSurname1(String surname1) {
	this.surname1 = surname1;
    }

    @Column
    public String getSurname2() {
	return surname2;
    }

    public void setSurname2(String surname2) {
	this.surname2 = surname2;
    }

    @Column(nullable=false)
    public Integer getNumber() {
	return number;
    }

    public void setNumber(Integer number) {
	this.number = number;
    }

    @Column(nullable=false)
    public Date getAddDate() {
	return addDate;
    }

    public void setAddDate(Date addDate) {
	this.addDate = addDate;
    }

    @Column
    public Date getEndDate() {
	return endDate;
    }

    public void setEndDate(Date endDate) {
	this.endDate = endDate;
    }

    @Column
    public Date getBirthDate() {
	return birthDate;
    }

    public void setBirthDate(Date birthDate) {
	this.birthDate = birthDate;
    }


    @Column
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column
    public String getTelephonNumber() {
        return telephonNumber;
    }

    public void setTelephonNumber(String telephonNumber) {
        this.telephonNumber = telephonNumber;
    }
    
    @Transient
    public String getNombreCompleto(){
	StringBuilder sb = new StringBuilder();
	sb.append(surname1!=null ? surname1 : "-")
	    .append(" ")
	    .append(surname2!=null ? surname2 : "-")
	    .append(", ")
	    .append(name != null ? name:"-");
	return sb.toString();
    }

    @ManyToOne
    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    @ManyToMany(fetch = FetchType.EAGER, mappedBy="members")
    public Set<CalendarEvent> getCalendarEvents() {
	return events;
    }

    public void setCalendarEvents(Set<CalendarEvent> events) {
	this.events = events;
    }

    @Transient
    public int getNumeroCalendarEvents(){
	int ret = 0;
	if (events != null){
	    ret = events.size();
	}
	return ret;
    }

    @Override
    public String toString() {
	return "Member [id=" + id + ", nif=" + nif + ", name=" + name + ", surname1=" + surname1 + ", surname2="
		+ surname2 + ", number=" + number + ", addDate=" + addDate + ", endDate=" + endDate + ", birthDate="
		+ birthDate + ", email=" + email + ", address=" + address + ", telephonNumber=" + telephonNumber
		+ ", club=" + club + ", events=" + events + "]";
    }
    
    

}
