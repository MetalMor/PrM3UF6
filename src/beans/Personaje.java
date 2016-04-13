package beans;

import java.awt.Image;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import props.Arma;
import props.Habilidad;
import props.Medio;
import util.Utils;

/**
 *
 * @author mor
 * @version 130416
 */
@Entity
public class Personaje implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String nombre;
    private int atk;
    private int def;
    private Arma arma;
    private Medio medio;
    private Habilidad habilidad;
    private Image imagen;
    private boolean readyFlag;

    public Personaje() { }
    
    public boolean isNull() {
        return Utils.isNull(this);
    }
    
    public String getNombre() {
        return nombre;
    }

    public int getAtk() {
        return atk;
    }

    public int getDef() {
        return def;
    }

    public Arma getArma() {
        return arma;
    }

    public Medio getMedio() {
        return medio;
    }

    public Habilidad getHabilidad() {
        return habilidad;
    }

    public Image getImagen() {
        return imagen;
    }

    public boolean isReadyFlag() {
        return readyFlag;
    }

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMedio(Medio medio) {
        this.medio = medio;
    }

    public void setHabilidad(Habilidad habilidad) {
        this.habilidad = habilidad;
    }

    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }

    public void setReadyFlag(boolean readyFlag) {
        this.readyFlag = readyFlag;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Personaje)) {
            return false;
        }
        Personaje other = (Personaje) object;
        return this.nombre == other.nombre;
    }

    @Override
    public String toString() {
        return "beans.Personaje[ id=" + id + " ]";
    }
    
}
