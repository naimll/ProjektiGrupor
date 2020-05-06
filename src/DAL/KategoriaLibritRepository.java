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
import java.util.List;
public class KategoriaLibritRepository extends EntMngClass implements KategoriaInterface {

    @Override
    public void create(KategoriaLibrit k) throws LibraryException {
         try{
            em.getTransaction().begin();
            em.persist(k);
            em.getTransaction().commit();
        }catch(Exception e){
            throw new LibraryException(e.getMessage());
        }
    }

    @Override
    public void edit(KategoriaLibrit k) throws LibraryException {
        try{
        em.getTransaction().begin();
        em.merge(k);
        em.getTransaction().commit();
        }catch(Exception e){
        throw new LibraryException(e.getMessage());
        }
    }

    @Override
    public void delete(KategoriaLibrit k) throws LibraryException {
         try{
        em.getTransaction().begin();
        em.remove(k);
        em.getTransaction().commit();
        }catch(Exception e){
        throw new LibraryException(e.getMessage());
        }
    }

    @Override
    public KategoriaLibrit findById(Integer id) throws LibraryException {
        try {
            KategoriaLibrit kt=new KategoriaLibrit();
            kt.setKategoriaId(id);
          return  (KategoriaLibrit) em.createQuery("SELECT k FROM KategoriaLibrit k WHERE k.kategoriaId ="+id).getSingleResult();
             
        } catch (Exception e) {
            throw new LibraryException(e.getMessage());
        }
    }

    @Override
    public List<KategoriaLibrit> findAll() throws LibraryException {
          try{
            return em.createNamedQuery("KategoriaLibrit.findAll").getResultList();
        }catch(Exception e){
            throw new LibraryException(e.getMessage());
        }
    }
    
}
