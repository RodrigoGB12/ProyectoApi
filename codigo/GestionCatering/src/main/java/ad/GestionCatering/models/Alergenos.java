package ad.GestionCatering.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "alergenos")
public class Alergenos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100, nullable = false)
    private String nombre;
    private String descripcion;
    @OneToMany(mappedBy = "alergeno", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ArticulosMenuAlergenos> articulosMenuAlergenos;

    public Alergenos() {
    }

    public Long getId() {
        return id;
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

    public List<ArticulosMenuAlergenos> getArticulosMenuAlergenos() {
        return articulosMenuAlergenos;
    }

    public void setArticulosMenuAlergenos(List<ArticulosMenuAlergenos> articulosMenuAlergenos) {
        this.articulosMenuAlergenos = articulosMenuAlergenos;
    }
}
