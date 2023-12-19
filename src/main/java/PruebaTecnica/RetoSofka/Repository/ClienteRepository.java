package PruebaTecnica.RetoSofka.Repository;


import PruebaTecnica.RetoSofka.Modelo.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente,Integer> {

    boolean existsByCedula(String cedula);
}

