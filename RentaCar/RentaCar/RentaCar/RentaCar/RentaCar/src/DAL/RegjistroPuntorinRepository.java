package DAL;
import BL.RegjistroPuntorin;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

public class RegjistroPuntorinRepository extends EntMngClass implements RegjistroPuntorinInterface {
    
    public void create(RegjistroPuntorin regjistroPuntorin) throws RegjistroPuntorinException {
        try{
            em.getTransaction().begin();
            em.persist(regjistroPuntorin);
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
    public void edit(RegjistroPuntorin regjistroPuntorin) throws RegjistroPuntorinException {
        try{
            em.getTransaction().begin();
            em.merge(regjistroPuntorin);
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
     * @param regjistroPuntorin
     * @throws RegjistroPuntorinException
     */
    @Override
    public void remove(RegjistroPuntorin regjistroPuntorin) throws RegjistroPuntorinException {
        try{
            em.getTransaction().begin();
            em.remove(regjistroPuntorin);
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
    public List <RegjistroPuntorin> findAll() {
        return em.createNamedQuery("RegjistroPuntorin.findAll").getResultList();
    }
    @Override
    public RegjistroPuntorin findById(String PuntoriID) throws RegjistroPuntorinException {
        Query query = em.createQuery("SELECT p FROM RegjistroPuntorin p WHERE p.PuntoriID = :PuntoriID");
        query.setParameter("PuntoriID", PuntoriID);
        try{
            return (RegjistroPuntorin)query.getSingleResult();
        } catch (NoResultException nre) {
              throw new RegjistroPuntorinException("E dhëna nuk egziston!");
        }
    }

    
}

