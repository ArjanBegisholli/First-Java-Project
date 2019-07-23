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
@Table(name = "RegjistroHuazimet")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "RegjistroHuazimet.findAll", query = "SELECT s FROM RegjistroHuazimet s"),
  @NamedQuery(name = "RegjistroHuazimet.findByRegjistroHuazimetID", query = "SELECT s FROM RegjistroHuazimet s WHERE s.HuazimetID = :HuazimetID"),
  @NamedQuery(name = "RegjistroHuazimet.findByEmriKlientit", query = "SELECT s FROM RegjistroHuazimet s WHERE s.EmriKlientit = :EmriKlientit"),
  @NamedQuery(name = "RegjistroHuazimet.findByMbiemriKlientit", query = "SELECT s FROM RegjistroHuazimet s WHERE s.MbiemriKlientit = :MbiemriKlientit"),
  @NamedQuery(name = "RegjistroHuazimet.findByNrPersonal", query = "SELECT s FROM RegjistroHuazimet s WHERE    s.NrPersonal = :NrPersonal"),
  @NamedQuery(name = "RegjistroHuazimet.findByLlojivetures" , query = "SELECT s FROM RegjistroHuazimet s WHERE s.Llojivetures = :Llojivetures"),  
  @NamedQuery(name = "RegjistroHuazimet.findByModeli" , query = "SELECT s FROM RegjistroHuazimet s WHERE s.Modeli = :Modeli"), 
  @NamedQuery(name = "RegjistroHuazimet.findByNgjyra" , query = "SELECT s FROM RegjistroHuazimet s WHERE s.Ngjyra = :Ngjyra"), 
  @NamedQuery(name = "RegjistroHuazimet.findByCmimi" , query = "SELECT s FROM RegjistroHuazimet s WHERE s.Cmimi = :Cmimi"), 
  @NamedQuery(name = "RegjistroHuazimet.findByRentnDit" , query = "SELECT s FROM RegjistroHuazimet s WHERE s.RentnDit = :RentnDit"), 
  @NamedQuery(name = "RegjistroHuazimet.findByDataKthimit", query = "SELECT s FROM RegjistroHuazimet s WHERE s.DataKthimit = :DataKthimit"),
  @NamedQuery(name = "RegjistroHuazimet.findByDataHuazimit", query = "SELECT s FROM RegjistroHuazimet s WHERE s.DataHuazimit = :DataHuazimit")
  })
public class RegjistroHuazimet implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "HuazimetID")
    @GeneratedValue(generator="InvSeq")
    @SequenceGenerator(name="InvSeq",sequenceName="INV_SEQ", allocationSize=1)
    private Integer HuazimetID;
    
    @Basic(optional = false)
    @Column(name = "EmriKlientit")
    private String EmriKlientit;
    
    @Basic(optional = false)
    @Column(name = "MbiemriKlientit")
    private String MbiemriKlientit;
    
     @Basic(optional = false)
    @Column(name = "NrPersonal")
    private String NrPersonal;
     
      @Basic(optional = false)
    @Column(name = "Llojivetures")
    private String Llojivetures;
            @Basic(optional = false)
    @Column(name = "Modeli")
    private String Modeli;
                  @Basic(optional = false)
    @Column(name = "Ngjyra")
    private String Ngjyra;
                        @Basic(optional = false)
    @Column(name = "RentnDit")
    private String RentnDit;
    
    @Basic(optional = false)
    @Column(name = "DataHuazimit")
    @Temporal(TemporalType.DATE)
    private Date DataHuazimit;
    
    @Basic(optional = false)
    @Column(name = "DataKthimit")
    @Temporal(TemporalType.DATE)
    private Date DataKthimit;
    
     @Basic(optional = false)
    @Column(name = "Cmimi")
    private float Cmimi;
   

    public RegjistroHuazimet() {
    }

    public RegjistroHuazimet(Integer HuazimetID) {
        this.HuazimetID = HuazimetID;
    }

    public RegjistroHuazimet(Integer HuazimetID, Date DataHuazimit,Date DataKthimit,String EmriKlientit,String MbiemriKlientit,String Llojivetures,String Modeli,String Ngjyra,String RentnDit,String NrPersonal,float Cmimi) {
        this.HuazimetID = HuazimetID;
        this.EmriKlientit = EmriKlientit;
        this.MbiemriKlientit = MbiemriKlientit;
        this.NrPersonal = NrPersonal;
        this.Llojivetures = Llojivetures;
        this.Modeli=Modeli;
        this.Ngjyra=Ngjyra;
        this.RentnDit=RentnDit;
        this.DataKthimit = DataKthimit;
        this.DataHuazimit = DataHuazimit;
        this.Cmimi = Cmimi;
        
    }

    public Integer getRegjistroHuazimetID() {
        return HuazimetID;
    }

    public void setRegjistroHuazimetID(Integer HuazimetID) {
        this.HuazimetID = HuazimetID;
    }
    public String getEmriKlientit() {
        return EmriKlientit;
    }

    public void setEmriKlientit(String EmriKlientit) {
        this.EmriKlientit = EmriKlientit;
    }

    public String getMbiemriKlientit() {
        return MbiemriKlientit;
    }

    public void setMbiemriKlientit(String MbiemriKlientit) {
        this.MbiemriKlientit = MbiemriKlientit;
    }
    public String getNrPersonal (){
        return  NrPersonal;
    }
    public void setNrPersonal (String NrPersonal){
    this.NrPersonal = NrPersonal;
    }
     public String getLlojivetures (){
        return  Llojivetures;
    }
    public void setLlojivetures (String Llojivetures){
    this.Llojivetures = Llojivetures;
    }
       public String getModeli (){
        return  Modeli;
    }
    public void setModeli(String Modeli){
    this.Modeli = Modeli;
    }
       public String getNgjyra (){
        return  Ngjyra;
    }
    public void setNgjyra (String Ngjyra){
    this.Ngjyra = Ngjyra;
    }
       public String getRentnDit(){
        return  RentnDit;
    }
    public void setRentnDit(String RentnDit){
    this.RentnDit = RentnDit;
    }
     public Date getDataKthimit() {
        return DataKthimit;
    }

    public void setDataKthimit(Date DataKthimit) {
        this.DataKthimit = DataKthimit;
    }
     public Date getDataHuazimit() {
        return DataHuazimit;
    }
    public void setDataHuazimit(Date DataHuazimit) {
        this.DataHuazimit = DataHuazimit;
    }
     public float getCmimi() {
        return Cmimi;
    }
    public void setCmimi(float Cmimi) {
        this.Cmimi = Cmimi;
    }

  

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (HuazimetID != null ? HuazimetID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RegjistroHuazimet)) {
            return false;
        }
        RegjistroHuazimet other = (RegjistroHuazimet) object;
        return !((this.HuazimetID == null && other.HuazimetID != null) || (this.HuazimetID != null && !this.HuazimetID.equals(other.HuazimetID)));
    }

    @Override
    public String toString() {
        return "BL.RegjistroHuazimet[ HuazimetID=" + HuazimetID + " ]";
    }
    
}
