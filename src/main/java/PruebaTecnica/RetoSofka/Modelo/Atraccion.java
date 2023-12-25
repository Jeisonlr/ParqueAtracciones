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
@Table(name = "atracciones")
public class Atraccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String descripcion;
    @Column
    private String clasificacion;
    @Column
    private String condicionesUso;
    @Column
    private String estado;

   @OneToMany(mappedBy = "atraccion")
    private List<Tiquete> tiquetes;
}

