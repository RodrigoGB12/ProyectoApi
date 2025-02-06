package ad.GestionCatering.models;

import jakarta.persistence.*;

@Entity
@Table(name = "articulos_menu")
public class ArticulosMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100)
    private String nombre;
    private String descripcion;
    private Double precio;
}
