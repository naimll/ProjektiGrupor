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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Naim
 */
@Entity
@Table(name = "Libri")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Libri.findAll", query = "SELECT l FROM Libri l"),
    @NamedQuery(name = "Libri.findByIsbn", query = "SELECT l FROM Libri l WHERE l.isbn = :isbn"),
    @NamedQuery(name = "Libri.findByLTitulli", query = "SELECT l FROM Libri l WHERE l.lTitulli = :lTitulli"),
    @NamedQuery(name = "Libri.findByLVitiBotimit", query = "SELECT l FROM Libri l WHERE l.lVitiBotimit = :lVitiBotimit"),
    @NamedQuery(name = "Libri.findByLShtepiaBotuese", query = "SELECT l FROM Libri l WHERE l.lShtepiaBotuese = :lShtepiaBotuese"),
    @NamedQuery(name = "Libri.findByLSasia", query = "SELECT l FROM Libri l WHERE l.lSasia = :lSasia"),
    @NamedQuery(name = "Libri.findByLCmimiMujor", query = "SELECT l FROM Libri l WHERE l.lCmimiMujor = :lCmimiMujor")})
public class Libri implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ISBN")
    private String isbn;
    @Basic(optional = false)
    @Column(name = "L_Titulli")
    private String lTitulli;
    @Basic(optional = false)
    @Column(name = "L_Viti_Botimit")
    private int lVitiBotimit;
    @Basic(optional = false)
    @Column(name = "L_Shtepia_Botuese")
    private String lShtepiaBotuese;
    @Basic(optional = false)
    @Column(name = "L_Sasia")
    private int lSasia;
    @Basic(optional = false)
    @Column(name = "L_Cmimi_Mujor")
    private double lCmimiMujor;

    public Libri() {
    }

    public Libri(String isbn) {
        this.isbn = isbn;
    }

    public Libri(String isbn, String lTitulli, int lVitiBotimit, String lShtepiaBotuese, int lSasia, double lCmimiMujor) {
        this.isbn = isbn;
        this.lTitulli = lTitulli;
        this.lVitiBotimit = lVitiBotimit;
        this.lShtepiaBotuese = lShtepiaBotuese;
        this.lSasia = lSasia;
        this.lCmimiMujor = lCmimiMujor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getLTitulli() {
        return lTitulli;
    }

    public void setLTitulli(String lTitulli) {
        this.lTitulli = lTitulli;
    }

    public int getLVitiBotimit() {
        return lVitiBotimit;
    }

    public void setLVitiBotimit(int lVitiBotimit) {
        this.lVitiBotimit = lVitiBotimit;
    }

    public String getLShtepiaBotuese() {
        return lShtepiaBotuese;
    }

    public void setLShtepiaBotuese(String lShtepiaBotuese) {
        this.lShtepiaBotuese = lShtepiaBotuese;
    }

    public int getLSasia() {
        return lSasia;
    }

    public void setLSasia(int lSasia) {
        this.lSasia = lSasia;
    }

    public double getLCmimiMujor() {
        return lCmimiMujor;
    }

    public void setLCmimiMujor(double lCmimiMujor) {
        this.lCmimiMujor = lCmimiMujor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (isbn != null ? isbn.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Libri)) {
            return false;
        }
        Libri other = (Libri) object;
        if ((this.isbn == null && other.isbn != null) || (this.isbn != null && !this.isbn.equals(other.isbn))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BLL.Libri[ isbn=" + isbn + " ]";
    }
    
}
