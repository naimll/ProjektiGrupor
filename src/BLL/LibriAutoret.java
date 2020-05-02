/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Naim
 */
@Entity
@Table(name = "Libri_Autoret")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LibriAutoret.findAll", query = "SELECT l FROM LibriAutoret l"),
    @NamedQuery(name = "LibriAutoret.findByLAId", query = "SELECT l FROM LibriAutoret l WHERE l.lAId = :lAId")})
public class LibriAutoret implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "LA_Id")
    private Integer lAId;
    @JoinColumn(name = "A_Id", referencedColumnName = "A_Id")
    @ManyToOne
    private Autori aId;
    @JoinColumn(name = "ISBN", referencedColumnName = "ISBN")
    @ManyToOne
    private Libri isbn;

    public LibriAutoret() {
    }

    public LibriAutoret(Integer lAId) {
        this.lAId = lAId;
    }

    public Integer getLAId() {
        return lAId;
    }

    public void setLAId(Integer lAId) {
        this.lAId = lAId;
    }

    public Autori getAId() {
        return aId;
    }

    public void setAId(Autori aId) {
        this.aId = aId;
    }

    public Libri getIsbn() {
        return isbn;
    }

    public void setIsbn(Libri isbn) {
        this.isbn = isbn;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lAId != null ? lAId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LibriAutoret)) {
            return false;
        }
        LibriAutoret other = (LibriAutoret) object;
        if ((this.lAId == null && other.lAId != null) || (this.lAId != null && !this.lAId.equals(other.lAId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BLL.LibriAutoret[ lAId=" + lAId + " ]";
    }
    
}
