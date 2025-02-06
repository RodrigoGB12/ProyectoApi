package ad.GestionCatering.models;

import jakarta.persistence.*;

@Entity
@Table(name = "articulos_pedido")
public class ArticulosPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedidos pedido;
    @ManyToOne
    @JoinColumn(name = "articulo_menu_id")
    private ArticulosMenu articuloMenu;
    @Column(nullable = false)
    private int cantidad;
    private Double precio;
    @ManyToOne
    @JoinColumn(name = "personal_id")
    private Personal personal;

    public ArticulosPedido() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pedidos getPedido() {
        return pedido;
    }

    public void setPedido(Pedidos pedido) {
        this.pedido = pedido;
    }

    public ArticulosMenu getArticuloMenu() {
        return articuloMenu;
    }

    public void setArticuloMenu(ArticulosMenu articuloMenu) {
        this.articuloMenu = articuloMenu;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }
}
