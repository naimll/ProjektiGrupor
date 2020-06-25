/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Autori;
import java.util.List;

/**
 *
<<<<<<< HEAD
 * @author Naim
 */
public interface AutoriInterface {
=======
 * @author Lenovo
 */
public interface AutoriInterface {
    
    
>>>>>>> 8e57ccc8a7f92cb6687fedc52c05f1590627144c
    void create(Autori a) throws LibraryException;
    void edit(Autori a) throws LibraryException;
    void delete(Autori a) throws LibraryException;
    Autori findById(Integer id) throws LibraryException;
    List<Autori> findAll() throws LibraryException;
<<<<<<< HEAD
=======

>>>>>>> 8e57ccc8a7f92cb6687fedc52c05f1590627144c
}
