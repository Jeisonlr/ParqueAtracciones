package PruebaTecnica.RetoSofka.Service;
import PruebaTecnica.RetoSofka.Exception.ApiRequestException;
import PruebaTecnica.RetoSofka.Modelo.Empleado;
import PruebaTecnica.RetoSofka.Repository.EmpleadoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmpleadoServiceTest {

    @Mock
    private EmpleadoRepository empleadoRepository;

    @InjectMocks
    private EmpleadoService empleadoService;

    @Test
    void testCrearEmpleado() throws ApiRequestException {

        Empleado empleado = new Empleado(123,"Juan", Empleado.TipoEmpleado.OPERADOR, "9:00 AM - 6:00 PM");

        when(empleadoRepository.save(any(Empleado.class))).thenReturn(empleado);

        Empleado resultado = empleadoService.crearEmpleado(empleado);

        verify(empleadoRepository, times(1)).save(any(Empleado.class));
        assertNotNull(resultado);
        assertEquals("Juan", resultado.getNombre());
        assertEquals(Empleado.TipoEmpleado.OPERADOR, resultado.getTipo());

    }


}