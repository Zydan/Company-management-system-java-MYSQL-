package compny;


import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Image;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP Probook
 */
public  class Tools {
    public  static void  mBox(String Massege){
     JOptionPane.showMessageDialog(null,Massege);
    }    
    public static Object InputBox(String Massege){
    Object obj = JOptionPane.showInputDialog(Massege);
    return obj;
    }
    public  static boolean Confirm(String Massege){
    int Data = JOptionPane.showConfirmDialog(null, Massege);
    if(Data == JOptionPane.YES_OPTION){
    return true;
    }else{
    
    return false;
    }
    
    }
    public static void OpenForm(JFrame form){
        
        Image image;
        try {
            image = ImageIO.read(Tools.class.getResource("Compny.png"));       
            form.setIconImage(image);
                            form.getContentPane().setBackground(Color.WHITE);
                                    form.setLocationRelativeTo(null);


            
                    form.setVisible(true);


        } catch (IOException ex) {
            Tools.mBox(ex.getMessage());
        }

        
        }
    public  class Table{
     public int Coloms;
         public Object [][] items ;

    public  Table(int Coloms){
    this.Coloms = Coloms;
    items = new Object[0][Coloms];
    }
    public  void addNewRow(Object row[]){
     Object Tempitems[][] = items;   
    items = new Object[items.length + 1][Coloms];
    for(int x =0;x<Tempitems.length;x++){
    items[x] = Tempitems[x];
    
    }
    items[items.length - 1] = row;
    
    }
    
    }
    public static void ClearText(Container c){
    for(Component com :c.getComponents()){
    if(com instanceof JTextField){
    JTextField F = (JTextField)com;
    F.setText("");
    }
    else if(com instanceof Container){
    
        ClearText((Container)com);
        
    }
            
    }
    
    }
    
    }

