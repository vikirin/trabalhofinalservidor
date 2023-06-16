package inter;

import model.pizza;

import java.util.List;
import java.util.Optional;

public interface ipizzaDAO {
    pizza create (pizza pizza);
    pizza update (pizza pizza);
    void delete (Long idPizza);
    List<pizza> findall();
    Optional<pizza> findbyID (Long idPizza);
}
