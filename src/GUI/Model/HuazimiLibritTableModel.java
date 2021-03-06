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

    
    String [] cols = {"Client" , "Book Title","Author","Borrowed Date","Receipt Date","Active"};
    
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
        String active ;
        if(l.getIsActive() == 0){
            active = "No" ;
        }
        else{
            active = "Yes" ;
        }
        switch(columnIndex){
        
            case 0:
                return l.getHLKlientiId().getKEmri() +" " + l.getHLKlientiId().getKMbiemri() ;
            case 1:
                return l.getHlIsbn().getLTitulli();
            case 2:
                return l.getHlIsbn().getAutoriId().getAEmri() + " " +l.getHlIsbn().getAutoriId().getAMbiemri();
            case 3:
                return l.getHLDataLeshimit();
            case 4:
                return l.getHLDataLeshimit();
            case 5: 
                return active ;
            default:
                return null;
            
            }
    }
    
}


