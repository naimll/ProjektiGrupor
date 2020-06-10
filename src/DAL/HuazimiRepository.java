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
import BLL.HuazimiLibrit;
import BLL.Libri;
import java.util.List;
public class HuazimiRepository extends EntMngClass implements HuazimiInterface{

    @Override
    public void create(HuazimiLibrit k) throws LibraryException {
         try{
            em.getTransaction().begin();
            em.persist(k);
            em.getTransaction().commit();
            
        }catch(Exception e){
            throw new LibraryException(e.getMessage());
        }
    }

    @Override
    public void edit(HuazimiLibrit k) throws LibraryException {
        try{
        em.getTransaction().begin();
        em.merge(k);
        em.getTransaction().commit();
        }catch(Exception e){
        throw new LibraryException(e.getMessage());
        }
    }

    @Override
    public void delete(HuazimiLibrit k) throws LibraryException {
         try{
        em.getTransaction().begin();
        em.remove(k);
        em.getTransaction().commit();
         
        }catch(Exception e){
        throw new LibraryException(e.getMessage());
        }
    }

    @Override
    public HuazimiLibrit findById(Integer id) throws LibraryException {
        try {
            HuazimiLibrit l=new HuazimiLibrit();
            l.setHLId(id);
          return  (HuazimiLibrit) em.createQuery("SELECT hl FROM Huazimi_Librit hl WHERE hl.HL_Id= "+id).getSingleResult();
             
        } catch (Exception e) {
            throw new LibraryException(e.getMessage());
        }
    }

    @Override
    public List<HuazimiLibrit> findAll() throws LibraryException {
         try{
            return em.createNamedQuery("HuazimiLibrit.findAll").getResultList();
        }catch(Exception e){
            throw new LibraryException(e.getMessage());
        }
    }
    
}
