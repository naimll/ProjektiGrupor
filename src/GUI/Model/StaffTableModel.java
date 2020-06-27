/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Model;

import BLL.Stafi;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Lenovo
 */
public class StaffTableModel extends AbstractTableModel{
    
    List<Stafi> list;
    String [] cols = {"Id", "Name Surname" , "Username"} ;
    
    public StaffTableModel(){}
    
    public StaffTableModel(List<Stafi> list){
        this.list=list;
    }
    
    public void addList(List<Stafi> list){
        this.list=list;
    }

    
    @Override
    public String getColumnName(int col){
    return cols[col] ;
    }
    
    @Override
    public int getRowCount() {
            return list.size();
            
    }
    
    public void remove(int row){
    list.remove(row);
    }
    
    public Stafi getStafi(int index){
    return list.get(index);
    
    }

    @Override
    public int getColumnCount() {
        return cols.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Stafi s = list.get(rowIndex);
        switch(columnIndex){
        
            case 0:
                return s.getStafiId();
            case 1:
                return s.getSEmri()+" "+s.getSMbiemri();
            case 2:
                return s.getSUser();
            default:
                return null;
            
            }
    }    
}
