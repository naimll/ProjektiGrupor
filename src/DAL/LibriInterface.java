/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Libri;
import java.util.List;

/**
 *
 * @author Naim
 */
public interface LibriInterface {
    
    void create(Libri l) throws LibraryException;
    void edit(Libri l) throws LibraryException;
    void delete(Libri l) throws LibraryException;
    Libri findById(String isbn) throws LibraryException;
    List <Libri> findAll() throws LibraryException;
}
