package PruebaTecnica.RetoSofka.Service;

import PruebaTecnica.RetoSofka.Exception.ApiRequestException;
import PruebaTecnica.RetoSofka.Modelo.Tiquete;
import PruebaTecnica.RetoSofka.Repository.TiqueteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TiqueteServiceImpl implements TiqueteService {

    @Autowired
    private TiqueteRepository tiqueteRepository;

    @Override
    public Tiquete crearTiquete(Tiquete tiquete) throws ApiRequestException {
        // Validar que el cliente asociado al tiquete existe
        if (tiquete.getCliente() == null || tiquete.getCliente().getId() == null) {
            throw new ApiRequestException("El tiquete debe tener un cliente válido");
        }

        // Validar que la atracción asociada al tiquete existe
        if (tiquete.getAtraccion() == null || tiquete.getAtraccion().getId() == null) {
            throw new ApiRequestException("El tiquete debe tener una atracción válida");
        }

        // Implementar más validaciones según sea necesario

        // Finalmente, guardar el tiquete en la base de datos
        return tiqueteRepository.save(tiquete);
    }


    @Override
    public List<Tiquete> obtenerTiquetesPorCliente(Long clienteId) {
        return tiqueteRepository.findAllByCliente_Id(clienteId);
    }

}
