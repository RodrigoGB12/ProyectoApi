package ad.GestionCatering.models;

import jakarta.persistence.*;

@Entity
@Table(name = "clientes")
public class Clientes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100)
    private String nombre;
    @Column(length = 100)
    private String correo_electronico;
    @Column(length = 15)
    private String telefono;
    private String direccion;
    @Column(length = 20)
    private String dni;
}
