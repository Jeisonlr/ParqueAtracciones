package PruebaTecnica.RetoSofka.Service;

import PruebaTecnica.RetoSofka.Exception.ApiRequestException;
import PruebaTecnica.RetoSofka.Modelo.Cliente;
import PruebaTecnica.RetoSofka.Repository.ClienteRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ClienteServiceTest {

    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ClienteServiceImp clienteServiceImp;

    @Test
    void CrearCliente() throws ApiRequestException {

        Cliente cliente = new Cliente(123,"Juan", "perez", "7788",
                "7176621","j@.com",1.66,32,"juana perez",true, Collections.emptyList());

        when(clienteRepository.save(any(Cliente.class))).thenReturn(cliente);

        Cliente resultado = clienteServiceImp.crearCliente(cliente);

        verify(clienteRepository, times(1)).save(any(Cliente.class));
        assertNotNull(resultado);
        assertEquals(123, resultado.getId());
        assertEquals("Juan", resultado.getNombre());
        assertEquals("perez", resultado.getApellido());
        assertEquals("7788", resultado.getCedula());
        assertEquals("7176621", resultado.getTelefono());
        assertEquals("j@.com", resultado.getCorreoElectronico());
        assertEquals(1.66, resultado.getEstatura());
        assertEquals(32, resultado.getEdad());
        assertEquals("juana perez", resultado.getInfoContactoFamiliar());
    }


    @Test
    void CrearClienteSinNombre() {
        Cliente clienteSinNombre = new Cliente();
        clienteSinNombre.setCedula("123456");
        clienteSinNombre.setTelefono("987654321");
        clienteSinNombre.setCorreoElectronico("cliente@gmail.com");
        clienteSinNombre.setEstatura(1.75);
        clienteSinNombre.setEdad(25);

        ApiRequestException exception = assertThrows(ApiRequestException.class, () -> clienteServiceImp.crearCliente(clienteSinNombre));

        assertNotNull(exception);

        assertTrue(true);

        if (exception.getMessage() != null) {
            assertTrue(exception.getMessage().contains("El Cliente Debe Tener Un Nombre"));
        }
        verify(clienteRepository, never()).save(any(Cliente.class));
    }

    @Test
    void CrearClienteSinApellido() {
        Cliente clienteSinApellido = new Cliente();
        clienteSinApellido .setNombre("Pedro Gaona");
        clienteSinApellido .setCedula("123456");
        clienteSinApellido .setTelefono("987654321");
        clienteSinApellido .setCorreoElectronico("cliente@gmail.com");
        clienteSinApellido .setEstatura(1.75);
        clienteSinApellido .setEdad(25);

        ApiRequestException exception = assertThrows(ApiRequestException.class, () -> clienteServiceImp.crearCliente(clienteSinApellido ));

        assertNotNull(exception);

        assertTrue(true);

        if (exception.getMessage() != null) {
            assertTrue(exception.getMessage().contains("El Cliente Debe Tener Un Apellido"));
        }
        verify(clienteRepository, never()).save(any(Cliente.class));
    }

    @Test
    void CrearClienteSinCedula() {
        Cliente clienteSinCedula = new Cliente();
        clienteSinCedula.setNombre("Pedro Gaona");
        clienteSinCedula.setTelefono("987654321");
        clienteSinCedula.setCorreoElectronico("cliente@gmail.com");
        clienteSinCedula.setEstatura(1.75);
        clienteSinCedula.setEdad(25);

        ApiRequestException exception = assertThrows(ApiRequestException.class, () -> clienteServiceImp.crearCliente(clienteSinCedula));

        assertNotNull(exception);

        assertTrue(true);

        if (exception.getMessage() != null) {
            assertTrue(exception.getMessage().contains("El Cliente Debe Tener Una Cédula"));
        }
        verify(clienteRepository, never()).save(any(Cliente.class));
    }


    @Test
    void CrearClienteMenorDeEdad() {
        Cliente clienteMenorDeEdad = new Cliente();
        clienteMenorDeEdad.setNombre("Nombre");
        clienteMenorDeEdad.setApellido("Apellido");
        clienteMenorDeEdad.setCedula("123456");
        clienteMenorDeEdad.setTelefono("987654321");
        clienteMenorDeEdad.setCorreoElectronico("cliente@gmail.com");
        clienteMenorDeEdad.setEstatura(1.75);
        clienteMenorDeEdad.setEdad(16);

        ApiRequestException exception = assertThrows(ApiRequestException.class, () -> clienteServiceImp.crearCliente(clienteMenorDeEdad));

        assertNotNull(exception);

        assertTrue(true);

        if (exception.getMessage() != null) {
            assertTrue(exception.getMessage().contains("El Cliente Debe Tener Un Responsable si es menor de edad"));
        }
        verify(clienteRepository, never()).save(any(Cliente.class));
    }

}