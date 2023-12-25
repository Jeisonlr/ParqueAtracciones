package PruebaTecnica.RetoSofka.Controller;


import PruebaTecnica.RetoSofka.Exception.ApiRequestException;
import PruebaTecnica.RetoSofka.Modelo.Atraccion;
import PruebaTecnica.RetoSofka.Service.AtraccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/atracciones")
public class AtraccionController {

    @Autowired
    private AtraccionService atraccionService;

    @PostMapping("/crear")
    public ResponseEntity<String> crearAtraccion(@RequestBody Atraccion atraccion) {
        try {
            atraccionService.crearAtraccion(atraccion);
            return new ResponseEntity<>("Atracción creada exitosamente", HttpStatus.CREATED);
        } catch (ApiRequestException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/todas")
    public List<Atraccion> obtenerTodasAtracciones() {
        return atraccionService.obtenerTodasAtracciones();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Atraccion> obtenerAtraccionPorId(@PathVariable Integer id) {
        try {
            Atraccion atraccion = atraccionService.obtenerAtraccionPorId(id);
            return new ResponseEntity<>(atraccion, HttpStatus.OK);
        } catch (ApiRequestException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
