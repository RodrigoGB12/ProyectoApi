package ad.GestionCatering.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "articulos_menu_alergenos")
public class ArticulosMenuAlergenos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "articulo_id")
    private ArticulosMenu articuloMenu;

    @ManyToOne
    @JoinColumn(name = "alergeno_id")
    @JsonIgnore
    private Alergenos alergeno;

    public ArticulosMenuAlergenos() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ArticulosMenu getArticuloMenu() {
        return articuloMenu;
    }

    public void setArticuloMenu(ArticulosMenu articuloMenu) {
        this.articuloMenu = articuloMenu;
    }

    public Alergenos getAlergeno() {
        return alergeno;
    }

    public void setAlergeno(Alergenos alergeno) {
        this.alergeno = alergeno;
    }
}
