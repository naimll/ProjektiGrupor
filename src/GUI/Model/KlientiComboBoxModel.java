/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Model;

import BLL.Klienti;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author Alma
 */
public class KlientiComboBoxModel extends AbstractListModel<Klienti> implements ComboBoxModel<Klienti> {
    
    private List<Klienti> data;
    private Klienti selectedItem;
    
    public KlientiComboBoxModel(){
    }
    
    public KlientiComboBoxModel(List<Klienti> data){
        this.data = data;
    }
    
    public void add(List<Klienti> data){
        this.data = data ;
    }

    @Override
    public int getSize() {
        return data.size();
    }

    @Override
    public Klienti getElementAt(int i) {
        return data.get(i);
    }

    @Override
    public void setSelectedItem(Object o) {
        this.selectedItem = (Klienti) o ;
    }

    @Override
    public Object getSelectedItem() {
        return this.selectedItem;
    }
    
}

    

