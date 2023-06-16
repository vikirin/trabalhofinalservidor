package inter;

import model.pre_pedidopizzafinal;

import java.util.List;
import java.util.Optional;

public interface ipre_pedidopizzafinalDAO {
    pre_pedidopizzafinal create (pre_pedidopizzafinal pre_pedidopizzafinal);
    pre_pedidopizzafinal update (pre_pedidopizzafinal pre_pedidopizzafinal);
    void delete (Long idPizza);
    List<pre_pedidopizzafinal> findall();
    Optional<pre_pedidopizzafinal> findbyID (Long idPizza);
}
