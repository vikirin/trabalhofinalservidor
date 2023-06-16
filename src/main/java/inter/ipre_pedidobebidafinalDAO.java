package inter;

import model.pre_pedidobebidafinal;

import java.util.List;
import java.util.Optional;

public interface ipre_pedidobebidafinalDAO {
    pre_pedidobebidafinal create (pre_pedidobebidafinal pre_pedidobebidafinal);
    pre_pedidobebidafinal update (pre_pedidobebidafinal pre_pedidobebidafinal);
    void delete (Long idpedido);
    List<pre_pedidobebidafinal> findall();
    Optional<pre_pedidobebidafinal> findbyID (Long idpedido);
}
