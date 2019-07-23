package DAL;
import BL.RegjistroHuazimet;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;


public class RegjistroHuazimetRepository extends EntMngClass implements RegjistroHuzimetInterface {
    
    public void create(RegjistroHuazimet regjistroHuazimet) throws RegjistroPuntorinException {
        try{
            em.getTransaction().begin();
            em.persist(regjistroHuazimet);
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
    public void edit(RegjistroHuazimet regjistroHuazimet) throws RegjistroPuntorinException {
        try{
            em.getTransaction().begin();
            em.merge(regjistroHuazimet);
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
     * @param regjistroHuazimet
     * @throws RegjistroPuntorinException
     */
    @Override
    public void remove(RegjistroHuazimet regjistroHuazimet) throws RegjistroPuntorinException {
        try{
            em.getTransaction().begin();
            em.remove(regjistroHuazimet);
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
    public List <RegjistroHuazimet> findAll() {
        return em.createNamedQuery("RegjistroHuazimet.findAll").getResultList();
    }
    @Override
    public RegjistroHuazimet findById(String HuazimetID) throws RegjistroPuntorinException {
        Query query = em.createQuery("SELECT p FROM RegjistroHuazimet p WHERE p.HuazimetID = :HuazimetID");
        query.setParameter("HuazimetID", HuazimetID);
        try{
            return (RegjistroHuazimet)query.getSingleResult();
        } catch (NoResultException nre) {
              throw new RegjistroPuntorinException("E dhëna nuk egziston!");
        }
    }

    
}

