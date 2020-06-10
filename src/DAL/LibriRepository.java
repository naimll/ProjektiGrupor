/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

/**
 *
 * @author Naim
 */
import BLL.KategoriaLibrit;
import BLL.Libri;
import java.util.List;

public class LibriRepository extends EntMngClass implements LibriInterface{

    @Override
    public void create(Libri l) throws LibraryException {
         try{
            em.getTransaction().begin();
            em.persist(l);
            em.getTransaction().commit();
            
        }catch(Exception e){
            throw new LibraryException(e.getMessage());
        }
    }

    @Override
    public void edit(Libri l) throws LibraryException {
        try{
        em.getTransaction().begin();
        em.merge(l);
        em.getTransaction().commit();
        }catch(Exception e){
        throw new LibraryException(e.getMessage());
        }
    }

    @Override
    public void delete(Libri l) throws LibraryException {
        try{
        em.getTransaction().begin();
        em.remove(l);
        em.getTransaction().commit();
       
        }catch(Exception e){
        throw new LibraryException(e.getMessage());
        }
    }

    @Override
    public Libri findById(String isbn) throws LibraryException {
        try {
            Libri l=new Libri();
            l.setIsbn(isbn);
            return  (Libri) em.createQuery("SELECT l FROM Libri l WHERE l.isbn="+isbn).getSingleResult();
        } catch (Exception e) {
            throw new LibraryException(e.getMessage());
        }
    }

    @Override
    public List<Libri> findAll() throws LibraryException {
        try{
            return em.createNamedQuery("Libri.findAll").getResultList();
        }catch(Exception e){
            throw new LibraryException(e.getMessage());
        }
    }
}
