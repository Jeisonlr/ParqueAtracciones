package PruebaTecnica.RetoSofka.Service;

import PruebaTecnica.RetoSofka.Exception.ApiRequestException;
import PruebaTecnica.RetoSofka.Modelo.Empleado;
import PruebaTecnica.RetoSofka.Repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService {

    @Autowired
    public EmpleadoRepository empleadoRepository;



    public List<Empleado> obtenerTodosEmpleados() {
        return empleadoRepository.findAll();
    }

    public Optional<Empleado> obtenerEmpleadoPorId(Integer id) {
        return empleadoRepository.findById(id);
    }

    public Empleado crearEmpleado(Empleado empleado) throws ApiRequestException {
        if (empleado.getNombre() == null) {
            throw new ApiRequestException("El Empleado Debe Tener Un Nombre");}
        return empleadoRepository.save(empleado);
    }

    public Empleado actualizarEmpleado(Integer id, Empleado empleado) {

        if (empleadoRepository.existsById(id)) {

            empleado.setId(id);
            return empleadoRepository.save(empleado);
        } else {
            return null;
        }
    }

    public void eliminarEmpleado(Integer id) {
        empleadoRepository.deleteById(id);
    }
}

