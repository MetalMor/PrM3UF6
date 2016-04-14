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
import javax.persistence.Table;
import util.Utils;

/**
 *
 * @author mor
 * @version 130416
 */
@Entity
@Access(AccessType.PROPERTY)
@Table(name = "USUARIO", schema = "FIGHTCLUB")
public abstract class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    
    private String nombre;
    private String clave;

    public Usuario() {
    }

    public void login() {
        // TODO
    }
    
    @Column(name="USUARIO_NOMBRE")
    public String getNombre() {
        return nombre;
    }

    @Column(name="USUARIO_CLAVE")
    public String getClave() {
        return clave;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean checkNull() {
        return Utils.isNull(this);
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Usuario) {
            Usuario other = (Usuario) o;
            return Utils.isNull(this.getId()) || Utils.isNull(other.getId()) ? 
                    this.getNombre().equals(other.getNombre()) : 
                    this.getId() == other.getId();
        }
        return false;
    }

    @Override
    public String toString() {
        return nombre+"("+id+")";
    }
    
}
