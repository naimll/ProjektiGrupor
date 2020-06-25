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
=======
 * @author Lenovo
>>>>>>> 8e57ccc8a7f92cb6687fedc52c05f1590627144c
 */
public class AutoriRepository extends EntMngClass implements AutoriInterface{

    @Override
    public void create(Autori a) throws LibraryException {
<<<<<<< HEAD
        try{
            em.getTransaction().begin();
            em.persist(a);
            em.getTransaction().commit();
            
        }catch(Exception e){
            throw new LibraryException(e.getMessage());
        }    
=======
            try{
            em.getTransaction().begin();
            em.persist(a);
            em.getTransaction().commit();
            }catch(Exception e){
            throw new LibraryException(e.getMessage());
        }
>>>>>>> 8e57ccc8a7f92cb6687fedc52c05f1590627144c
    }

    @Override
    public void edit(Autori a) throws LibraryException {
<<<<<<< HEAD
         try{
=======
        try{
>>>>>>> 8e57ccc8a7f92cb6687fedc52c05f1590627144c
        em.getTransaction().begin();
        em.merge(a);
        em.getTransaction().commit();
        }catch(Exception e){
        throw new LibraryException(e.getMessage());
<<<<<<< HEAD
        } 
=======
        }
>>>>>>> 8e57ccc8a7f92cb6687fedc52c05f1590627144c
    }

    @Override
    public void delete(Autori a) throws LibraryException {
<<<<<<< HEAD
        try{
        em.getTransaction().begin();
        em.remove(a);
        em.getTransaction().commit();
         
=======
         try{
        em.getTransaction().begin();
        em.remove(a);
        em.getTransaction().commit();
>>>>>>> 8e57ccc8a7f92cb6687fedc52c05f1590627144c
        }catch(Exception e){
        throw new LibraryException(e.getMessage());
        }    }

    @Override
    public Autori findById(Integer id) throws LibraryException {
<<<<<<< HEAD
try {
            Autori l=new Autori();
            l.setAId(id);
          return  (Autori) em.createQuery("SELECT a FROM Autori a WHERE a.A_Id= "+id).getSingleResult();
             
        } catch (Exception e) {
            throw new LibraryException(e.getMessage());
        }  
=======
        try{
        Autori a = new Autori();
        a.setAId(id);
        return (Autori) em.createQuery("SELECT a FROM Autori a WHERE a.aId = :aId"+id).getSingleResult();
        }catch(Exception e){
            throw new LibraryException(e.getMessage());
        }
>>>>>>> 8e57ccc8a7f92cb6687fedc52c05f1590627144c
    }

    @Override
    public List<Autori> findAll() throws LibraryException {
<<<<<<< HEAD
    try{
            return em.createNamedQuery("Autori.findAll").getResultList();
        }catch(Exception e){
            throw new LibraryException(e.getMessage());
        }    
    }
    
=======
          try{
            return em.createNamedQuery("Autori.findAll").getResultList();
        }catch(Exception e){
            throw new LibraryException(e.getMessage());
        }
    }
    
    
>>>>>>> 8e57ccc8a7f92cb6687fedc52c05f1590627144c
}
