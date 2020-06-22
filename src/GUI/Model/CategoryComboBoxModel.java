/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Model;


import BLL.KategoriaLibrit;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author Lenovo
 */
public class CategoryComboBoxModel extends AbstractListModel<KategoriaLibrit> implements ComboBoxModel<KategoriaLibrit> {
    
    private List<KategoriaLibrit> data;
    private KategoriaLibrit selectedItem;
    
    public CategoryComboBoxModel(){
    }
    
    public CategoryComboBoxModel(List<KategoriaLibrit> data){
        this.data = data;
    }
    
    public void add(List<KategoriaLibrit> data){
        this.data = data ;
    }

    @Override
    public int getSize() {
        return data.size();
    }

    @Override
    public KategoriaLibrit getElementAt(int i) {
        return data.get(i);
    }

    @Override
    public void setSelectedItem(Object o) {
        this.selectedItem = (KategoriaLibrit) o ;
    }

    @Override
    public Object getSelectedItem() {
        return this.selectedItem;
    }
    
}
