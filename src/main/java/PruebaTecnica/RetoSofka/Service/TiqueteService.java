package PruebaTecnica.RetoSofka.Service;

import PruebaTecnica.RetoSofka.Exception.ApiRequestException;
import PruebaTecnica.RetoSofka.Modelo.Tiquete;

import java.util.List;

public interface TiqueteService {
    Tiquete crearTiquete(Tiquete tiquete) throws ApiRequestException;
    List<Tiquete> obtenerTiquetesPorCliente(Long clienteId);

}
