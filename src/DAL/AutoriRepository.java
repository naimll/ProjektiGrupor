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
 * @author Naim
 */
public class AutoriRepository extends EntMngClass implements AutoriInterface{

    @Override
    public void create(Autori a) throws LibraryException {
        try{
            em.getTransaction().begin();
            em.persist(a);
            em.getTransaction().commit();
            
        }catch(Exception e){
            throw new LibraryException(e.getMessage());
        }    
    }

    @Override
    public void edit(Autori a) throws LibraryException {
        try{

        em.getTransaction().begin();
        em.merge(a);
        em.getTransaction().commit();
        }catch(Exception e){
        throw new LibraryException(e.getMessage());

        } 
    }

    @Override
    public void delete(Autori a) throws LibraryException {
         try{
        em.getTransaction().begin();
        em.remove(a);
        em.getTransaction().commit();

        }catch(Exception e){
        throw new LibraryException(e.getMessage());
        }  
    }

    @Override
    public Autori findById(Integer id) throws LibraryException {
        try{
        Autori a = new Autori();
        a.setAId(id);
        return (Autori) em.createQuery("SELECT a FROM Autori a WHERE a.aId = :aId"+id).getSingleResult();
        }catch(Exception e){
            throw new LibraryException(e.getMessage());
        }
    }

    @Override
    public List<Autori> findAll() throws LibraryException {
         try{
            return em.createNamedQuery("Autori.findAll").getResultList();
        }catch(Exception e){
            throw new LibraryException(e.getMessage());
        }
    }
    
}
