package ad.GestionCatering.models;

import jakarta.persistence.*;

@Entity
@Table(name = "articulos_menu_alergenos")
public class ArticulosMenuAlergenos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long articulo_menu_id;
    private Long alergeno_id;

}
