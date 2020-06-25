/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Naim
 */
@Entity
@Table(name = "Klienti")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Klienti.findAll", query = "SELECT k FROM Klienti k"),
    @NamedQuery(name = "Klienti.findByKId", query = "SELECT k FROM Klienti k WHERE k.kId = :kId"),
    @NamedQuery(name = "Klienti.findByKEmri", query = "SELECT k FROM Klienti k WHERE k.kEmri = :kEmri"),
    @NamedQuery(name = "Klienti.findByKMbiemri", query = "SELECT k FROM Klienti k WHERE k.kMbiemri = :kMbiemri"),
    @NamedQuery(name = "Klienti.findByKMosha", query = "SELECT k FROM Klienti k WHERE k.kMosha = :kMosha"),
    @NamedQuery(name = "Klienti.findByKGjinia", query = "SELECT k FROM Klienti k WHERE k.kGjinia = :kGjinia"),
    @NamedQuery(name = "Klienti.findByKDataLindjes", query = "SELECT k FROM Klienti k WHERE k.kDataLindjes = :kDataLindjes"),
    @NamedQuery(name = "Klienti.findByKTel", query = "SELECT k FROM Klienti k WHERE k.kTel = :kTel"),
    @NamedQuery(name = "Klienti.findByKShteti", query = "SELECT k FROM Klienti k WHERE k.kShteti = :kShteti"),
    @NamedQuery(name = "Klienti.findByKEmail", query = "SELECT k FROM Klienti k WHERE k.kEmail = :kEmail")})
public class Klienti implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "K_Id")
    private Integer kId;
    @Basic(optional = false)
    @Column(name = "K_Emri")
    private String kEmri;
    @Basic(optional = false)
    @Column(name = "K_Mbiemri")
    private String kMbiemri;
    @Basic(optional = false)
    @Column(name = "K_Mosha")
    private int kMosha;
    @Basic(optional = false)
    @Column(name = "K_Gjinia")
    private String kGjinia;
    @Column(name = "K_Data_Lindjes")
    @Temporal(TemporalType.DATE)
    private Date kDataLindjes;
    @Basic(optional = false)
    @Column(name = "K_Tel")
    private String kTel;
    @Basic(optional = false)
    @Column(name = "K_Shteti")
    private String kShteti;
    @Basic(optional = false)
    @Column(name = "K_Email")
    private String kEmail;
    @OneToMany(mappedBy = "hLKlientiId")
    private Collection<HuazimiLibrit> huazimiLibritCollection;

    public Klienti() {
    }

    public Klienti(Integer kId) {
        this.kId = kId;
    }

    public Klienti(Integer kId, String kEmri, String kMbiemri, int kMosha, String kGjinia, String kTel, String kShteti, String kEmail) {
        this.kId = kId;
        this.kEmri = kEmri;
        this.kMbiemri = kMbiemri;
        this.kMosha = kMosha;
        this.kGjinia = kGjinia;
        this.kTel = kTel;
        this.kShteti = kShteti;
        this.kEmail = kEmail;
    }

    public Integer getKId() {
        return kId;
    }

    public void setKId(Integer kId) {
        this.kId = kId;
    }

    public String getKEmri() {
        return kEmri;
    }

    public void setKEmri(String kEmri) {
        this.kEmri = kEmri;
    }

    public String getKMbiemri() {
        return kMbiemri;
    }

    public void setKMbiemri(String kMbiemri) {
        this.kMbiemri = kMbiemri;
    }

    public int getKMosha() {
        return kMosha;
    }

    public void setKMosha(int kMosha) {
        this.kMosha = kMosha;
    }

    public String getKGjinia() {
        return kGjinia;
    }

    public void setKGjinia(String kGjinia) {
        this.kGjinia = kGjinia;
    }

    public Date getKDataLindjes() {
        return kDataLindjes;
    }

    public void setKDataLindjes(Date kDataLindjes) {
        this.kDataLindjes = kDataLindjes;
    }

    public String getKTel() {
        return kTel;
    }

    public void setKTel(String kTel) {
        this.kTel = kTel;
    }

    public String getKShteti() {
        return kShteti;
    }

    public void setKShteti(String kShteti) {
        this.kShteti = kShteti;
    }

    public String getKEmail() {
        return kEmail;
    }

    public void setKEmail(String kEmail) {
        this.kEmail = kEmail;
    }

    @XmlTransient
    public Collection<HuazimiLibrit> getHuazimiLibritCollection() {
        return huazimiLibritCollection;
    }

    public void setHuazimiLibritCollection(Collection<HuazimiLibrit> huazimiLibritCollection) {
        this.huazimiLibritCollection = huazimiLibritCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kId != null ? kId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Klienti)) {
            return false;
        }
        Klienti other = (Klienti) object;
        if ((this.kId == null && other.kId != null) || (this.kId != null && !this.kId.equals(other.kId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BLL.Klienti[ kId=" + kId + " ]";
    }
    
}
