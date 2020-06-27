/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Model;

import BLL.Klienti;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Lenovo
 */
public class ClientTableModel extends AbstractTableModel{
    
    List<Klienti> list ;
    String[] cols ={"ID","Emri Mbiemri","Email"} ;
    
    public ClientTableModel(){}
    
    public ClientTableModel(List<Klienti> list){
        this.list=list;
    }
    
    public void addList(List<Klienti> list){
        this.list=list;
    }
    
    @Override
    public String getColumnName(int col){
    return cols[col] ;
    }    
    
    

    @Override
    public int getRowCount() {
        return this.list.size();
    }

    @Override
    public int getColumnCount() {
        return cols.length;
    }

    public void remove(int row){
    list.remove(row);
    }
    
    public Klienti getKlienti(int index){
        return this.list.get(index);
    }    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Klienti k = list.get(rowIndex);
        switch(columnIndex){
        
            case 0:
                return k.getKId();
            case 1:
                return k.getKEmri()+" "+k.getKMbiemri();
            case 2:
                return k.getKEmail();
            default:
                return null;
            
            }
    }    
    }
    

