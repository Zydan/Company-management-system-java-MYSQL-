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
public class Employee implements mainData {
   private int EmpNo;
   private String EmpName;
   private String EmpAddres;
   private double EmpSalary;
   private String HiringDate;
   private String BirthDate;
   private int DeptNo;

    public int getEmpNo() {
        return EmpNo;
    }

    public void setEmpNo(int EmpNo) {
        this.EmpNo = EmpNo;
    }

    public String getEmpName() {
        return EmpName;
    }

    public void setEmpName(String EmpName) {
        this.EmpName = EmpName;
    }

    public String getEmpAddres() {
        return EmpAddres;
    }

    public void setEmpAddres(String EmpAddres) {
        this.EmpAddres = EmpAddres;
    }

    public double getEmpSalary() {
        return EmpSalary;
    }

    public void setEmpSalary(double EmpSalary) {
        this.EmpSalary = EmpSalary;
    }

    public String getHiringDate() {
        return HiringDate;
    }

    public void setHiringDate(String HiringDate) {
        this.HiringDate = HiringDate;
    }

    public String getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(String BirthDate) {
        this.BirthDate = BirthDate;
    }

    public int getDeptNo() {
        return DeptNo;
    }

    public void setDeptNo(int DeptNo) {
        this.DeptNo = DeptNo;
    }

    @Override
    public void Add() {
String strAdd = "insert into employee values("+ EmpNo
         + "," + "'" + EmpName + "'," + "'" + EmpAddres + "'," 
         + EmpSalary + ",'" + HiringDate + "'," + "'" + BirthDate + "'," 
        + DeptNo + ")";
        boolean isAdded = db.go.RunNonQuery(strAdd);
        if(isAdded){Tools.mBox("Employee is added");}
    }

    @Override
    public void Update() {
String strUpdate = "update employee set " 
     + "EmpName='" + EmpName + "'," + "EmpAddres='" + EmpAddres + "',"
       + "EmpSalary=" + EmpSalary + "," + "HiringDate='" + HiringDate + "',"
         + "BirthDate='" + BirthDate + "'," + "DeptNo=" + DeptNo + " where EmpNo=" + EmpNo ;
boolean isUpdated = db.go.RunNonQuery(strUpdate);
if(isUpdated){Tools.mBox("Employee is Updated");}
    }

    @Override
    public void Delet() {
String strDelete= "delete from employee where EmpNo= " + EmpNo;
boolean isDeleted = db.go.RunNonQuery(strDelete);
if(isDeleted){Tools.mBox("Employee is Deleted");}
    }

    @Override
    public void getAllRows(JTable table) {
db.go.FillTable("employee", table);
    }

    @Override
    public void getOnseRow(JTable table) {
String select = "select * from employee where EmpNo=" + EmpNo;
db.go.FillTable(select, table);
    }

    @Override
    public String getAutoNumber() {
return db.go.getAutoNum("Employee", "EmpNo");
    }

    @Override
    public void getCustemRow(String statement, JTable table) {
db.go.FillTable(statement, table);
    }

    @Override
    public String getValuebyName(String Name) {
String str = "select EmpNo from employee where EmpName='" + Name + "'";
 String s = db.go.getDataTable(str).items[0][0].toString();
 return s;
    }

    @Override
    public String getNamebyValue(String Value) {
String str = "select EmpName from employee where EmpNo=" + Value;
String s = db.go.getDataTable(str).items[0][0].toString();
return s;
    }
}
