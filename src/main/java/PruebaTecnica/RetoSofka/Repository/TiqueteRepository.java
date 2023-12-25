package PruebaTecnica.RetoSofka.Repository;

import PruebaTecnica.RetoSofka.Modelo.Tiquete;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TiqueteRepository extends JpaRepository<Tiquete, Integer> {
    List<Tiquete> findAllByCliente_Id(Long clienteId);

}
