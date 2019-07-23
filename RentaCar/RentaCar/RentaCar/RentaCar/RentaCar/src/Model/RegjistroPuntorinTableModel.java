package Model;

import BL.RegjistroPuntorin;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import static DAL.MyMethods.returnTxt1;
import static DAL.MyMethods.returnTxt2;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;


public class RegjistroPuntorinTableModel extends AbstractTableModel {
    
    private final String [] columnNames = {"Emri","Mbiemri","Ditelindja","UserName","Password","Rroga","NrLeternjoftimit","Adresa","Kontakti","Gjinia","StatusiM"};
    
    private List <RegjistroPuntorin> data;
    
    public RegjistroPuntorinTableModel(List<RegjistroPuntorin>data){
        this.data = data;
    }

    public RegjistroPuntorinTableModel() {
   
    }
    public void add(List<RegjistroPuntorin>data){
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

    public RegjistroPuntorin getRegjistroPuntorin(int index){
        return data.get(index);
    }
     public String getDate (Date date){
        DateFormat da = new SimpleDateFormat("dd/MM/yyyy");
        return da.format(date);
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        RegjistroPuntorin s = (RegjistroPuntorin)data.get(rowIndex);
        switch(columnIndex){
            
            case 0:
                return s.getEmri();
            case 1:
                return s.getMbiemri();
            case 2:
                return getDate(s.getDitelindja());  
            case 3: 
                 return s.getUserName();    
            case 4: 
                 return s.getPassword();
            case 5:
                     return s.getRroga();
            case 6:
                return s.getNrLeternjoftimit();
            case 7:
                return s.getAdresa();
            case 8:
                return s.getKontakti();
            case 9:
        {
            try {
                return returnTxt1(s.getGjiniaID(),"Gjinia");
            } catch (SQLException ex) {
                Logger.getLogger(RegjistroPuntorinTableModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            case 10:
        {
            try {
                return returnTxt1(s.getStatusiMartesorID(),"StatusiMartesor");
            } catch (SQLException ex) {
                Logger.getLogger(RegjistroPuntorinTableModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            default:
                return null;
        }
    }
        
    }


 