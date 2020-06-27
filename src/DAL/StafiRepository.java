/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Stafi;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Naim
 */
public class StafiRepository extends EntMngClass implements StafiInterface {

    @Override
    public void create(Stafi k) throws LibraryException {
        try {
            em.getTransaction().begin();
            em.persist(k);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new LibraryException(e.getMessage());
        }
    }

    @Override
    public void edit(Stafi k) throws LibraryException {
        try{
        em.getTransaction().begin();
        em.merge(k);
        em.getTransaction().commit();
        }catch(Exception e){
        throw new LibraryException(e.getMessage());
        }
    }

    @Override
    public void delete(Stafi k) throws LibraryException {
         try{
        em.getTransaction().begin();
        em.remove(k);
        em.getTransaction().commit();
        }catch(Exception e){
        throw new LibraryException(e.getMessage());
        }
    }

    @Override
    public Stafi findById(Integer id) throws LibraryException {
         try {
            Stafi sl=new Stafi();
            sl.setStafiId(id);
          return  (Stafi) em.createQuery("SELECT s FROM Stafi s WHERE s.stafiId= "+id).getSingleResult();
             
        } catch (Exception e) {
            throw new LibraryException(e.getMessage());
        }
    }

    @Override
    public List<Stafi> findAll() throws LibraryException {
        try{
            return em.createNamedQuery("Stafi.findAll").getResultList();
        }catch(Exception e){
            throw new LibraryException(e.getMessage());
        }
    }

    @Override
    public Stafi login(String u, String p) throws LibraryException {
       
        try {
            Query query = em.createQuery("SELECT p FROM Stafi p WHERE p.sUser = :us AND p.sPassword=:psw");
            query.setParameter("us", u);
            query.setParameter("psw", p);
            return (Stafi) query.getSingleResult();
        } catch (Exception e) {
            throw new LibraryException( e.getMessage());
        }
    }

    
    

}
