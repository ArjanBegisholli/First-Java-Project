/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "RegjistroVeturen")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RegjistroVeturen.findAll", query = "SELECT s FROM RegjistroVeturen s"),
    @NamedQuery(name = "RegjistroVeturen.findByRegjistroVeturenID", query = "SELECT s FROM RegjistroVeturen s WHERE s.VeturaID = :VeturaID"),
    @NamedQuery(name = "RegjistroVeturen.findByMaxWeight", query = "SELECT s FROM RegjistroVeturen s WHERE s.MaxWeight = :MaxWeight"),
    @NamedQuery(name = "RegjistroVeturen.findByLlojiveturesID", query = "SELECT s FROM RegjistroVeturen s WHERE s.LlojiveturesID = :LlojiveturesID"),
    @NamedQuery(name = "RegjistroVeturen.findByModeli", query = "SELECT s FROM RegjistroVeturen s WHERE s.Modeli = :Modeli"),
    @NamedQuery(name = "RegjistroVeturen.findByTargat", query = "SELECT s FROM RegjistroVeturen s WHERE s.Targat = :Targat"),
    @NamedQuery(name = "RegjistroVeturen.findByVitiProdhimit", query = "SELECT s FROM RegjistroVeturen s WHERE s.VitiProdhimit = :VitiProdhimit"),
    @NamedQuery(name = "RegjistroVeturen.findByMarshiID", query = "SELECT s FROM RegjistroVeturen s WHERE s.MarshiID = :MarshiID"),
    @NamedQuery(name = "RegjistroVeturen.findByCmimiVeturespernjediteRent", query = "SELECT s FROM RegjistroVeturen s WHERE s.CmimiVeturespernjediteRent = :CmimiVeturespernjediteRent"),
    @NamedQuery(name = "RegjistroVeturen.findByCmimiVetures", query = "SELECT s FROM RegjistroVeturen s WHERE s.CmimiVetures = :CmimiVetures"),
    @NamedQuery(name = "RegjistroVeturen.findByNgjyra", query = "SELECT s FROM RegjistroVeturen s WHERE s.Ngjyra = :Ngjyra"),
    @NamedQuery(name = "RegjistroVeturen.findByFurnizimiID", query = "SELECT s FROM RegjistroVeturen s WHERE s.FurnizimiID = :FurnizimiID"),
    @NamedQuery(name = "RegjistroVeturen.findByDisponshmuriaID", query = "SELECT s FROM RegjistroVeturen s WHERE s.DisponshmuriaID = :DisponshmuriaID"),
     @NamedQuery(name = "RegjistroVeturen.findByStatusiID", query = "SELECT s FROM RegjistroVeturen s WHERE s.StatusiID = :StatusiID"),
    @NamedQuery(name = "RegjistroVeturen.findByStockNumber", query = "SELECT s FROM RegjistroVeturen s WHERE s.StockNumber = :StockNumber"),
    @NamedQuery(name = "RegjistroVeturen.findByPershkrimi", query = "SELECT s FROM RegjistroVeturen s WHERE s.Pershkrimi = :Pershkrimi"),
    @NamedQuery(name = "RegjistroVeturen.findByVIN", query = "SELECT s FROM RegjistroVeturen s WHERE s.VIN = :VIN"),
    @NamedQuery(name = "RegjistroVeturen.findByKilometrazha", query = "SELECT s FROM RegjistroVeturen s WHERE s.Kilometrazha = :Kilometrazha")})
public class RegjistroVeturen implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "VeturaID")
    @GeneratedValue(generator="InvSeq")
    @SequenceGenerator(name="InvSeq",sequenceName="INV_SEQ", allocationSize=1)
    private Integer VeturaID;
    @Basic(optional = false)
    @Column(name = "Modeli")
    private String Modeli;
    @Basic(optional = false)
    @Column(name = "Ngjyra")
    private String Ngjyra;
    @Basic(optional = false)
    @Column(name = "LlojiveturesID")
    private int LlojiveturesID;
    @Basic(optional = false)
    @Column(name = "VitiProdhimit")
    @Temporal(TemporalType.DATE)
    private Date VitiProdhimit;
    @Basic(optional = false)
    @Column(name = "Targat")
    private String Targat;
    @Basic(optional = false)
    @Column(name = "MarshiID")
    private int MarshiID;
    @Basic(optional = false)
    @Column(name = "FurnizimiID")
    private int FurnizimiID;
    @Basic(optional = false)
    @Column(name = "Kilometrazha")
    private int Kilometrazha;
    @Basic(optional = false)
    @Column(name = "CmimiVetures")
    private float CmimiVetures;
    @Basic(optional = false)
    @Column(name = "MaxWeight")
    private  float MaxWeight;
      @Basic(optional = false)
    @Column(name = "StockNumber")
    private  int StockNumber;
        @Basic(optional = false)
    @Column(name = "VIN")
    private  String VIN;
          @Basic(optional = false)
    @Column(name = "Pershkrimi")
    private String Pershkrimi ;
    @Basic(optional = false)
    @Column(name = "DisponshmuriaID")
    private  int DisponshmuriaID;
     @Basic(optional = false)
    @Column(name = "CmimiVeturespernjediteRent")
    private  float CmimiVeturespernjediteRent; 
       @Basic(optional = false)
    @Column(name = "StatusiID")
    private  int StatusiID;
    
       
        
    
    public RegjistroVeturen() {
    }

    public RegjistroVeturen(Integer VeturaID) {
        this.VeturaID = VeturaID;
    }
   

    
    
    public RegjistroVeturen(Integer VeturaID, int FurnizimiID, int Kilometrazha, int LlojiveturesID, int MarshiID, String Modeli,String Ngjyra, String Targat, Date VitiProdhimit,float CmimiVetures, float CmimiVeturespernjediteRent,String Pershkrimi,int DisponshmuriaID,String VIN,int StockNumber, float MaxWeight,int StatusiID) {
    
        this.VeturaID = VeturaID;
        this.Modeli = Modeli;
        this.LlojiveturesID = LlojiveturesID;
        this.VitiProdhimit = VitiProdhimit;
        this.Targat = Targat;
        this.MarshiID=MarshiID;
        this.Kilometrazha=Kilometrazha;
        this.FurnizimiID=FurnizimiID;
        this.Ngjyra=Ngjyra;
        this.CmimiVetures=CmimiVetures;
        this.CmimiVeturespernjediteRent = CmimiVeturespernjediteRent;
        this.Pershkrimi = Pershkrimi;
        this.DisponshmuriaID =DisponshmuriaID;
        this.VIN = VIN;
        this.StockNumber=StockNumber;
        this.MaxWeight = MaxWeight;
        this.StatusiID=StatusiID;
        
    }

    public Integer getRegjistroVeturenID() {
        return VeturaID;
    }

    public void setRegjistroRegjistroVeturenID(Integer VeturaID) {
        this.VeturaID = VeturaID;
    }

    public String getModeli() {
        return Modeli;
    }

    public void setModeli(String Modeli) {
        this.Modeli = Modeli;
    }

    public int getLlojiveturesID() {
        return LlojiveturesID;
    }

    public void setLlojiveturesID(int LlojiveturesID) {
        this.LlojiveturesID = LlojiveturesID;
    }

    public Date getVitiProdhimit() {
        return VitiProdhimit;
    }

    public void setVitiProdhimit(Date VitiProdhimit) {
        this.VitiProdhimit = VitiProdhimit;
    }

    public String getTargat() {
        return Targat;
    }

    public void setTargat(String Targat) {
        this.Targat = Targat;
    }
       public int getMarshiID() {
        return MarshiID;
    }

    public void setMarshiID(int MarshiID) {
        this.MarshiID = MarshiID;
    }
         public String getNgjyra() {
        return Ngjyra;
    }

    public void setNgjyra(String Ngjyra) {
        this.Ngjyra = Ngjyra;
    }
         public int getFurnizimiID() {
        return FurnizimiID;
    }

    public void setFurnizimiID(int FurnizimiID) {
        this.FurnizimiID = FurnizimiID;
    }
    
       public int getKilometrazha() {
        return Kilometrazha;
    }

    public void setKilometrazha(int Kilometrazha) {
        this.Kilometrazha = Kilometrazha;
    }
    public float getCmimiVetures() {
        return CmimiVetures;
    }

    public void setCmimiVetures(float CmimiVetures) {
        this.CmimiVetures = CmimiVetures;
    }
        public float getCmimiVeturespernjediteRent() {
        return CmimiVeturespernjediteRent;
    }

    public void setCmimiVeturespernjediteRent(float CmimiVeturespernjediteRent) {
        this.CmimiVeturespernjediteRent = CmimiVeturespernjediteRent;
    }
    public String getPershkrimi() {
        return Pershkrimi;
    }

    public void setPershkrimi(String Pershkrimi) {
        this.Pershkrimi = Pershkrimi;
    }
     public float getMaxWeight() {
        return MaxWeight;
    }

    public void setMaxWeight(float MaxWeight) {
        this.MaxWeight = MaxWeight;
    }
     public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }
     public int getDisponshmuriaID() {
        return DisponshmuriaID;
    }

    public void setDisponshmuriaID (int DisponshmuriaID) {
        this.DisponshmuriaID = DisponshmuriaID;
    }
 public int getStockNumber() {
        return StockNumber;
    }

    public void setStockNumber(int StockNumber) {
        this.StockNumber = StockNumber;
    }
    
             public int getStatusiID() {
        return StatusiID;
    }

    public void setStatusiID(int StatusiID) {
        this.StatusiID = StatusiID;
    }

            
            
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (VeturaID != null ? VeturaID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RegjistroVeturen)) {
            return false;
        }
        RegjistroVeturen other = (RegjistroVeturen) object;
        return !((this.VeturaID == null && other.VeturaID != null) || (this.VeturaID != null && !this.VeturaID.equals(other.VeturaID)));
    }

    @Override
    public String toString() {
        return "BL.RegjistroVeturen[ VeturaID=" + VeturaID + " ]";
    }
    
}
