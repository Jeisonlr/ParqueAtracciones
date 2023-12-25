package PruebaTecnica.RetoSofka.Controller;


        import PruebaTecnica.RetoSofka.Exception.ApiRequestException;
        import PruebaTecnica.RetoSofka.Modelo.Cliente;
        import PruebaTecnica.RetoSofka.Service.ClienteService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.*;

        import java.util.List;


@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/crearcliente")
    public ResponseEntity<String> crearCliente (@RequestBody Cliente cliente) throws ApiRequestException {
        clienteService.crearCliente(cliente);
        return new ResponseEntity<>("Tenemos Un Nuevo Cliente",HttpStatus.CREATED);

    }
}