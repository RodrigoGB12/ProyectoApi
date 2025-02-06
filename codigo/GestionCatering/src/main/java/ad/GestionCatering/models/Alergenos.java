package ad.GestionCatering.models;

import jakarta.persistence.*;

@Entity
@Table(name = "alergenos")
public class Alergenos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100)
    private String nombre;
    private String descripcion;
}
