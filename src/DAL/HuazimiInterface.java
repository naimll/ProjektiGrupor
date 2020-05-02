/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.HuazimiLibrit;
import java.util.List;

/**
 *
 * @author Naim
 */
public interface HuazimiInterface {
    void create(HuazimiLibrit k) throws LibraryException;
    void edit(HuazimiLibrit k) throws LibraryException;
    void delete(HuazimiLibrit k) throws LibraryException;
    HuazimiLibrit findById(Integer id) throws LibraryException;
    List<HuazimiLibrit> findAll() throws LibraryException;
}
