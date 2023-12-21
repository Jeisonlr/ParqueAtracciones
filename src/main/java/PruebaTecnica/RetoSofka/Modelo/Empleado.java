package PruebaTecnica.RetoSofka.Modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "empleados")
public class Empleado {


    public enum TipoEmpleado {
        ADMINISTRATIVO,
        LOGISTICA,
        PUBLICIDAD,
        OPERADOR,
        MANTENIMIENTO
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String nombre;

    @Enumerated(EnumType.STRING)
    private TipoEmpleado tipo;
    @Column
    private String horarioLaboral;

 /*  @OneToMany(mappedBy = "empleado")
    private List<Tiquete> tiquetes;
    */

}

