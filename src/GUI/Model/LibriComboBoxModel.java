/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Model;

import BLL.Libri;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author Alma
 */
public class LibriComboBoxModel  extends AbstractListModel<Libri> implements ComboBoxModel<Libri> {
    
    private List<Libri> data;
    private Libri selectedItem;
    
    public LibriComboBoxModel(){
    }
    
    public LibriComboBoxModel(List<Libri> data){
        this.data = data;
    }
    
    public void add(List<Libri> data){
        this.data = data ;
    }

    @Override
    public int getSize() {
        return data.size();
    }

    @Override
    public Libri getElementAt(int i) {
        return data.get(i);
    }

    @Override
    public void setSelectedItem(Object o) {
        this.selectedItem = (Libri) o ;
    }

    @Override
    public Object getSelectedItem() {
        return this.selectedItem;
    }
    
}

    


    
