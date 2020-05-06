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
import BLL.KthimiLibrit;
import BLL.Libri;
import java.util.List;

public class KthimiRepository extends EntMngClass implements KthimiInterface{

    @Override
    public void create(KthimiLibrit k) throws LibraryException {
        try{
            em.getTransaction().begin();
            em.persist(k);
            em.getTransaction().commit();
             Libri l=(Libri) em.createNamedQuery("select l from Libri l join Huazimi_Librit hl on l.ISBN=hl.HL_ISBN where hl.HL_ISBN="+k.getKthLISBN()).getSingleResult();
            int sasia=l.getLSasia();
            sasia++;
            l.setLSasia(sasia);
            em.getTransaction().begin();
            em.merge(l);
            em.getTransaction().commit();
        }catch(Exception e){
            throw new LibraryException(e.getMessage());
        }
    }

    @Override
    public void edit(KthimiLibrit k) throws LibraryException {
        try{
        em.getTransaction().begin();
        em.merge(k);
        em.getTransaction().commit();
        }catch(Exception e){
        throw new LibraryException(e.getMessage());
        }
    }

    @Override
    public void delete(KthimiLibrit k) throws LibraryException {
        try{
        em.getTransaction().begin();
        em.remove(k);
        em.getTransaction().commit();
         Libri l=(Libri) em.createNamedQuery("select l from Libri l join Huazimi_Librit hl on l.ISBN=hl.HL_ISBN where hl.HL_ISBN="+k.getKthLISBN()).getSingleResult();
            int sasia=l.getLSasia();
            sasia--;
            l.setLSasia(sasia);
            em.getTransaction().begin();
            em.merge(l);
            em.getTransaction().commit();
        }catch(Exception e){
        throw new LibraryException(e.getMessage());
        }
    }

    @Override
    public KthimiLibrit findById(Integer id) throws LibraryException {
         try {
            KthimiLibrit l=new KthimiLibrit();
            l.setKthLId(id);
          return  (KthimiLibrit) em.createQuery("SELECT kl FROM Kthimi_Librit kl WHERE kl.KthL_Id= "+id).getSingleResult();
             
        } catch (Exception e) {
            throw new LibraryException(e.getMessage());
        }
        }

    @Override
    public List<KthimiLibrit> findAll() throws LibraryException {
        try{
            return em.createNamedQuery("KthimiLibrit.findAll").getResultList();
        }catch(Exception e){
            throw new LibraryException(e.getMessage());
        }
    }
    
}
