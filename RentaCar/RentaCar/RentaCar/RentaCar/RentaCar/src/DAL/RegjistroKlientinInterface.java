package DAL;





import BL.RegjistroKlientin;
import DAL.RegjistroPuntorinException;
import java.util.List;

public interface RegjistroKlientinInterface {
    
    void create(RegjistroKlientin RegjistroKlientin) throws RegjistroPuntorinException;
    void edit (RegjistroKlientin RegjistroKlientin) throws RegjistroPuntorinException;
    void remove(RegjistroKlientin RegjistroKlientin) throws RegjistroPuntorinException;
    List<RegjistroKlientin> findAll();
    RegjistroKlientin findById(String RegjistroKlientin) throws RegjistroPuntorinException;
}
