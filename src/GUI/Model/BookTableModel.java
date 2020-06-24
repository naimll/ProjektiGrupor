/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Model;

import BLL.Libri;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Lenovo
 */
public class BookTableModel extends AbstractTableModel{
    
    List<Libri> list;
    String [] cols = {"Book Name" , "Author"} ;
    
    public BookTableModel(){}
    
    public BookTableModel(List<Libri> list){
        this.list=list;
    }
    
    public void addList(List<Libri> list){
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
    
    public Libri getLibri(int index){
    return list.get(index);
    
    }

    @Override
    public int getColumnCount() {
        return cols.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Libri l = list.get(rowIndex);
        switch(columnIndex){
        
            case 0:
                return l.getLTitulli();
            case 1:
                return l.getAutoriCollection();
            default:
                return null;
            
            }
    }
    
}
