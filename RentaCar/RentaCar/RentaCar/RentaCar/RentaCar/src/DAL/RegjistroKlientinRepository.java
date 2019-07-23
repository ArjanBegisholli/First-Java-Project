package DAL;
import BL.RegjistroKlientin;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

public class RegjistroKlientinRepository extends EntMngClass implements RegjistroKlientinInterface {
    
    public void create(RegjistroKlientin regjistroKlientin) throws RegjistroPuntorinException {
        try{
            em.getTransaction().begin();
            em.persist(regjistroKlientin);
            em.getTransaction().commit();
        }
        catch(Throwable thro){
            
            if(thro.getMessage().contains("2627")){
            
                    throw new RegjistroPuntorinException("E dhëna egziston !");
            }
        else{
                throw new RegjistroPuntorinException("Create : "+thro.getClass()+" - "+thro.getMessage());
                }
    }
}
    public void edit(RegjistroKlientin regjistroKlientin) throws RegjistroPuntorinException {
        try{
            em.getTransaction().begin();
            em.merge(regjistroKlientin);
            em.getTransaction().commit();
        }
        catch(Throwable thro){
            if(thro.getMessage().contains("2627")){
                    throw new RegjistroPuntorinException("E dhëna egziston");
            }
            else{
                throw new RegjistroPuntorinException("Update: "+thro.getClass()+" - "+thro.getMessage());
            }
                
        }
    }

    /**
     *
     * @param regjistroKlientin
     * @throws RegjistroPuntorinException
     */
   
    public void remove(RegjistroKlientin regjistroKlientin) throws RegjistroPuntorinException {
        try{
            em.getTransaction().begin();
            em.remove(regjistroKlientin);
            em.getTransaction().commit();
        }catch(Throwable thro){
            if(thro.getMessage().contains("547")){
                throw new RegjistroPuntorinException("E dhëna është përdorur, nuk mund ta fshini!!");
            }
            else{
                 throw new RegjistroPuntorinException("Remove: "+thro.getClass()+" - "+thro.getMessage());
            }
        }
    }

    /**
     *
     * @return
     */
    @Override
    public List <RegjistroKlientin> findAll() {
        return em.createNamedQuery("RegjistroKlientin.findAll").getResultList();
    }
    @Override
    public RegjistroKlientin findById(String PuntoriID) throws RegjistroPuntorinException {
        Query query = em.createQuery("SELECT p FROM RegjistroKlientin p WHERE p.PuntoriID = :PuntoriID");
        query.setParameter("PuntoriID", PuntoriID);
        try{
            return (RegjistroKlientin)query.getSingleResult();
        } catch (NoResultException nre) {
              throw new RegjistroPuntorinException("E dhëna nuk egziston!");
        }
    }

    
}

