/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Naim
 */
@Entity
@Table(name = "Stafi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stafi.findAll", query = "SELECT s FROM Stafi s"),
    @NamedQuery(name = "Stafi.findByStafiId", query = "SELECT s FROM Stafi s WHERE s.stafiId = :stafiId"),
    @NamedQuery(name = "Stafi.findBySEmri", query = "SELECT s FROM Stafi s WHERE s.sEmri = :sEmri"),
    @NamedQuery(name = "Stafi.findBySMbiemri", query = "SELECT s FROM Stafi s WHERE s.sMbiemri = :sMbiemri"),
    @NamedQuery(name = "Stafi.findBySTel", query = "SELECT s FROM Stafi s WHERE s.sTel = :sTel"),
    @NamedQuery(name = "Stafi.findBySUser", query = "SELECT s FROM Stafi s WHERE s.sUser = :sUser"),
    @NamedQuery(name = "Stafi.findBySPassword", query = "SELECT s FROM Stafi s WHERE s.sPassword = :sPassword"),
    @NamedQuery(name = "Stafi.findBySRoli", query = "SELECT s FROM Stafi s WHERE s.sRoli = :sRoli")})
public class Stafi implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Stafi_Id")
    private Integer stafiId;
    @Basic(optional = false)
    @Column(name = "S_Emri")
    private String sEmri;
    @Basic(optional = false)
    @Column(name = "S_Mbiemri")
    private String sMbiemri;
    @Basic(optional = false)
    @Column(name = "S_Tel")
    private String sTel;
    @Basic(optional = false)
    @Column(name = "S_User")
    private String sUser;
    @Basic(optional = false)
    @Column(name = "S_Password")
    private String sPassword;
    @Basic(optional = false)
    @Column(name = "S_Roli")
    private int sRoli;
    @OneToMany(mappedBy = "lStafiId")
    private Collection<Libri> libriCollection;

    public Stafi() {
    }

    public Stafi(Integer stafiId) {
        this.stafiId = stafiId;
    }

    public Stafi(Integer stafiId, String sEmri, String sMbiemri, String sTel, String sUser, String sPassword, int sRoli) {
        this.stafiId = stafiId;
        this.sEmri = sEmri;
        this.sMbiemri = sMbiemri;
        this.sTel = sTel;
        this.sUser = sUser;
        this.sPassword = sPassword;
        this.sRoli = sRoli;
    }

    public Integer getStafiId() {
        return stafiId;
    }

    public void setStafiId(Integer stafiId) {
        this.stafiId = stafiId;
    }

    public String getSEmri() {
        return sEmri;
    }

    public void setSEmri(String sEmri) {
        this.sEmri = sEmri;
    }

    public String getSMbiemri() {
        return sMbiemri;
    }

    public void setSMbiemri(String sMbiemri) {
        this.sMbiemri = sMbiemri;
    }

    public String getSTel() {
        return sTel;
    }

    public void setSTel(String sTel) {
        this.sTel = sTel;
    }

    public String getSUser() {
        return sUser;
    }

    public void setSUser(String sUser) {
        this.sUser = sUser;
    }

    public String getSPassword() {
        return sPassword;
    }

    public void setSPassword(String sPassword) {
        this.sPassword = sPassword;
    }

    public int getSRoli() {
        return sRoli;
    }

    public void setSRoli(int sRoli) {
        this.sRoli = sRoli;
    }

    @XmlTransient
    public Collection<Libri> getLibriCollection() {
        return libriCollection;
    }

    public void setLibriCollection(Collection<Libri> libriCollection) {
        this.libriCollection = libriCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stafiId != null ? stafiId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stafi)) {
            return false;
        }
        Stafi other = (Stafi) object;
        if ((this.stafiId == null && other.stafiId != null) || (this.stafiId != null && !this.stafiId.equals(other.stafiId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BLL.Stafi[ stafiId=" + stafiId + " ]";
    }
    
}
