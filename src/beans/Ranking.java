package beans;

import java.io.Serializable;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import jpa.ServicioRanking;
import util.Utils;

/**
 * Entidad de persistencia del ránking de combates de cada personaje.
 *
 * @author mor
 * @version 130416
 */
@Entity
@Access(AccessType.PROPERTY)
@Table(name = "RANKING", schema = "FIGHTCLUB")
public class Ranking implements Serializable, Comparable {

    private static final long serialVersionUID = 1L;
    private Long id;
    
    private int victorias;
    private int empates;
    private int derrotas;
    private Personaje propietario;
    private long propId;
    
    private ServicioRanking sr;

    public Ranking() { 
        //setId(Utils.generarId());
    }

    public void addVictoria() {
        setVictorias(getVictorias()+1);
    }
    
    public void addDerrota() {
        setDerrotas(getDerrotas()+1);
    }
    
    public void addEmpate() {
        setEmpates(getEmpates()+1);
    }
    
    public boolean checkNull() {
        return Utils.isNull(this);
    }

    @OneToOne(mappedBy="ranking")
    @JoinColumn(name="RANKING_PROPIETARIO")
    public Personaje getPropietario() {
        return propietario;
    }

    public long getPropId() {
        return propId;
    }
    
    @Column(nullable = false, name="RANKING_VICTORIAS")
    public int getVictorias() {
        return victorias;
    }

    @Column(nullable = false, name="RANKING_EMPATES")
    public int getEmpates() {
        return empates;
    }

    @Column(nullable = false, name="RANKING_DERROTAS")
    public int getDerrotas() {
        return derrotas;
    }

    public void setPropietario(Personaje propietario) {
        this.propietario = propietario;
    }

    public void setPropId(long propId) {
        this.propId = propId;
    }

    public void setVictorias(int victorias) {
        this.victorias = victorias;
    }

    public void setEmpates(int empates) {
        this.empates = empates;
    }

    public void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
    }

    @Transient
    public ServicioRanking getSr() {
        return sr;
    }

    public void setSr(ServicioRanking sr) {
        this.sr = sr;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="RANKING_ID")
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
        if (object instanceof Ranking) {
            Ranking other = (Ranking) object;
            return !((Utils.isNull(this.getId()) && !Utils.isNull(other.getId())) || (!Utils.isNull(this.getId()) && !this.getId().equals(other.getId())));
        }
        return false;
    }

    @Override
    public String toString() {
        return "Victorias: "+victorias+", derrotas: "+derrotas+".";
    }
    
    @Override
    public int compareTo(Object o) {

        Ranking other = (Ranking) o;

        if (this.victorias > other.victorias) {
            return 1;
        } else if (this.victorias < other.victorias) {
            return -1;
        } else {
            if (this.empates > other.empates) {
                return 1;
            } else if (this.empates < other.empates) {
                return -1;
            } else {
                if (this.derrotas > other.derrotas) {
                    return 1;
                } else if (this.derrotas < other.derrotas) {
                    return -1;
                }
            }
        }
        return 0;
    }
    
}
