package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import util.Utils;

/**
 * Entidad de persistencia de equipos de personajes.
 *
 * @author mor
 * @version 130416
 */
@Entity
@Access(AccessType.PROPERTY)
@Table(name = "EQUIPO", schema = "FIGHTCLUB")
public class Equipo implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    
    private String nombre;
    private Usuario propietario;
    private List<Personaje> miembros;
    
    public Equipo() {
        miembros = new ArrayList<>();
    }
    
    public int calculaPotencial() {
        int sum = 0;
        for (Personaje miembro : miembros) {
            sum += (miembro.getAtk()+miembro.getDef())/2;
        }
        return sum/miembros.size();
    }

    public boolean addMiembro(Personaje p) {
        return miembros.add(p);
    }
    
    public boolean checkNull() {
        return Utils.isNull(this);
    }

    @Column(name="EQUIPO_NOMBRE")
    public String getNombre() {
        return nombre;
    }
    
    @Column(name="EQUIPO_MIEMBROS")
    public List<Personaje> getMiembros() {
        return miembros;
    }
    
    @ManyToOne
    @Column(name="EQUIPO_PROPIETARIO")
    public Usuario getPropietario() {
        return propietario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setMiembros(List<Personaje> miembros) {
        this.miembros = miembros;
    }

    public void setPropietario(Usuario propietario) {
        this.propietario = propietario;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
        if (!(object instanceof Equipo)) {
            Equipo other = (Equipo) object;
            return !((Utils.isNull(this.getId()) && !Utils.isNull(other.getId())) || (!Utils.isNull(this.getId()) && !this.getId().equals(other.getId())));
        }
        return false;
    }

    @Override
    public String toString() {
        return getNombre();
    }
    
}
