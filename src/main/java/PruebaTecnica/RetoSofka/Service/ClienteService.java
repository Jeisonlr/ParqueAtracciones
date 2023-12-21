package PruebaTecnica.RetoSofka.Service;

import PruebaTecnica.RetoSofka.Exception.ApiRequestException;
import PruebaTecnica.RetoSofka.Modelo.Cliente;

import java.util.Optional;

public interface ClienteService {
    Iterable<Cliente> obtenerTodosClientes(Integer id);
    Optional<Cliente> obtenerClientePorId(Long id);
    Cliente guardarCliente(Cliente cliente);
    void eliminarCliente(Long id);

    Cliente crearCliente(Cliente cliente) throws ApiRequestException;
}
