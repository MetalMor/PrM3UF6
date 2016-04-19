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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import jpa.ServicioRanking;
import props.Habilidad;
import props.Medio;
import props.Raza;
import util.Utils;

/**
 * Entidad de persistencia de los personajes de cada usuario.
 *
 * @author mor
 * @version 130416
 */
@Entity
@Access(AccessType.PROPERTY)
@Table(name = "PERSONAJE", schema = "FIGHTCLUB")
public class Personaje implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    
    private UsuarioRegular propietario;
    private String nombre;
    private int atk;
    private int def;
    private Arma arma;
    private Raza raza;
    private Medio medio;
    private Habilidad habilidad;
    private boolean ready;
    private Ranking ranking;
    private Equipo equipo;

    public Personaje() { 
        //setId(Utils.generarId());
        ServicioRanking sr = (ServicioRanking) Utils.crearServicio("ServicioRanking");
        setRanking(sr.crear(0, 0, 0));
    }
    
    public boolean checkNull() {
        return Utils.isNull(this);
    }
    
    @Column(unique = true, nullable = false, name="PERSONAJE_NOMBRE")
    public String getNombre() {
        return nombre;
    }

    @Column(nullable = false, name="PERSONAJE_ATK")
    public int getAtk() {
        return atk;
    }

    @Column(nullable = false, name="PERSONAJE_DEF")
    public int getDef() {
        return def;
    }

    @ManyToOne(optional = true)
    @JoinColumn(name="PERSONAJE_ARMAID")
    public Arma getArma() {
        return arma;
    }

    @Column(nullable = false, name="PERSONAJE_MEDIO")
    public Medio getMedio() {
        return medio;
    }

    @Column(nullable = false, name="PERSONAJE_RAZA")
    public Raza getRaza() {
        return raza;
    }
    
    @Column(nullable = false, name="PERSONAJE_HABILIDAD")
    public Habilidad getHabilidad() {
        return habilidad;
    }
    
    @ManyToOne(optional = false)
    @JoinColumn(name="PERSONAJE_PROPIETRIOID")
    public UsuarioRegular getPropietario() {
        return propietario;
    }

    @OneToOne(optional = false)
    @JoinColumn(name="PERSONAJE_RANKINGID")
    public Ranking getRanking() {
        return ranking;
    }

    @Column(nullable = false, name="PERSONAJE_READY")
    public boolean isReady() {
        return ready;
    }

    @ManyToOne(optional = true)
    @JoinColumn(name="PERSONAJE_EQUIPO")
    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

//    public void setArmaId(long armaId) {
//        this.armaId = armaId;
//    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public void setArma(Arma a) {
        arma = a;
    }

    public void setMedio(Medio medio) {
        this.medio = medio;
    }
    
    public void setRaza(Raza raza) {
        this.raza = raza;
    }

    public void setHabilidad(Habilidad habilidad) {
        this.habilidad = habilidad;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }
    
    public void setPropietario(UsuarioRegular ur) {
        propietario = ur;
    }
    
    public final void setRanking(Ranking r) {
        ranking = r;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="PERSONAJE_ID")
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
        if (object instanceof Personaje) {
            Personaje other = (Personaje) object;
            return this.getNombre().equals(other.getNombre());
        }
        return false;
    }

    @Override
    public String toString() {
        return getNombre();
    }
    
}
