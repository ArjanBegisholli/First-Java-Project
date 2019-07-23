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
@Table(name = "RegjistroPuntorin")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RegjistroPuntorin.findAll", query = "SELECT s FROM RegjistroPuntorin s"),
    @NamedQuery(name = "RegjistroPuntorin.findByRegjistroPuntorinID", query = "SELECT s FROM RegjistroPuntorin s WHERE s.PuntoriID = :PuntoriID"),
    @NamedQuery(name = "RegjistroPuntorin.findByEmri", query = "SELECT s FROM RegjistroPuntorin s WHERE s.emri = :emri"),
    @NamedQuery(name = "RegjistroPuntorin.findByRroga", query = "SELECT s FROM RegjistroPuntorin s WHERE s.Rroga = :Rroga"),
    @NamedQuery(name = "RegjistroPuntorin.findByMbiemri", query = "SELECT s FROM RegjistroPuntorin s WHERE s.mbiemri = :mbiemri"),
    @NamedQuery(name = "RegjistroPuntorin.findByDitelindja", query = "SELECT s FROM RegjistroPuntorin s WHERE s.ditelindja = :ditelindja"),
    @NamedQuery(name = "RegjistroPuntorin.findByUserName", query = "SELECT s FROM RegjistroPuntorin s WHERE s.UserName = :UserName"),
    @NamedQuery(name = "RegjistroPuntorin.findByPassword", query = "SELECT s FROM RegjistroPuntorin s WHERE s.Password = :Password"),
    @NamedQuery(name = "RegjistroPuntorin.findByGjiniaID", query = "SELECT s FROM RegjistroPuntorin s WHERE s.GjiniaID = :GjiniaID"),
    @NamedQuery(name = "RegjistroPuntorin.findByStatusiMartesorID", query = "SELECT s FROM RegjistroPuntorin s WHERE s.StatusiMartesorID = :StatusiMartesorID"),
    @NamedQuery(name = "RegjistroPuntorin.findByAdresa", query = "SELECT s FROM RegjistroPuntorin s WHERE s.Adresa = :Adresa"),
    @NamedQuery(name = "RegjistroPuntorin.findByNrLeternjoftimit", query = "SELECT s FROM RegjistroPuntorin s WHERE s.NrLeternjoftimit = :NrLeternjoftimit"),
    @NamedQuery(name = "RegjistroPuntorin.findByKontakti", query = "SELECT s FROM RegjistroPuntorin s WHERE s.Kontakti = :Kontakti")
    })
public class RegjistroPuntorin implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PuntoriID")
    @GeneratedValue(generator="InvSeq")
    @SequenceGenerator(name="InvSeq",sequenceName="INV_SEQ", allocationSize=1)
    private Integer PuntoriID;
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
    @Column(name = "UserName")
    private String UserName;
    @Basic(optional = false)
    @Column(name = "Password")
    private String Password;
    
    @Basic(optional = false)
    @Column(name = "Rroga")
    private float Rroga;
    @Basic(optional = false)
    @Column(name = "GjiniaID")
    private int GjiniaID;
    
    @Basic(optional = false)
    @Column(name = "StatusiMartesorID")
    private int StatusiMartesorID;
    
    @Basic(optional = false)
    @Column(name = "Adresa")
    private String Adresa;
    
    @Basic(optional = false)
    @Column(name = "NrLeternjoftimit")
    private String NrLeternjoftimit;
    
    @Basic(optional = false)
    @Column(name = "Kontakti")
    private String Kontakti;
    
    
    public RegjistroPuntorin() {
    }

    public RegjistroPuntorin(Integer PuntoriID) {
        this.PuntoriID = PuntoriID;
    }

    public RegjistroPuntorin(Integer PuntoriID, String emri, String mbiemri, Date ditelindja, String UserName, String Password, float Rroga,int GjiniaID ,int StatusiMartesorID,String Adresa, String NrLeternjoftimit,String Kontakti) {
        this.PuntoriID = PuntoriID;
        this.emri = emri;
        this.mbiemri = mbiemri;
        this.ditelindja = ditelindja;
        this.UserName = UserName;
        this.Password=Password;
        this.Rroga = Rroga;
        this.GjiniaID = GjiniaID;
        this.StatusiMartesorID=StatusiMartesorID;
        this.Adresa=Adresa;
        this.NrLeternjoftimit = NrLeternjoftimit;
        this.Kontakti=Kontakti;
    }

    public Integer getRegjistroPuntorinID() {
        return PuntoriID;
    }

    public void setRegjistroPuntorinID(Integer PuntoriID) {
        this.PuntoriID = PuntoriID;
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

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }
       public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
      
    public float getRroga(){
        return Rroga;
    }
    public void setRroga(float Rroga){
    this.Rroga = Rroga;
    }
     public int getGjiniaID(){
        return GjiniaID;
    }
    public void setGjiniaID(int GjiniaID){
    this.GjiniaID = GjiniaID;
    }
      public int getStatusiMartesorID(){
        return StatusiMartesorID;
    }
    public void setStatusiMartesorID(int StatusiMartesorID){
    this.StatusiMartesorID = StatusiMartesorID;
    }
       public String getAdresa(){
        return Adresa;
    }
    public void setAdresa(String Adresa){
    this.Adresa = Adresa;
    }
        public String getNrLeternjoftimit(){
        return NrLeternjoftimit;
    }
    public void setNrLeternjoftimit(String NrLeternjoftimit){
    this.NrLeternjoftimit = NrLeternjoftimit;
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
        hash += (PuntoriID != null ? PuntoriID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RegjistroPuntorin)) {
            return false;
        }
        RegjistroPuntorin other = (RegjistroPuntorin) object;
        if ((this.PuntoriID == null && other.PuntoriID != null) || (this.PuntoriID != null && !this.PuntoriID.equals(other.PuntoriID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BL.RegjistroPuntorin[ PuntoriID=" + PuntoriID + " ]";
    }
    
}
