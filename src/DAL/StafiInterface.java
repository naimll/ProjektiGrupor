/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;


import BLL.Stafi;
import java.util.List;

public interface StafiInterface {
     void create(Stafi k) throws LibraryException;
    void edit(Stafi k) throws LibraryException;
    void delete(Stafi k) throws LibraryException;
    Stafi findById(Integer id) throws LibraryException;
    List<Stafi> findAll() throws LibraryException;
    Stafi login(String u,String p) throws LibraryException;
}
