package PruebaTecnica.RetoSofka.Service;

import PruebaTecnica.RetoSofka.Exception.ApiRequestException;
import PruebaTecnica.RetoSofka.Modelo.Cliente;
import PruebaTecnica.RetoSofka.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServiceImp implements ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteServiceImp(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }
    @Override
    public Iterable<Cliente> obtenerTodosClientes(Integer id) {

        return clienteRepository.findAll();
    }
    @Override
    public Optional<Cliente> obtenerClientePorId(Long id)
    {
        return Optional.empty();
    }
    @Override
    public Cliente guardarCliente(Cliente cliente) {
        return null;
    }

    @Override
    public void eliminarCliente(Long id) {

    }
    @Override
    public Cliente crearCliente(Cliente cliente) throws ApiRequestException {


        if (cliente.getNombre() == null) {
            throw new ApiRequestException("El Cliente Debe Tener Un Nombre");
        } else if (cliente.getApellido() == null) {
            throw new ApiRequestException("El Cliente Debe Tener Un Apellido");
        } else if (cliente.getCedula() == null) {
            throw new ApiRequestException("El Cliente Debe Tener Una Cédula");
        }if(cliente.getEdad() < 18 ) {
            throw new ApiRequestException("El Cliente Debe Tener Un Responsable si es menor de edad");
        } return clienteRepository.save(cliente);
    }
}