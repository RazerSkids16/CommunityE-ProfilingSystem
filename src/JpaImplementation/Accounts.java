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
@Table(name = "accounts")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Accounts.findAll", query = "SELECT a FROM Accounts a")
    , @NamedQuery(name = "Accounts.findByAccBrgyHealthID", query = "SELECT a FROM Accounts a WHERE a.accBrgyHealthID = :accBrgyHealthID")
    , @NamedQuery(name = "Accounts.findByAccFullname", query = "SELECT a FROM Accounts a WHERE a.accFullname = :accFullname")
    , @NamedQuery(name = "Accounts.findByAccGender", query = "SELECT a FROM Accounts a WHERE a.accGender = :accGender")
    , @NamedQuery(name = "Accounts.findByAccContactNum", query = "SELECT a FROM Accounts a WHERE a.accContactNum = :accContactNum")
    , @NamedQuery(name = "Accounts.findByAccPosition", query = "SELECT a FROM Accounts a WHERE a.accPosition = :accPosition")
    , @NamedQuery(name = "Accounts.findByAccUsername", query = "SELECT a FROM Accounts a WHERE a.accUsername = :accUsername")
    , @NamedQuery(name = "Accounts.findByAccPassword", query = "SELECT a FROM Accounts a WHERE a.accPassword = :accPassword")})
public class Accounts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "acc_BrgyHealthID")
    private Integer accBrgyHealthID;
    @Column(name = "acc_fullname")
    private String accFullname;
    @Column(name = "acc_gender")
    private String accGender;
    @Column(name = "acc_ContactNum")
    private String accContactNum;
    @Column(name = "acc_position")
    private String accPosition;
    @Column(name = "acc_username")
    private String accUsername;
    @Column(name = "acc_password")
    private String accPassword;
    @Lob
    @Column(name = "acc_image")
    private byte[] accImage;

    public Accounts() {
    }

    public Accounts(Integer accBrgyHealthID) {
        this.accBrgyHealthID = accBrgyHealthID;
    }

    public Integer getAccBrgyHealthID() {
        return accBrgyHealthID;
    }

    public void setAccBrgyHealthID(Integer accBrgyHealthID) {
        this.accBrgyHealthID = accBrgyHealthID;
    }

    public String getAccFullname() {
        return accFullname;
    }

    public void setAccFullname(String accFullname) {
        this.accFullname = accFullname;
    }

    public String getAccGender() {
        return accGender;
    }

    public void setAccGender(String accGender) {
        this.accGender = accGender;
    }

    public String getAccContactNum() {
        return accContactNum;
    }

    public void setAccContactNum(String accContactNum) {
        this.accContactNum = accContactNum;
    }

    public String getAccPosition() {
        return accPosition;
    }

    public void setAccPosition(String accPosition) {
        this.accPosition = accPosition;
    }

    public String getAccUsername() {
        return accUsername;
    }

    public void setAccUsername(String accUsername) {
        this.accUsername = accUsername;
    }

    public String getAccPassword() {
        return accPassword;
    }

    public void setAccPassword(String accPassword) {
        this.accPassword = accPassword;
    }

    public byte[] getAccImage() {
        return accImage;
    }

    public void setAccImage(byte[] accImage) {
        this.accImage = accImage;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accBrgyHealthID != null ? accBrgyHealthID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Accounts)) {
            return false;
        }
        Accounts other = (Accounts) object;
        if ((this.accBrgyHealthID == null && other.accBrgyHealthID != null) || (this.accBrgyHealthID != null && !this.accBrgyHealthID.equals(other.accBrgyHealthID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JpaImplementation.Accounts[ accBrgyHealthID=" + accBrgyHealthID + " ]";
    }
    
}
