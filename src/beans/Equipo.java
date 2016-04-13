package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import util.Utils;

/**
 *
 * @author mor
 * @version 130416
 */
@Entity
public class Equipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

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

    public boolean isNull() {
        return Utils.isNull(this);
    }
    
    public List<Personaje> getMiembros() {
        return miembros;
    }

    public void setMiembros(List<Personaje> miembros) {
        this.miembros = miembros;
    }
    
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
        if (!(object instanceof Equipo)) {
            return false;
        }
        Equipo other = (Equipo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.Equipo[ id=" + id + " ]";
    }
    
}
