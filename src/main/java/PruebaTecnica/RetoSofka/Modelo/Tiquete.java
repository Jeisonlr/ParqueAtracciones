package PruebaTecnica.RetoSofka.Modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tiquetes")
public class Tiquete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String estacion;
    @Column
    private String diaSemana;
    @Column
    private String temporada;
    @Column
    private boolean habilitada;
    @Column
    private int porcentajeOcupacion;


  @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "empleado_id")
    private Empleado empleado;

    @ManyToOne
    @JoinColumn(name = "atraccion_id")
    private Atraccion atraccion;

}

