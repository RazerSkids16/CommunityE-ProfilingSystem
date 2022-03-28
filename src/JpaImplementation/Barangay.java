/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JpaImplementation;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PlonGaming
 */
@Entity
@Table(name = "barangay")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Barangay.findAll", query = "SELECT b FROM Barangay b")
    , @NamedQuery(name = "Barangay.findByBarBrgyID", query = "SELECT b FROM Barangay b WHERE b.barBrgyID = :barBrgyID")
    , @NamedQuery(name = "Barangay.findByBarBrgyName", query = "SELECT b FROM Barangay b WHERE b.barBrgyName = :barBrgyName")
    , @NamedQuery(name = "Barangay.findByBarCity", query = "SELECT b FROM Barangay b WHERE b.barCity = :barCity")
    , @NamedQuery(name = "Barangay.findByBarProvince", query = "SELECT b FROM Barangay b WHERE b.barProvince = :barProvince")
    , @NamedQuery(name = "Barangay.findByBarBrgyCaptain", query = "SELECT b FROM Barangay b WHERE b.barBrgyCaptain = :barBrgyCaptain")})
public class Barangay implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "bar_BrgyID")
    private Integer barBrgyID;
    @Column(name = "bar_BrgyName")
    private String barBrgyName;
    @Column(name = "bar_city")
    private String barCity;
    @Column(name = "bar_province")
    private String barProvince;
    @Column(name = "bar_BrgyCaptain")
    private String barBrgyCaptain;

    public Barangay() {
    }

    public Barangay(Integer barBrgyID) {
        this.barBrgyID = barBrgyID;
    }

    public Integer getBarBrgyID() {
        return barBrgyID;
    }

    public void setBarBrgyID(Integer barBrgyID) {
        this.barBrgyID = barBrgyID;
    }

    public String getBarBrgyName() {
        return barBrgyName;
    }

    public void setBarBrgyName(String barBrgyName) {
        this.barBrgyName = barBrgyName;
    }

    public String getBarCity() {
        return barCity;
    }

    public void setBarCity(String barCity) {
        this.barCity = barCity;
    }

    public String getBarProvince() {
        return barProvince;
    }

    public void setBarProvince(String barProvince) {
        this.barProvince = barProvince;
    }

    public String getBarBrgyCaptain() {
        return barBrgyCaptain;
    }

    public void setBarBrgyCaptain(String barBrgyCaptain) {
        this.barBrgyCaptain = barBrgyCaptain;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (barBrgyID != null ? barBrgyID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Barangay)) {
            return false;
        }
        Barangay other = (Barangay) object;
        if ((this.barBrgyID == null && other.barBrgyID != null) || (this.barBrgyID != null && !this.barBrgyID.equals(other.barBrgyID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JpaImplementation.Barangay[ barBrgyID=" + barBrgyID + " ]";
    }
    
}
