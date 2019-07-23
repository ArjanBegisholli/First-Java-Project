package DAL;





import BL.RegjistroVeturen;
import DAL.RegjistroPuntorinException;
import java.util.List;

public interface RegjistroVeturenInterface {
    
    void create(RegjistroVeturen regjistroVeturen) throws RegjistroPuntorinException;
    void edit (RegjistroVeturen regjistroVeturen) throws RegjistroPuntorinException;
    void remove(RegjistroVeturen regjistroVeturen) throws RegjistroPuntorinException;
    List<RegjistroVeturen> findAll();
    RegjistroVeturen findById(String regjistroVeturenID) throws RegjistroPuntorinException;
}
