package PruebaTecnica.RetoSofka.Service;

import PruebaTecnica.RetoSofka.Exception.ApiRequestException;
import PruebaTecnica.RetoSofka.Modelo.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {
    List<Cliente> obtenerTodosClientes(Integer id);
    Optional<Cliente> obtenerClientePorId(Integer id);

    void eliminarCliente(Integer id);

    Cliente crearCliente(Cliente cliente) throws ApiRequestException;
}
