/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;


import java.sql.*;


/**
 *
 * @author 
 */
public class Lidhja {
    
   public Connection cn=null;
   public PreparedStatement st=null;
   public ResultSet rs=null;
    
    public Lidhja(){
    connect();
}
    
public void connect(){
    try{
    String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    Class.forName(driver);
    
    cn=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=RentaCar;user=sa;password=sa");
   
    
    }catch(Exception ex){
        
    }
}

}


