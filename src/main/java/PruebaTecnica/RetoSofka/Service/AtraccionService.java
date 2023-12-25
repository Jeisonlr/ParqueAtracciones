package PruebaTecnica.RetoSofka.Service;

import PruebaTecnica.RetoSofka.Exception.ApiRequestException;
import PruebaTecnica.RetoSofka.Modelo.Atraccion;

import java.util.List;

public interface AtraccionService {
    Atraccion crearAtraccion(Atraccion atraccion) throws ApiRequestException;
    List<Atraccion> obtenerTodasAtracciones();
    Atraccion obtenerAtraccionPorId(Integer id) throws ApiRequestException;
    // Otros métodos según tus necesidades
}
