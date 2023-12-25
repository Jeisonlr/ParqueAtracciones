package PruebaTecnica.RetoSofka.Repository;

import PruebaTecnica.RetoSofka.Modelo.Atraccion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AtraccionRepository extends JpaRepository<Atraccion, Integer> {
    // Puedes agregar consultas personalizadas si es necesario
}
