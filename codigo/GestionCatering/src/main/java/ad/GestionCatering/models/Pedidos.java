package ad.GestionCatering.models;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "pedidos")
public class Pedidos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long cliente_id;
    private Date fecha_pedido;
    private String estado;
    private Double monto_total;
    private Long personal_id;
}
