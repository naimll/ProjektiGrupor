/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Naim
 */
@Entity
@Table(name = "Huazimi_Librit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HuazimiLibrit.findAll", query = "SELECT h FROM HuazimiLibrit h"),
    @NamedQuery(name = "HuazimiLibrit.findByHLId", query = "SELECT h FROM HuazimiLibrit h WHERE h.hLId = :hLId"),
    @NamedQuery(name = "HuazimiLibrit.findByHLDataLeshimit", query = "SELECT h FROM HuazimiLibrit h WHERE h.hLDataLeshimit = :hLDataLeshimit"),
    @NamedQuery(name = "HuazimiLibrit.findByHLDataKthimit", query = "SELECT h FROM HuazimiLibrit h WHERE h.hLDataKthimit = :hLDataKthimit")})
public class HuazimiLibrit implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "HL_Id")
    private Integer hLId;
    @Basic(optional = false)
    @Column(name = "HL_Data_Leshimit")
    @Temporal(TemporalType.DATE)
    private Date hLDataLeshimit;
    @Basic(optional = false)
    @Column(name = "HL_Data_Kthimit")
    @Temporal(TemporalType.DATE)
    private Date hLDataKthimit;
    @JoinColumn(name = "HL_Klienti_Id", referencedColumnName = "K_Id")
    @ManyToOne
    private Klienti hLKlientiId;
    @JoinColumn(name = "HL_ISBN", referencedColumnName = "ISBN")
    @ManyToOne
    private Libri hlIsbn;

    public HuazimiLibrit() {
    }

    public HuazimiLibrit(Integer hLId) {
        this.hLId = hLId;
    }

    public HuazimiLibrit(Integer hLId, Date hLDataLeshimit, Date hLDataKthimit) {
        this.hLId = hLId;
        this.hLDataLeshimit = hLDataLeshimit;
        this.hLDataKthimit = hLDataKthimit;
    }

    public Integer getHLId() {
        return hLId;
    }

    public void setHLId(Integer hLId) {
        this.hLId = hLId;
    }

    public Date getHLDataLeshimit() {
        return hLDataLeshimit;
    }

    public void setHLDataLeshimit(Date hLDataLeshimit) {
        this.hLDataLeshimit = hLDataLeshimit;
    }

    public Date getHLDataKthimit() {
        return hLDataKthimit;
    }

    public void setHLDataKthimit(Date hLDataKthimit) {
        this.hLDataKthimit = hLDataKthimit;
    }

    public Klienti getHLKlientiId() {
        return hLKlientiId;
    }

    public void setHLKlientiId(Klienti hLKlientiId) {
        this.hLKlientiId = hLKlientiId;
    }

    public Libri getHlIsbn() {
        return hlIsbn;
    }

    public void setHlIsbn(Libri hlIsbn) {
        this.hlIsbn = hlIsbn;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hLId != null ? hLId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HuazimiLibrit)) {
            return false;
        }
        HuazimiLibrit other = (HuazimiLibrit) object;
        if ((this.hLId == null && other.hLId != null) || (this.hLId != null && !this.hLId.equals(other.hLId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BLL.HuazimiLibrit[ hLId=" + hLId + " ]";
    }
    
}
