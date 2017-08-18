/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import javax.swing.JTable;

/**
 *
 * @author HP Probook
 */
public interface mainData {
 public void Add();
 public void Update();
 public void Delet();
 public void getAllRows(JTable table);
 public void getOnseRow(JTable table);
 public String getAutoNumber();
 public void getCustemRow(String statement,JTable table);
 public String getValuebyName(String Name);
 public String getNamebyValue(String Value);
}
