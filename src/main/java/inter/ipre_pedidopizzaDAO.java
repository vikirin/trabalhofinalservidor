package inter;

import model.pre_pedidopizza;

import java.util.List;
import java.util.Optional;

public interface ipre_pedidopizzaDAO {
    pre_pedidopizza create (pre_pedidopizza pre_pedidopizza);
    pre_pedidopizza update (pre_pedidopizza pre_pedidopizza);
    void delete (Long idPizza);
    List<pre_pedidopizza> findall();
    Optional<pre_pedidopizza> findbyID (Long idPizza);
}
