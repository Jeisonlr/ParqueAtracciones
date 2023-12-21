package PruebaTecnica.RetoSofka.Controller;


        import PruebaTecnica.RetoSofka.Exception.ApiRequestException;
        import PruebaTecnica.RetoSofka.Modelo.Cliente;
        import PruebaTecnica.RetoSofka.Service.ClienteService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/crearcliente")
    public Cliente crear (@RequestBody Cliente cliente) throws ApiRequestException {

        return this.clienteService.crearCliente(cliente);
    }

    @GetMapping("/{id}")
    public Iterable<Cliente> obtenerTodosClientes(@PathVariable("id") Integer id) {

        return this.clienteService.obtenerTodosClientes(id);
    }

    @DeleteMapping("/{id}")
    public void eliminarCliente(@PathVariable Long id) {
        clienteService.eliminarCliente(id);
    }
}