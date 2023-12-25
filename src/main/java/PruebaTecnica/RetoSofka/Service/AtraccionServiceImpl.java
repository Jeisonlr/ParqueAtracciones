package PruebaTecnica.RetoSofka.Service;


import PruebaTecnica.RetoSofka.Exception.ApiRequestException;
import PruebaTecnica.RetoSofka.Modelo.Atraccion;
import PruebaTecnica.RetoSofka.Repository.AtraccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AtraccionServiceImpl implements AtraccionService {

    @Autowired
    private AtraccionRepository atraccionRepository;

    @Override
    public Atraccion crearAtraccion(Atraccion atraccion) throws ApiRequestException {
        // Puedes agregar lógica de validación antes de guardar la atracción en la base de datos
        return atraccionRepository.save(atraccion);
    }

    @Override
    public List<Atraccion> obtenerTodasAtracciones() {
        return atraccionRepository.findAll();
    }

    @Override
    public Atraccion obtenerAtraccionPorId(Integer id) throws ApiRequestException {
        Optional<Atraccion> atraccionOptional = atraccionRepository.findById(id);
        return atraccionOptional.orElseThrow(() -> new ApiRequestException("Atracción no encontrada"));
    }

    // Puedes agregar más métodos según tus necesidades
}
