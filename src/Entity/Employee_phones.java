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
public class Employee_phones implements mainData {
   private int EmpNo;
   private String phone;

    public int getEmpNo() {
        return EmpNo;
    }

    public void setEmpNo(int EmpNo) {
        this.EmpNo = EmpNo;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public void Add() {
        String Add = "insert into employee_phones values(" + EmpNo + ",'" + phone + "')";
    boolean isAdded = db.go.RunNonQuery(Add);
    if(isAdded){
    //Tools.mBox("Employee_phone is Added");
    }
    }
    

    @Override
    public void Update() {
Tools.mBox("Update is not Alowed becouse The phone & Employee Number is Primary Key");
    }

    @Override
    public void Delet() {
String delete  = "delete from employee_phones where EmpNo=" + EmpNo +" and " +  "phone='" + phone + "'";
boolean isDeleted = db.go.RunNonQuery(delete);
if(isDeleted){
Tools.mBox("Employee Phone is Deleted");
}
    }
    public void DeletWithEmp(){
    String DeletEmp = "delete from employee_phones where EmpNo=" + EmpNo;
    db.go.RunNonQuery(DeletEmp);
    }

    @Override
    public void getAllRows(JTable table) {
        String s = "select Phone from employee_phones where EmpNo=" + EmpNo;
db.go.FillTable(s, table);
    }

    @Override
    public void getOnseRow(JTable table) {
//String select = "select phone from employee_phones where EmpNo=" + EmpNo;
    }

    @Override
    public String getAutoNumber() {
Tools.mBox("You can get The Auto Number because its primary key");
return null;
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
    public String SearchPhone(String request){
String strSearch = "select EmpNo from employee_phones where Phone='"  + request + "'";
String str = db.go.getDataTable(strSearch).items[0][0].toString();
return str;
    }
}
