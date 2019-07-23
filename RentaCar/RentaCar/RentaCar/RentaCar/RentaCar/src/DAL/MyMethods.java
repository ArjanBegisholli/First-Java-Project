/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import GUI.RegjistroPuntorinForm;
import GUI.RegjistroVeturenForm;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 
 */
public class MyMethods {
    public static Lidhja l= new Lidhja();
    
     public static String returnTxt1(int input, String strn) throws SQLException{
            
                String s1=strn+"ID";
                    String lookFor="select * from "+strn.trim()+" where "+s1.trim()+" ="+input;
                   
                    try {
                        l.st=l.cn.prepareStatement(lookFor);
                        l.rs=l.st.executeQuery();
                    } catch (SQLException ex) {
                        Logger.getLogger(RegjistroVeturenForm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                     while (l.rs.next()){
                     return l.rs.getString(strn.trim());
                     }
                     return null;
    }
     
      public static int returnTxt2(String col, String serch) throws SQLException{
              String s1=col+"ID";
                     String lookFor2="select * from "+col.trim()+"  where "+col.trim()+"='"+serch.trim()+"'";
                   
                    try {
                        l.st=l.cn.prepareStatement(lookFor2);
                        l.rs=l.st.executeQuery();
                   
                    } catch (SQLException ex) {
                        Logger.getLogger(RegjistroPuntorinForm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                  while (l.rs.next()){
        return l.rs.getInt(s1.trim());
                  }
                  return 0;
    }
}
