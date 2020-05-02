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
@Table(name = "Kthimi_Librit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "KthimiLibrit.findAll", query = "SELECT k FROM KthimiLibrit k"),
    @NamedQuery(name = "KthimiLibrit.findByKthLId", query = "SELECT k FROM KthimiLibrit k WHERE k.kthLId = :kthLId"),
    @NamedQuery(name = "KthimiLibrit.findByKthLDataLeshuar", query = "SELECT k FROM KthimiLibrit k WHERE k.kthLDataLeshuar = :kthLDataLeshuar"),
    @NamedQuery(name = "KthimiLibrit.findByKthLDataKthyer", query = "SELECT k FROM KthimiLibrit k WHERE k.kthLDataKthyer = :kthLDataKthyer")})
public class KthimiLibrit implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "KthL_Id")
    private Integer kthLId;
    @Column(name = "KthL_Data_Leshuar")
    @Temporal(TemporalType.DATE)
    private Date kthLDataLeshuar;
    @Column(name = "KthL_Data_Kthyer")
    @Temporal(TemporalType.DATE)
    private Date kthLDataKthyer;
    @JoinColumn(name = "KthL_Klienti_Id", referencedColumnName = "K_Id")
    @ManyToOne
    private Klienti kthLKlientiId;
    @JoinColumn(name = "KthL_ISBN", referencedColumnName = "ISBN")
    @ManyToOne
    private Libri kthLISBN;

    public KthimiLibrit() {
    }

    public KthimiLibrit(Integer kthLId) {
        this.kthLId = kthLId;
    }

    public Integer getKthLId() {
        return kthLId;
    }

    public void setKthLId(Integer kthLId) {
        this.kthLId = kthLId;
    }

    public Date getKthLDataLeshuar() {
        return kthLDataLeshuar;
    }

    public void setKthLDataLeshuar(Date kthLDataLeshuar) {
        this.kthLDataLeshuar = kthLDataLeshuar;
    }

    public Date getKthLDataKthyer() {
        return kthLDataKthyer;
    }

    public void setKthLDataKthyer(Date kthLDataKthyer) {
        this.kthLDataKthyer = kthLDataKthyer;
    }

    public Klienti getKthLKlientiId() {
        return kthLKlientiId;
    }

    public void setKthLKlientiId(Klienti kthLKlientiId) {
        this.kthLKlientiId = kthLKlientiId;
    }

    public Libri getKthLISBN() {
        return kthLISBN;
    }

    public void setKthLISBN(Libri kthLISBN) {
        this.kthLISBN = kthLISBN;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kthLId != null ? kthLId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KthimiLibrit)) {
            return false;
        }
        KthimiLibrit other = (KthimiLibrit) object;
        if ((this.kthLId == null && other.kthLId != null) || (this.kthLId != null && !this.kthLId.equals(other.kthLId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BLL.KthimiLibrit[ kthLId=" + kthLId + " ]";
    }
    
}
