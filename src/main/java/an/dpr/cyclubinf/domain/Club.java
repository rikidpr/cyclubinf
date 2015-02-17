package an.dpr.cyclubinf.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Club
 * 
 * @author rsaez
 * 
 */
@Entity
@Table(name = "clubs")
@XmlRootElement(name="club")
@XmlAccessorType(XmlAccessType.FIELD)
public class Club {

    @XmlElement private Long id;
    @XmlElement private String name;
    @XmlElement private String descripcion;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column
    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    @Column
    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    @Column
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
