package DAL;





import BL.RegjistroHuazimet;
import DAL.RegjistroPuntorinException;
import java.util.List;

public interface RegjistroHuzimetInterface {
    
    void create(RegjistroHuazimet regjistroHuazimet) throws RegjistroPuntorinException;
    void edit (RegjistroHuazimet regjistroHuazimet) throws RegjistroPuntorinException;
    void remove(RegjistroHuazimet regjistroHuazimet) throws RegjistroPuntorinException;
    List<RegjistroHuazimet> findAll();
    RegjistroHuazimet findById(String regjistroHuazimet) throws RegjistroPuntorinException;
}
