package beans;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Persistence;
import javax.persistence.Transient;
import jpa.ServicioEquipo;
import jpa.ServicioPersonaje;
import props.Habilidad;
import props.Medio;
import props.Raza;
import util.Utils;

/**
 * Clase que representa un usuario regular del sistema, el cual puede organizar
 * sus personajes y equipos con funciones de persistencia.
 *
 * @author mor
 * @version 130416
 */
@Entity
@Access(AccessType.PROPERTY)
@DiscriminatorValue(value = "R")
public class UsuarioRegular extends Usuario {
    
    private List<Personaje> personajes = new ArrayList<>();
    private List<Equipo> equipos = new ArrayList<>();
    
    public UsuarioRegular() {
        super();
    }
    
    @OneToMany(cascade=CascadeType.ALL, mappedBy="propietario")
    @JoinColumn(name="USUARIO_PERSONAJES")
    public List<Personaje> getPersonajes() {
        return personajes;
    }
    
    @OneToMany(cascade=CascadeType.ALL, mappedBy="propietario")
    @JoinColumn(name="USUARIO_EQUIPOS")
    public List<Equipo> getEquipos() {
        return equipos;
    }
    
    public void setPersonajes(List<Personaje> pers) {
        personajes = pers;
    }
    
    public void setEquipos(List<Equipo> eqp) {
        equipos = eqp;
    }
    
}
