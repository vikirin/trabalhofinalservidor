package com.example.trabalhofinal.inter;
import com.example.trabalhofinal.model.cliente;

import java.util.List;
import java.util.Optional;

public interface iclienteDAO {
    cliente create (cliente cliente);
    cliente update (cliente cliente);
    void delete (Long idCliente);
    List<cliente> findall();
    Optional<cliente> findbyID (Long idCliente);
}
