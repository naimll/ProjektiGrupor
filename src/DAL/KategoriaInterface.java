/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.KategoriaLibrit;
import java.util.List;

/**
 *
 * @author Naim
 */
public interface KategoriaInterface {
    void create(KategoriaLibrit k) throws LibraryException;
    void edit(KategoriaLibrit k) throws LibraryException;
    void delete(KategoriaLibrit k) throws LibraryException;
    KategoriaLibrit findById(Integer id) throws LibraryException;
    List<KategoriaLibrit> findAll() throws LibraryException;
}
