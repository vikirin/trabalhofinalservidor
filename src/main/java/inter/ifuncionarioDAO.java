package inter;
import model.funcionario;

import java.util.List;
import java.util.Optional;

public interface ifuncionarioDAO {
    funcionario create (funcionario funcionario);
    funcionario update (funcionario funcionario);
    void delete (Long idfuncionario);
    List<funcionario> findall();
    Optional<funcionario> findbyID (Long idfuncionario);
}
