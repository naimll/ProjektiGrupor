/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Model;

import BLL.HuazimiLibrit;
import BLL.Libri;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Alma
 */
public class HuazimiLibritTableModel extends AbstractTableModel{
    
    List<HuazimiLibrit> list;
    String [] cols = {"HuazimiID" , "Klienti ID","Libri ID","Data e leshimit","Data e kthimit"};
    
    public HuazimiLibritTableModel(){}
    
    public HuazimiLibritTableModel(List<HuazimiLibrit> list){
        this.list=list;
    }
    
    public void addList(List<HuazimiLibrit> list){
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
    
    public HuazimiLibrit getHuazimiLibrit(int index){
    return list.get(index);
    
    }

    @Override
    public int getColumnCount() {
        return cols.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        HuazimiLibrit l = list.get(rowIndex);
        switch(columnIndex){
        
            case 0:
                return l.getHLId();
            case 1:
                return l.getHLKlientiId().getKId();
            case 2:
                return l.getHlIsbn().getIsbn();
            case 3:
                return l.getHLDataLeshimit();
            case 4:
                return l.getHLDataKthimit();
            default:
                return null;
            
            }
    }
    
}


