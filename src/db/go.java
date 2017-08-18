/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import com.mysql.jdbc.Connection;
import compny.Tools;
import compny.Tools.Table;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP Probook
 */
public class go {
    public static String url ="" ;
    public static Connection con;
    public static void setUrl(){
    url = "jdbc:mysql://localhost:3306/Compny";
    }
    public static void setConnection(){
    setUrl();
    try{
    con = (Connection)DriverManager.getConnection(url, "root","");
    }catch(SQLException ex){
    Tools.mBox(ex.getMessage());
    }
    
    
    }
    public static boolean LogIn(String UserName,String Password){
   try{
        setConnection();
    Statement stmt = con.createStatement();
    String chek = "select * from users Where UserName='"
            + UserName + "' and Pass='" + Password + "'"  ;
    stmt.executeQuery(chek);
    while(stmt.getResultSet().next()){
    con.close();
        return true;
    }
    con.close();
   }catch(SQLException ex){
   Tools.mBox(ex.getMessage());
   }
   return false;
    }
    public static boolean RunNonQuery(String statement){
    try{
    setConnection();
Statement stmt = con.createStatement();
stmt.execute(statement);

con.close();
return true;
}catch(SQLException ex){
        
    Tools.mBox(ex.getMessage());
    }
        return false ;

    }
    public static String getAutoNum(String Table, String Column){
    try{
      setConnection();
      Statement stmt = con.createStatement();
      String Str = "select max(" + Column + ")+1 as autonum" + " from " + Table ;
      stmt.executeQuery(Str);
      String Num = "";
       while(stmt.getResultSet().next()){
       Num = stmt.getResultSet().getString("autonum");
       }
       con.close();
       if(Num == null || "".equals(Num)){
       return "1";
       }else{
       return Num;
       }
            
               
    }catch(SQLException ex){
    Tools.mBox(ex.getMessage());
    }
    return "0";
    }           
  public static void FillCombo(String Colom , String Table ,JComboBox combo){
  try{ 
  setConnection();
  Statement stmt = con.createStatement();
  String Str = "select " + Colom + " from "  + Table;
  ResultSet rst = stmt.executeQuery(Str);
  rst.last();
  int c = rst.getRow();
  rst.beforeFirst();
  String data[] = new String[c];
  int i = 0;
 while(rst.next()){
 data[i] = rst.getString(1);
 i++;
  }
  con.close()
          ;
  combo.setModel(new DefaultComboBoxModel(data));
  }catch(SQLException ex){
  Tools.mBox(ex.getMessage());
  }
  
  }
 public static void FillTable(String TableNameOrStatement,JTable table){
 try{
 setConnection();
 Statement stmt = con.createStatement();
 String str;
 if("select ".equals(TableNameOrStatement.substring(0,7).toLowerCase())){
 str = TableNameOrStatement;
 
 }else{
 str = "select * from " + TableNameOrStatement;
 }
 ResultSet rs = stmt.executeQuery(str);
 ResultSetMetaData rsmd = rs.getMetaData();
 int c =  rsmd.getColumnCount();
 DefaultTableModel model = (DefaultTableModel)table.getModel();
 model.setRowCount(0);
 Vector row = new Vector();
 while(rs.next()){
 row = new Vector(c);
 for(int x = 1 ; x<= c ; x++){
 row.add(rs.getString(x));
 
 }
 if(table.getColumnCount() != c){
 Tools.mBox("The Count of table is not equals to the Count Table in The dataBases The Columns Count in The Databases is :" + c);
 }else{

 model.addRow(row);
 
 }
 }
       con.close();

 }catch(SQLException ex){
 Tools.mBox(ex.getMessage());
 }
 
 }
 public static Table getDataTable(String statement){
 Tools t = new Tools();
 try{
 setConnection();
 Statement stmt = con.createStatement();
 ResultSet rs = stmt.executeQuery(statement);
 ResultSetMetaData rsmd =rs.getMetaData();
 int c = rsmd.getColumnCount();
 Table table;
     table = t.new Table(c);
     while(rs.next()){
     Object row[] = new Object[c];
     for(int x = 0;x < c ;x++){
     row[x] = rs.getString(x + 1);
     }
     table.addNewRow(row);
     }
     con.close();
     return table;
 
 }catch(SQLException ex){
 Tools.mBox(ex.getMessage());

 }
  return t.new Table(0);

 }
    }

