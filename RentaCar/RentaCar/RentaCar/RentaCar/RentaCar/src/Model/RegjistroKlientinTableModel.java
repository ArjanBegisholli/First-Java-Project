package Model;

import BL.RegjistroKlientin;
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


public class RegjistroKlientinTableModel extends AbstractTableModel {
    
    private final String [] columnNames = {"Emri","Mbiemri","Ditelindja","NrLeternjoftimit","Adresa","Kontakti","Gjinia"};
    
    private List <RegjistroKlientin> data;
    
    public RegjistroKlientinTableModel(List<RegjistroKlientin>data){
        this.data = data;
    }

    public RegjistroKlientinTableModel() {
   
    }
    public void add(List<RegjistroKlientin>data){
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
    
    @Override
    public String getColumnName(int col){
        return columnNames[col];
    }
    public void remove(int row){
        data.remove(row);
    }

    public RegjistroKlientin getRegjistroPuntorin(int index){
        return data.get(index);
    }
     public String getDate (Date date){
        DateFormat da = new SimpleDateFormat("dd/MM/yyyy");
        return da.format(date);
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        RegjistroKlientin s = (RegjistroKlientin)data.get(rowIndex);
        switch(columnIndex){
            
            case 0:
                return s.getEmri();
            case 1:
                return s.getMbiemri();
            case 2:
                return getDate(s.getDitelindja());  
          
            case 3:
                return s.getNrLeternjoftimit();
            case 4:
                return s.getAdresa();
            case 5:
                return s.getKontakti();
            case 6:
        {
            try {
                return returnTxt1(s.getGjiniaID(),"Gjinia");
            } catch (SQLException ex) {
                Logger.getLogger(RegjistroKlientinTableModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
           
            default:
                return null;
        }
    }
        
    }


 