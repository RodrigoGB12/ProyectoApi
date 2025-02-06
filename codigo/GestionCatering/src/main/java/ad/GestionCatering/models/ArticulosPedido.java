package ad.GestionCatering.models;

import jakarta.persistence.*;

@Entity
@Table(name = "articulos_pedido")
public class ArticulosPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long pedido_id;
    private Long articulo_menu_id;
    private int cantidad;
    private Double precio;
    private Long personal_id;
}
