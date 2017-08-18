/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import compny.Tools;
import javax.swing.JTable;

/**
 *
 * @author HP Probook
 */
public class Departement implements mainData{
 private int DeptNo;
 private String DeptName;
 private String DeptLocation;
 
    @Override
    public void Add() {
   String str = "insert into departement values(" + DeptNo + "," + "'" + DeptName + "'" + "," + "'" + DeptLocation + "')" ;
   boolean isAdded= db.go.RunNonQuery(str);
   if(isAdded){
   Tools.mBox("Departement is Added");
   }
    }

    @Override
    public void Update() {
       String str = "update departement set " + "DeptName='" + DeptName + "',"
               + "DeptLocation='" + DeptLocation + "'" + " where DeptNo=" + DeptNo; 
    boolean isUpdated = db.go.RunNonQuery(str);
    if(isUpdated){
    Tools.mBox("Departement is Updated");
    }
    }

    @Override
    public void Delet() {
        String delete = "delete from Departement where DeptNo=" + DeptNo ;
        boolean isDeleted = db.go.RunNonQuery(delete);
        if(isDeleted){Tools.mBox("Departement is Deleted");}
    }

    @Override
    public void getAllRows(JTable table) {
        db.go.FillTable("Departement", table);
    }

    @Override
    public void getOnseRow(JTable table) {
       String statement = "select * from departement where DeptNo=" + DeptNo;
       db.go.FillTable(statement, table);
    }

    @Override
    public String getAutoNumber() {
return db.go.getAutoNum("departement", "DeptNo");
    }

    @Override
    public void getCustemRow(String statement, JTable table) {
db.go.FillTable(statement, table);
    }

    @Override
    public String getValuebyName(String Name) {
String str = "select DeptNo from departement where DeptName='" + Name + "'";
     String StrVal = (String)db.go.getDataTable(str).items[0][0];
     return StrVal;
    }

    @Override
    public String getNamebyValue(String Value) {
String str = "select DeptName from departement where DeptNo=" + Value;
String StrName = (String)db.go.getDataTable(str).items[0][0];
return StrName;
    }

    public int getDeptNo() {
        return DeptNo;
    }

    public void setDeptNo(int DeptNo) {
        this.DeptNo = DeptNo;
    }

    public String getDeptName() {
        return DeptName;
    }

    public void setDeptName(String DeptName) {
        this.DeptName = DeptName;
    }

    public String getDeptLocation() {
        return DeptLocation;
    }

    public void setDeptLocation(String DeptLocation) {
        this.DeptLocation = DeptLocation;
    }
   
}
