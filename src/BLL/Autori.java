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
@Table(name = "Autori")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Autori.findAll", query = "SELECT a FROM Autori a"),
    @NamedQuery(name = "Autori.findByAId", query = "SELECT a FROM Autori a WHERE a.aId = :aId"),
    @NamedQuery(name = "Autori.findByAEmri", query = "SELECT a FROM Autori a WHERE a.aEmri = :aEmri"),
    @NamedQuery(name = "Autori.findByAMbiemri", query = "SELECT a FROM Autori a WHERE a.aMbiemri = :aMbiemri"),
    @NamedQuery(name = "Autori.findByAVendlindja", query = "SELECT a FROM Autori a WHERE a.aVendlindja = :aVendlindja")})
public class Autori implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "A_Id")
    private Integer aId;
    @Basic(optional = false)
    @Column(name = "A_Emri")
    private String aEmri;
    @Basic(optional = false)
    @Column(name = "A_Mbiemri")
    private String aMbiemri;
    @Basic(optional = false)
    @Column(name = "A_Vendlindja")
    private String aVendlindja;
    @OneToMany(mappedBy = "autoriId")
    private Collection<Libri> libriCollection;

    public Autori() {
    }

    public Autori(Integer aId) {
        this.aId = aId;
    }

    public Autori(Integer aId, String aEmri, String aMbiemri, String aVendlindja) {
        this.aId = aId;
        this.aEmri = aEmri;
        this.aMbiemri = aMbiemri;
        this.aVendlindja = aVendlindja;
    }

    public Integer getAId() {
        return aId;
    }

    public void setAId(Integer aId) {
        this.aId = aId;
    }

    public String getAEmri() {
        return aEmri;
    }

    public void setAEmri(String aEmri) {
        this.aEmri = aEmri;
    }

    public String getAMbiemri() {
        return aMbiemri;
    }

    public void setAMbiemri(String aMbiemri) {
        this.aMbiemri = aMbiemri;
    }

    public String getAVendlindja() {
        return aVendlindja;
    }

    public void setAVendlindja(String aVendlindja) {
        this.aVendlindja = aVendlindja;
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
        hash += (aId != null ? aId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Autori)) {
            return false;
        }
        Autori other = (Autori) object;
        if ((this.aId == null && other.aId != null) || (this.aId != null && !this.aId.equals(other.aId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.aEmri+" "+this.aMbiemri;
    }
    
}
