package DAL;





import BL.RegjistroPuntorin;
import DAL.RegjistroPuntorinException;
import java.util.List;

public interface RegjistroPuntorinInterface {
    
    void create(RegjistroPuntorin regjistroPuntorin) throws RegjistroPuntorinException;
    void edit (RegjistroPuntorin regjistroPuntorin) throws RegjistroPuntorinException;
    void remove(RegjistroPuntorin regjistroPuntorin) throws RegjistroPuntorinException;
    List<RegjistroPuntorin> findAll();
    RegjistroPuntorin findById(String regjistroPuntorin) throws RegjistroPuntorinException;
}
