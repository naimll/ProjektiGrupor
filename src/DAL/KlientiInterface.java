/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Klienti;
import java.util.List;

/**
 *
 * @author Naim
 */
public interface KlientiInterface {
    void create(Klienti k) throws LibraryException;
    void edit(Klienti k) throws LibraryException;
    void delete(Klienti k) throws LibraryException;
    Klienti findById(Integer id) throws LibraryException;
    List<Klienti> findAll() throws LibraryException;
}
