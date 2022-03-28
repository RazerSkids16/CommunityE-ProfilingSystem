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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PlonGaming
 */
@Entity
@Table(name = "resident")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Resident.findAll", query = "SELECT r FROM Resident r")
    , @NamedQuery(name = "Resident.findByResId", query = "SELECT r FROM Resident r WHERE r.resId = :resId")
    , @NamedQuery(name = "Resident.findByResFirstname", query = "SELECT r FROM Resident r WHERE r.resFirstname = :resFirstname")
    , @NamedQuery(name = "Resident.findByResLastname", query = "SELECT r FROM Resident r WHERE r.resLastname = :resLastname")
    , @NamedQuery(name = "Resident.findByResMidname", query = "SELECT r FROM Resident r WHERE r.resMidname = :resMidname")
    , @NamedQuery(name = "Resident.findByResGender", query = "SELECT r FROM Resident r WHERE r.resGender = :resGender")
    , @NamedQuery(name = "Resident.findByResPurok", query = "SELECT r FROM Resident r WHERE r.resPurok = :resPurok")
    , @NamedQuery(name = "Resident.findByResbrgyID", query = "SELECT r FROM Resident r WHERE r.resbrgyID = :resbrgyID")
    , @NamedQuery(name = "Resident.findByResBarangay", query = "SELECT r FROM Resident r WHERE r.resBarangay = :resBarangay")
    , @NamedQuery(name = "Resident.findByResHealthCond", query = "SELECT r FROM Resident r WHERE r.resHealthCond = :resHealthCond")})
public class Resident implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "res_id")
    private Integer resId;
    @Column(name = "res_firstname")
    private String resFirstname;
    @Column(name = "res_lastname")
    private String resLastname;
    @Column(name = "res_midname")
    private String resMidname;
    @Column(name = "res_gender")
    private String resGender;
    @Column(name = "res_purok")
    private String resPurok;
    @Column(name = "res_brgyID")
    private Integer resbrgyID;
    @Column(name = "res_barangay")
    private String resBarangay;
    @Column(name = "res_HealthCond")
    private String resHealthCond;
    @Lob
    @Column(name = "res_image")
    private byte[] resImage;

    public Resident() {
    }

    public Resident(Integer resId) {
        this.resId = resId;
    }

    public Integer getResId() {
        return resId;
    }

    public void setResId(Integer resId) {
        this.resId = resId;
    }

    public String getResFirstname() {
        return resFirstname;
    }

    public void setResFirstname(String resFirstname) {
        this.resFirstname = resFirstname;
    }

    public String getResLastname() {
        return resLastname;
    }

    public void setResLastname(String resLastname) {
        this.resLastname = resLastname;
    }

    public String getResMidname() {
        return resMidname;
    }

    public void setResMidname(String resMidname) {
        this.resMidname = resMidname;
    }

    public String getResGender() {
        return resGender;
    }

    public void setResGender(String resGender) {
        this.resGender = resGender;
    }

    public String getResPurok() {
        return resPurok;
    }

    public void setResPurok(String resPurok) {
        this.resPurok = resPurok;
    }

    public Integer getResbrgyID() {
        return resbrgyID;
    }

    public void setResbrgyID(Integer resbrgyID) {
        this.resbrgyID = resbrgyID;
    }

    public String getResBarangay() {
        return resBarangay;
    }

    public void setResBarangay(String resBarangay) {
        this.resBarangay = resBarangay;
    }

    public String getResHealthCond() {
        return resHealthCond;
    }

    public void setResHealthCond(String resHealthCond) {
        this.resHealthCond = resHealthCond;
    }

    public byte[] getResImage() {
        return resImage;
    }

    public void setResImage(byte[] resImage) {
        this.resImage = resImage;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (resId != null ? resId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Resident)) {
            return false;
        }
        Resident other = (Resident) object;
        if ((this.resId == null && other.resId != null) || (this.resId != null && !this.resId.equals(other.resId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JpaImplementation.Resident[ resId=" + resId + " ]";
    }
    
}
