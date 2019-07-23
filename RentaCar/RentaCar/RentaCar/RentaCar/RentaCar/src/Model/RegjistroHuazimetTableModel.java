package Model;

import BL.RegjistroHuazimet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import static DAL.MyMethods.returnTxt1;
import static DAL.MyMethods.returnTxt2;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class RegjistroHuazimetTableModel extends AbstractTableModel {
    
    private final String [] columnNames = {"Nr Personal","Emri","Mbiemri ","Llojivetures","Modeli","Ngjyra","RentDitor","DataHuazimit","DataKthimit","Cmimi"};
  
    private List <RegjistroHuazimet> data;
    
    public RegjistroHuazimetTableModel(List<RegjistroHuazimet>data){
        this.data = data;
    }

    public RegjistroHuazimetTableModel() {
   
    }
    public void add(List<RegjistroHuazimet>data){
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

    public RegjistroHuazimet getRegjistroHuazimet(int index){
        return data.get(index);
    }
     public String getDate (Date date){
        DateFormat da = new SimpleDateFormat("dd/MM/yyyy");
        return da.format(date);
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        RegjistroHuazimet s = (RegjistroHuazimet)data.get(rowIndex);
        switch(columnIndex){
            
            case 0:
                return  s.getNrPersonal(); 
            case 1: 
                return s.getEmriKlientit(); 
            case 2:
                return   s.getMbiemriKlientit();
            case 3: 
                return s.getLlojivetures(); 
            case 4: 
                return s.getModeli(); 
             case 5: 
                return s.getNgjyra(); 
              case 6: 
                return s.getRentnDit();   
            case 7:
                return getDate(s.getDataHuazimit());  
            case 8: 
                return getDate(s.getDataKthimit()); 
            case 9:
                return s.getCmimi();
            default:
                return null;
        }
    }
        
    }


 