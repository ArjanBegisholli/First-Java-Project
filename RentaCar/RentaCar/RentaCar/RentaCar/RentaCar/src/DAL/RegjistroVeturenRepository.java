package DAL;
import BL.RegjistroVeturen;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

public class RegjistroVeturenRepository extends EntMngClass implements RegjistroVeturenInterface {
    
    public void create(RegjistroVeturen regjistroVeturen) throws RegjistroPuntorinException {
        try{
            em.getTransaction().begin();
            em.persist(regjistroVeturen);
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
    public void edit(RegjistroVeturen regjistroVeturen) throws RegjistroPuntorinException {
        try{
            em.getTransaction().begin();
            em.merge(regjistroVeturen);
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
     * @param regjistroVeturen
     * @throws RegjistroPuntorinException
     */
    @Override
    public void remove(RegjistroVeturen regjistroVeturen) throws RegjistroPuntorinException {
        try{
            em.getTransaction().begin();
            em.remove(regjistroVeturen);
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
    public List <RegjistroVeturen> findAll() {
        return em.createNamedQuery("RegjistroVeturen.findAll").getResultList();
    }
    @Override
    public RegjistroVeturen findById(String VeturaID) throws RegjistroPuntorinException {
        Query query = em.createQuery("SELECT p FROM RegjistroVeturen p WHERE p.VeturaID = :VeturaID");
        query.setParameter("VeturaID", VeturaID);
        try{
            return (RegjistroVeturen)query.getSingleResult();
        } catch (NoResultException nre) {
              throw new RegjistroPuntorinException("E dhëna nuk egziston!");
        }
    }

    
}

