/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author
 */
@Entity
        @Table(name = "RegjistroKlientin")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RegjistroKlientin.findAll", query = "SELECT s FROM RegjistroKlientin s"),
    @NamedQuery(name = "RegjistroKlientin.findByKlientiID", query = "SELECT s FROM RegjistroKlientin s WHERE s.KlientiID = :KlientiID"),
    @NamedQuery(name = "RegjistroKlientin.findByEmri", query = "SELECT s FROM RegjistroKlientin s WHERE s.emri = :emri"),
    @NamedQuery(name = "RegjistroKlientin.findByMbiemri", query = "SELECT s FROM RegjistroKlientin s WHERE s.mbiemri = :mbiemri"),
    @NamedQuery(name = "RegjistroKlientin.findByDitelindja", query = "SELECT s FROM RegjistroKlientin s WHERE s.ditelindja = :ditelindja"),
    @NamedQuery(name = "RegjistroKlientin.findByGjiniaID", query = "SELECT s FROM RegjistroKlientin s WHERE s.GjiniaID = :GjiniaID"),
    @NamedQuery(name = "RegjistroKlientin.findByAdresa", query = "SELECT s FROM RegjistroKlientin s WHERE s.Adresa = :Adresa"),
    @NamedQuery(name = "RegjistroKlientin.findByNrPersonal", query = "SELECT s FROM RegjistroKlientin s WHERE s.NrPersonal = :NrPersonal"),
    @NamedQuery(name = "RegjistroKlientin.findByKontakti", query = "SELECT s FROM RegjistroKlientin s WHERE s.Kontakti = :Kontakti")
    })
public class RegjistroKlientin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
     @Basic(optional = false)
    @Column(name = "KlientiID")
    @GeneratedValue(generator="InvSeq")
    @SequenceGenerator(name="InvSeq",sequenceName="INV_SEQ", allocationSize=1)
    private Integer KlientiID;
    @Basic(optional = false)
    @Column(name = "Emri")
    private String emri;
    @Basic(optional = false)
    @Column(name = "Mbiemri")
    private String mbiemri;
    @Basic(optional = false)
    @Column(name = "Ditelindja")
    @Temporal(TemporalType.DATE)
    private Date ditelindja;
    @Basic(optional = false)
    @Column(name = "GjiniaID")
    private int GjiniaID;
    @Basic(optional = false)
    @Column(name = "Adresa")
    private String Adresa;
    
    @Basic(optional = false)
    @Column(name = "NrPersonal")
    private String NrPersonal;
    
    @Basic(optional = false)
    @Column(name = "Kontakti")
    private String Kontakti;

    public int getKlientiID() {
        return KlientiID;
    }

    public void setKlientiID(int KlientiID) {
        this.KlientiID = KlientiID;
    }
    public RegjistroKlientin() {
    }
    public RegjistroKlientin(Integer KlientiID) {
        this.KlientiID = KlientiID;
    }
      public RegjistroKlientin(Integer KlientiID, String emri, String mbiemri, Date ditelindja, int GjiniaID ,String Adresa, String NrPersonal,String Kontakti) {
        this.KlientiID = KlientiID;
        this.emri = emri;
        this.mbiemri = mbiemri;
        this.ditelindja = ditelindja;
        this.GjiniaID = GjiniaID;
        this.Adresa=Adresa;
        this.NrPersonal = NrPersonal;
        this.Kontakti=Kontakti;
    }
       public String getEmri() {
        return emri;
    }

    public void setEmri(String emri) {
        this.emri = emri;
    }

    public String getMbiemri() {
        return mbiemri;
    }

    public void setMbiemri(String mbiemri) {
        this.mbiemri = mbiemri;
    }

    public Date getDitelindja() {
        return ditelindja;
    }

    public void setDitelindja(Date ditelindja) {
        this.ditelindja = ditelindja;
    }
     public int getGjiniaID(){
        return GjiniaID;
    }
    public void setGjiniaID(int GjiniaID){
    this.GjiniaID = GjiniaID;
    }
    public String getAdresa(){
        return Adresa;
    }
    public void setAdresa(String Adresa){
    this.Adresa = Adresa;
    }
        public String getNrLeternjoftimit(){
        return NrPersonal;
    }
    public void setNrLeternjoftimit(String NrPersonal){
    this.NrPersonal = NrPersonal;
    }
     public String getKontakti(){
        return Kontakti;
    }
    public void setKontakti(String Kontakti){
    this.Kontakti = Kontakti;
    }
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (KlientiID != null ? KlientiID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the KlientiID fields are not set
        if (!(object instanceof RegjistroKlientin)) {
            return false;
        }
        RegjistroKlientin other = (RegjistroKlientin) object;
        if ((this.KlientiID == null && other.KlientiID != null) || (this.KlientiID != null && !this.KlientiID.equals(other.KlientiID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BL.RegjistroKlientin[ KlientiID=" + KlientiID + " ]";
    }
    
}
