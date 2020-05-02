/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.KthimiLibrit;
import java.util.List;

/**
 *
 * @author Naim
 */
public interface KthimiInterface {
 void create(KthimiLibrit k) throws LibraryException;
    void edit(KthimiLibrit k) throws LibraryException;
    void delete(KthimiLibrit k) throws LibraryException;
    KthimiLibrit findById(Integer id) throws LibraryException;
    List<KthimiLibrit> findAll() throws LibraryException;
}
