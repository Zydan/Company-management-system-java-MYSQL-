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
public class Project implements mainData{
    private int ProjectNo;
    private String ProjectName;
    private String ProjectLocation;
    private int DeptNo;

    public int getProjectNo() {
        return ProjectNo;
    }

    public void setProjectNo(int ProjectNo) {
        this.ProjectNo = ProjectNo;
    }

    public String getProjectName() {
        return ProjectName;
    }

    public void setProjectName(String ProjectName) {
        this.ProjectName = ProjectName;
    }

    public String getProjectLocation() {
        return ProjectLocation;
    }

    public void setProjectLocation(String ProjectLocation) {
        this.ProjectLocation = ProjectLocation;
    }

    public int getDeptNo() {
        return DeptNo;
    }

    public void setDeptNo(int DeptNo) {
        this.DeptNo = DeptNo;
    }

    @Override
    public void Add() {
String Add = "insert into project values(" + ProjectNo + ",'" + ProjectName + "',"
        + "'" + ProjectLocation + "'," + DeptNo + ")" ;
boolean isAdded = db.go.RunNonQuery(Add);
if(isAdded){
Tools.mBox("Project is Added");
}
    }

    @Override
    public void Update() {
String Upadte = "update Project set " + "ProjectName='" + ProjectName + "',"
        + "ProjectLocation='" + ProjectLocation + "'," + "DeptNo=" + DeptNo + " where ProjectNo=" + ProjectNo;
boolean isUpdated = db.go.RunNonQuery(Upadte);
if(isUpdated){Tools.mBox("Project is Updated");}
    }

    @Override
    public void Delet() {
String delete = "delete from Project where ProjectNo=" + ProjectNo;
boolean isDeleted = db.go.RunNonQuery(delete);
if(isDeleted){Tools.mBox("Project is Deleted");}
    }

    @Override
    public void getAllRows(JTable table) {
db.go.FillTable("Project", table);
    }

    @Override
    public void getOnseRow(JTable table) {
String statement = "select * from project where ProjectNo=" + ProjectNo;
db.go.FillTable(statement, table);
    }

    @Override
    public String getAutoNumber() {
return db.go.getAutoNum("Project", "ProjectNo");
    }

    @Override
    public void getCustemRow(String statement, JTable table) {
db.go.FillTable(statement, table);
    }

    @Override
    public String getValuebyName(String Name) {
String str = "select ProjectNo from project where ProjectName='" + Name + "'";
String get = db.go.getDataTable(str).items[0][0].toString();
return get;
    }

    @Override
    public String getNamebyValue(String Value) {
String str = "select ProjectName from project where ProjectNo=" + Value;
String get = db.go.getDataTable(str).items[0][0].toString();
return get;
    }
}
