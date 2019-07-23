package Model;

import BL.RegjistroVeturen;
import DAL.Lidhja;
import DAL.MyMethods;
import static DAL.MyMethods.returnTxt1;
import GUI.RegjistroVeturenForm;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;


public class RegjistroVeturenTableModel extends AbstractTableModel {
    
    private final String [] columnNames = {"Modeli","Kilometrazha","VitiProdhimit", "LlojiveturesID", "Marshi", "Targat","Ngjyra","Furnizimi","Rent","CmimiVetures","Pershkrimi","Disponshmuria","Statusi","MaxWeight","VIN","StockNumber"};
  
    private List <RegjistroVeturen> data;
    
    public RegjistroVeturenTableModel(List<RegjistroVeturen>data){
        this.data = data;
    }

    public RegjistroVeturenTableModel() {
   
    }
    public void add(List<RegjistroVeturen>data){
        this.data = data;
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }
    
    public String getColumnName(int col){
        return columnNames[col];
    }
    public void remove(int row){
        data.remove(row);
    }

    public RegjistroVeturen getRegjistroVeturen(int index){
        return data.get(index);
    }
     public String getDate (Date date){
        DateFormat da = new SimpleDateFormat("dd/MM/yyyy");
        return da.format(date);
    }
         
   
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        RegjistroVeturen s = (RegjistroVeturen)data.get(rowIndex);
        switch(columnIndex){

            case 0:
                return s.getModeli();
            case 1:
                return s.getKilometrazha();
            case 2:
                return getDate(s.getVitiProdhimit());  
            case 3: 
        {
            try {
                return returnTxt1(s.getLlojiveturesID(),"Llojivetures");
            } catch (SQLException ex) {
                Logger.getLogger(RegjistroVeturenTableModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }    
            case 4: 
        {
            try {
                return returnTxt1(s.getMarshiID(),"Marshi");
            } catch (SQLException ex) {
                Logger.getLogger(RegjistroVeturenTableModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }    
            case 5: 
                 return s.getTargat();   
            case 6: 
                 return s.getNgjyra();  
            case 7: 
        {
            try {
                return returnTxt1(s.getFurnizimiID(),"Furnizimi");
            } catch (SQLException ex) {
                Logger.getLogger(RegjistroVeturenTableModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
            case 8:
                return s.getCmimiVeturespernjediteRent();
            case 9:
                return s.getCmimiVetures();
                  case 10:
                return s.getPershkrimi();
                  case 11:
        {
            try {
                return returnTxt1(s.getDisponshmuriaID(),"Disponshmuria");
            } catch (SQLException ex) {
                Logger.getLogger(RegjistroVeturenTableModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                  case 12:
        {
            try {
                return returnTxt1(s.getStatusiID(),"Statusi");
            } catch (SQLException ex) {
                Logger.getLogger(RegjistroVeturenTableModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                  case 13:
                return s.getMaxWeight();
                  case 14:
                return s.getVIN();
                  case 15:
                return s.getStockNumber();
            default:
                return null;
        }
    }
        
    }


 