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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
    private String lema;
    private UsuarioRegular propietario;
    private List<Personaje> miembros = new ArrayList<>();
    
    public Equipo() {
        //setId(Utils.generarId());
    }
    
    public int calculaPotencial() {
        int sum = 0;
        for (Personaje miembro : getMiembros()) {
            sum += (miembro.getAtk()+miembro.getDef())/2;
        }
        return sum/getMiembros().size();
    }

    public boolean addMiembro(Personaje p) {
        return getMiembros().size() < 6 ? 
                getMiembros().add(p) :
                false;
    }
    
    public boolean checkNull() {
        return Utils.isNull(this);
    }

    @Column(nullable = false, name="EQUIPO_NOMBRE")
    public String getNombre() {
        return nombre;
    }
    
    @OneToMany(mappedBy="equipo")
    @JoinColumn(name="EQUIPO_MIEMBROS")
    public List<Personaje> getMiembros() {
        return miembros;
    }
    
    @ManyToOne
    @JoinColumn(name="EQUIPO_PROPIETARIO")
    public UsuarioRegular getPropietario() {
        return propietario;
    }

    @Column(nullable = false, name="EQUIPO_LEMA")
    public String getLema() {
        return lema;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setMiembros(List<Personaje> miembros) {
        this.miembros = miembros;
    }

    public void setPropietario(UsuarioRegular propietario) {
        this.propietario = propietario;
    }

    public void setLema(String lema) {
        this.lema = lema;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="EQUIPO_ID")
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
