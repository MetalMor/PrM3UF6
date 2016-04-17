package beans;

import beans.Personaje;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import util.Utils;

/**
 * Entidad de persistencia que define las propiedades de un arma que pueden 
 * usar los personajes.
 *
 * @author mor
 * @version 130416
 */

@Entity
@Access(AccessType.PROPERTY)
@Table(name = "ARMA", schema = "FIGHTCLUB")
public class Arma implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    
    private List<Personaje> personajes = new ArrayList<>();
    private String nombre;
    private int atk;
    private int def;
//    private Image imagen;

    public Arma(String nombre, int atk, int def) {
        this.nombre = nombre;
        this.atk = atk;
        this.def = def;
//        this.imagen = imagen;
    }

    public Arma() {
        //setId(Utils.generarId());
    }

    public boolean checkNull() {
        return Utils.isNull(this);
    }
    
    @Column(name="ARMA_NOMBRE")
    public String getNombre() {
        return nombre;
    }

    @Column(name="ARMA_ATK")
    public int getAtk() {
        return atk;
    }

    @Column(name="ARMA_DEF")
    public int getDef() {
        return def;
    }

    @OneToMany(cascade=CascadeType.PERSIST, mappedBy="arma")
    public List<Personaje> getPersonajes() {
        return personajes;
    }
    
    /*@Column(name="ARMA_IMAGEN")
    public Image getImagen() {
        return imagen;
    }*/

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public void setDef(int def) {
        this.def = def;
    }

//    public void setImagen(Image imagen) {
//        this.imagen = imagen;
//    }

    public void setPersonajes(List<Personaje> personajes) {
        this.personajes = personajes;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ARMA_ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (object instanceof Arma) {
            Arma other = (Arma) object;
            return !((Utils.isNull(this.id) && !Utils.isNull(other.id)) || (!Utils.isNull(this.id) && !this.id.equals(other.id)));
        }
        return false;
    }

    @Override
    public String toString() {
        return "beans.Arma[ id=" + id + " ]";
    }
    
}
