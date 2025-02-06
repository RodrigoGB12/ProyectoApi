package ad.GestionCatering.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "articulos_menu")
public class ArticulosMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100, nullable = false)
    private String nombre;
    private String descripcion;
    @Column(nullable = false)
    private Double precio;

    private String imagen;

    @OneToMany(mappedBy = "articuloMenu", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ArticulosMenuAlergenos> articulosMenuAlergenos;


    public ArticulosMenu() {
    }

    public Long getId() {
        return id;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public List<ArticulosMenuAlergenos> getArticulosMenuAlergenos() {
        return articulosMenuAlergenos;
    }

    public void setArticulosMenuAlergenos(List<ArticulosMenuAlergenos> articulosMenuAlergenos) {
        this.articulosMenuAlergenos = articulosMenuAlergenos;
    }
}
