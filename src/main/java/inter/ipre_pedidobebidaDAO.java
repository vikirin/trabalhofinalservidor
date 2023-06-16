package inter;

import model.pre_pedidobebida;

import java.util.List;
import java.util.Optional;

public interface ipre_pedidobebidaDAO {
    pre_pedidobebida create (pre_pedidobebida pre_pedidobebida);
    pre_pedidobebida update (pre_pedidobebida pre_pedidobebida);
    void delete (Long idpedido);
    List<pre_pedidobebida> findall();
    Optional<pre_pedidobebida> findbyID (Long idpedido);
}
