package ad.GestionCatering.models;

import jakarta.persistence.*;

@Entity
@Table(name = "personal")
public class Personal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100)
    private String nombre;
    private Rol rol;
    @Column(length = 100)
    private String correo_electronico;
    @Column(length = 15)
    private String telefono;
    @Column(length = 20)
    private String dni;

}
