package inter;

import model.bebida;

import java.util.List;
import java.util.Optional;

public interface ibebidaDAO {
    bebida create (bebida bebida);
    bebida update (bebida bebida);
    void delete (Long idBebida);
    List<bebida> findall();
    Optional<bebida> findbyID (Long idBebida);
}
