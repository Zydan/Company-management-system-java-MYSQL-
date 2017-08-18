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
public class WorkOn implements mainData{
    private int EmpNo;
    private int ProjectNo;
private String Employee_Name;
private String Project_Name;

    public int getEmpNo() {
        return EmpNo;
    }

    public void setEmpNo(int EmpNo) {
        this.EmpNo = EmpNo;
    }

    public int getProjectNo() {
        return ProjectNo;
    }

    public void setProjectNo(int ProjectNo) {
        this.ProjectNo = ProjectNo;
    }

    @Override
    public void Add() {
String Add = "insert into workon values(" + EmpNo + "," + ProjectNo + ")"; 
boolean isAdded = db.go.RunNonQuery(Add);
if(isAdded){Tools.mBox("WorkOn is Added");}
    }

    @Override
    public void Update() {
Tools.mBox("you cant update ");
    }

    @Override
    public void Delet() {
        String delete = "delete from workon where EmpNo=" + EmpNo + " and PRojectNo=" + ProjectNo;
        boolean isDeleted = db.go.RunNonQuery(delete);
        if(isDeleted){Tools.mBox("workon is Deleted");}
    }

    @Override
    public void getAllRows(JTable table) {
db.go.FillTable("workon_data", table);
    }

    @Override
    public void getOnseRow(JTable table) {
String s = "select * from workon_data where Employee_No=" + EmpNo + " and Project_No=" + ProjectNo;
db.go.FillTable(s, table);
    }

    @Override
    public String getAutoNumber() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getCustemRow(String statement, JTable table) {
db.go.FillTable(statement, table);
    }

    @Override
    public String getValuebyName(String Name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getNamebyValue(String Value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getEmployee_Name() {
        return Employee_Name;
    }

    public void setEmployee_Name(String Employee_Name) {
        this.Employee_Name = Employee_Name;
    }

    public String getProject_Name() {
        return Project_Name;
    }

    public void setProject_Name(String Project_Name) {
        this.Project_Name = Project_Name;
    }
}
