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
import BLL.Klienti;
import java.util.List;
import java.sql.PreparedStatement;
import javax.persistence.Query;

public class KlientiRepository extends EntMngClass implements KlientiInterface{

    @Override
    public void create(Klienti k) throws LibraryException {
        try{
            em.getTransaction().begin();
            em.persist(k);
            em.getTransaction().commit();
        }catch(Exception e){
            throw new LibraryException(e.getMessage());
        }
    }

    @Override
    public void edit(Klienti k) throws LibraryException {
        try{
        em.getTransaction().begin();
        em.merge(k);
        em.getTransaction().commit();
        }catch(Exception e){
        throw new LibraryException(e.getMessage());
        }
    }

    @Override
    public void delete(Klienti k) throws LibraryException {
        try{
        em.getTransaction().begin();
        em.remove(k);
        em.getTransaction().commit();
        }catch(Exception e){
        throw new LibraryException(e.getMessage());
        }
    }

    @Override
    public Klienti findById(Integer id) throws LibraryException {
        try {
            Klienti kl=new Klienti();
            kl.setKId(id);
          return  (Klienti) em.createQuery("SELECT k FROM Klienti k WHERE k.K_Id= "+id).getSingleResult();
             
        } catch (Exception e) {
            throw new LibraryException(e.getMessage());
        }
    }

    @Override
    public List<Klienti> findAll() throws LibraryException {
        try{
            return em.createNamedQuery("Klienti.findAll").getResultList();
        }catch(Exception e){
            throw new LibraryException(e.getMessage());
        }
    }
    
}
