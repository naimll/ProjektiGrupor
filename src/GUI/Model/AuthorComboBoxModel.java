/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Model;

import BLL.Autori;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author Lenovo
 */
public class AuthorComboBoxModel extends AbstractListModel<Autori> implements ComboBoxModel<Autori>{

    private List<Autori> data;
    private Autori selectedItem;
    
    public AuthorComboBoxModel(){
    }
    
    public AuthorComboBoxModel(List<Autori> data){
    this.data = data;
    }
    
    public void add(List<Autori> data){
        this.data = data ;
    }
    
    @Override
    public int getSize() {
        return data.size();
    }

    @Override
    public Autori getElementAt(int i) {
        return data.get(i);
    }

    @Override
    public void setSelectedItem(Object o) {
                this.selectedItem = (Autori) o ;

    }

    @Override
    public Object getSelectedItem() {
                return this.selectedItem;

    }
    
}
