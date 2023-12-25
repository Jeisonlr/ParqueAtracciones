package PruebaTecnica.RetoSofka.Controller;


import PruebaTecnica.RetoSofka.Exception.ApiRequestException;
import PruebaTecnica.RetoSofka.Modelo.Tiquete;
import PruebaTecnica.RetoSofka.Service.TiqueteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tiquetes")
public class TiqueteController {

    @Autowired
    private TiqueteService tiqueteService;

    @PostMapping("/crear")
    public ResponseEntity<String> crearTiquete(@RequestBody Tiquete tiquete) {
        try {
            tiqueteService.crearTiquete(tiquete);
            return new ResponseEntity<>("Tiquete creado exitosamente", HttpStatus.CREATED);
        } catch (ApiRequestException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<Tiquete>> obtenerTiquetesPorCliente(@PathVariable Long clienteId) {
        List<Tiquete> tiquetes = tiqueteService.obtenerTiquetesPorCliente(clienteId);
        return new ResponseEntity<>(tiquetes, HttpStatus.OK);
    }


}
