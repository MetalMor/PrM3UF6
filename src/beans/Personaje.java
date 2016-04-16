package beans;

import java.awt.Image;
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
import props.Habilidad;
import props.Medio;
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
//    private long armaId;
    private Arma arma;
    private Medio medio;
    private Habilidad habilidad;
//    private Image imagen;
    private boolean ready;
//    private long rankingId;
    private Ranking ranking;

    public Personaje() { 
        ready = false;
        //setId(Utils.generarId());
    }
    
    public boolean checkNull() {
        return Utils.isNull(this);
    }

//    @Column(name="PERSONAJE_ARMAID")
//    public long getArmaId() {
//        return armaId;
//    }
//
//    @Column(name="PERSONAJE_RANKINGID")
//    public long getRankingId() {
//        return rankingId;
//    }
    
    @Column(name="PERSONAJE_NOMBRE")
    public String getNombre() {
        return nombre;
    }

    @Column(name="PERSONAJE_ATK")
    public int getAtk() {
        return atk;
    }

    @Column(name="PERSONAJE_DEF")
    public int getDef() {
        return def;
    }

    @ManyToOne
    @JoinColumn(name="PERSONAJE_ARMAID")
    public Arma getArma() {
        return arma;
    }

    @Column(name="PERSONAJE_MEDIO")
    public Medio getMedio() {
        return medio;
    }

    @Column(name="PERSONAJE_HABILIDAD")
    public Habilidad getHabilidad() {
        return habilidad;
    }

    /*@Column(name="PERSONAJE_IMAGEN")
    public Image getImagen() {
        return imagen;
    }*/
    
    @ManyToOne
    @JoinColumn(name="PERSONAJE_PROPIETRIOID")
    public UsuarioRegular getPropietario() {
        return propietario;
    }

    @OneToOne
    @JoinColumn(name="PERSONAJE_RANKINGID")
    public Ranking getRanking() {
        return ranking;
    }

    @Column(name="PERSONAJE_READY")
    public boolean isReady() {
        return ready;
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

    public void setHabilidad(Habilidad habilidad) {
        this.habilidad = habilidad;
    }

//    public void setImagen(Image imagen) {
//        this.imagen = imagen;
//    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }

//    public void setRankingId(long rankingId) {
//        this.rankingId = rankingId;
//    }
    
    public void setPropietario(UsuarioRegular ur) {
        propietario = ur;
    }
    
    public void setRanking(Ranking r) {
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
