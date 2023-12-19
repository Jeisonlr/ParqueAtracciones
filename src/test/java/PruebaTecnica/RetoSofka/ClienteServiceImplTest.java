package PruebaTecnica.RetoSofka;


import PruebaTecnica.RetoSofka.Modelo.Cliente;
import PruebaTecnica.RetoSofka.Repository.ClienteRepository;
import PruebaTecnica.RetoSofka.Service.ClienteServiceImp;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ClienteServiceImplTest {

    ClienteServiceImp clienteServiceImp;

    ClienteRepository clienteRepository;
    private Cliente cliente;

    @BeforeAll
    public void setUp() {
        cliente = new Cliente(1, "123", "manuel", "ospina", 28, "ZXC@GMAIL.COM", "Medellin", "7895623");
        clienteRepository = mock(ClienteRepository.class);
        when(clienteRepository.save(any(Cliente.class))).thenAnswer(invocation -> {
            Cliente clienteGuardado = invocation.getArgument(0);
            return clienteGuardado;
        });

        clienteServiceImp = new ClienteServiceImp(clienteRepository);
    }

    @Test
    public void crearCliente() throws ApiRequestException {

        Cliente clienteCreado = this.clienteServiceImp.crearCliente(cliente);

        assertNotNull(clienteCreado, "El cliente creado no debería ser nulo");

        assertEquals("123", clienteCreado.getCedula(), "Cédula incorrecta");
        assertEquals("manuel", clienteCreado.getNombre(), "Nombre incorrecto");
        assertEquals("ospina", clienteCreado.getApellido(), "Apellido incorrecto");
        assertEquals(28, clienteCreado.getEdad(), "Edad incorrecta");
    }


    @Test
    void crearClienteSinCedula() throws ApiRequestException {

        Cliente clienteGuardado = this.clienteServiceImp.crearCliente(cliente);
        cliente.setCedula(null);

        ApiRequestException excepcion = assertThrows(ApiRequestException.class,
                () -> clienteServiceImp.crearCliente(cliente));

    }

    @Test
    void crearClienteSinNombre() throws ApiRequestException {

        Cliente clienteGuardado = this.clienteServiceImp.crearCliente(cliente);
        cliente.setNombre(null);

        ApiRequestException excepcion = assertThrows(ApiRequestException.class,
                () -> clienteServiceImp.crearCliente(cliente));
    }

    @Test
    void crearClienteSinApellido() throws ApiRequestException {

        Cliente clienteGuardado = this.clienteServiceImp.crearCliente(cliente);
        cliente.setApellido(null);

        ApiRequestException excepcion = assertThrows(ApiRequestException.class,
                () -> clienteServiceImp.crearCliente(cliente));
    }

    @Test
    void crearClienteSinEdadCorrecta() throws ApiRequestException {

        Cliente clienteGuardado = this.clienteServiceImp.crearCliente(cliente);
        cliente.setEdad(14);

        ApiRequestException excepcion = assertThrows(ApiRequestException.class,
                () -> clienteServiceImp.crearCliente(cliente));
    }
    @Test
    void getAllClientes() {
        // Configuración del repositorio para devolver una lista de clientes
        when(clienteRepository.findAll()).thenReturn(List.of(cliente));

        // Llamada al método
        Iterable<Cliente> clientes = clienteServiceImp.getAllClientes();

        // Verificación de la lista de clientes
        assertNotNull(clientes);
        assertTrue(clientes.iterator().hasNext());
    }



    @Test
    void getClienteByIdNoExistente() {

        when(clienteRepository.findById(2)).thenReturn(Optional.empty());


        ApiRequestException excepcion = assertThrows(ApiRequestException.class,
                () -> clienteServiceImp.getClienteById(2));
    }


    @Test
    void updateClienteNoExistente() {
        when(clienteRepository.findById(2)).thenReturn(Optional.empty());
        Cliente clienteModificado = clienteServiceImp.updateCliente(2, new Cliente());
        assertNull(clienteModificado);
    }

    @Test
    void deleteCliente() {
        clienteServiceImp.eliminarCliente(1);
        verify(clienteRepository, times(1)).deleteById(1);
    }

}
