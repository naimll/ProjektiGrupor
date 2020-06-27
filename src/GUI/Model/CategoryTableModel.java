/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Model;

import BLL.KategoriaLibrit;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Lenovo
 */
public class CategoryTableModel extends AbstractTableModel {
    List<KategoriaLibrit> list;
    String[] cols = {"Id","Emri","Sasia e librave"};
    
    public CategoryTableModel(){}
    
    public CategoryTableModel(List<KategoriaLibrit> list){
    this.list=list;
    }
    
    public void addList(List<KategoriaLibrit> list){
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
    
    public KategoriaLibrit getKategoriaLibrit(int index){
        return this.list.get(index);
    }    

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        KategoriaLibrit k = list.get(rowIndex);
        switch(columnIndex){
        
            case 0:
                return k.getKategoriaId();
            case 1:
                return k.getKLEmri();
            case 2:
                return k.getKLSasia();
            default:
                return null;
            
            }
    }
}
