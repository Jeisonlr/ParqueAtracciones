package PruebaTecnica.RetoSofka.Modelo;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "cliente")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "apellido", nullable = false)
    private String apellido;
    @Column(name = "cedula", nullable = false)
    private String cedula;
    @Column(name = "telefono", nullable = false)
    private String telefono;
    @Column(name = "correoElectronico", nullable = false)
    private String correoElectronico;
    @Column(name = "estatura;", nullable = false)
    private double estatura;
    @Column(name = "edad", nullable = false)
    private int edad;
    @Column(name = "infoContactoFamiliar")
    private String infoContactoFamiliar;
    @Column(name = "frecuente")
    private boolean frecuente;

  /*  @OneToMany(mappedBy = "cliente")
    private List<Tiquete> tiquetes;*/


}