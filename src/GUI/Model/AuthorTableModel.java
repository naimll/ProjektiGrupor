/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Model;

import BLL.Autori;
import static java.util.Collections.list;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Lenovo
 */
public class AuthorTableModel extends AbstractTableModel{
    List<Autori> lista;
    String[] cols = {"Id","Name"} ;
    
    public AuthorTableModel(){}
    
    public AuthorTableModel(List<Autori> lista){
        this.lista=lista ;
    }
    
    public void addList(List<Autori> lista){
        this.lista=lista;
    }
    
    @Override
    public String getColumnName(int col){
    return cols[col] ;
    }    
    
    @Override
    public int getRowCount() {
        return this.lista.size();
    }

    @Override
    public int getColumnCount() {
        return cols.length;
    }
    
    public void remove(int row){
    lista.remove(row);
    }
    
    public Autori getAutori(int index){
        return this.lista.get(index);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Autori a = lista.get(rowIndex);
        switch(columnIndex){
        
            case 0:
                return a.getAId();
            case 1:
                return a.getAEmri()+" "+a.getAMbiemri();
            default:
                return null;
            
            }
    }
    
}
