package beans;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Persistence;
import javax.persistence.Transient;
import jpa.ServicioEquipo;
import jpa.ServicioPersonaje;
import props.Medio;
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
public class UsuarioRegular extends Usuario {
    
    private ServicioPersonaje sp;
    private ServicioEquipo se;
    
    private List<Personaje> personajes;
    private List<Equipo> equipos;
    
    public UsuarioRegular() {
        super();
        setSp((ServicioPersonaje) Utils.crearServicio("ServicioPersonaje"));
        setSe((ServicioEquipo) Utils.crearServicio("ServicioEquipo"));
    }
    
    public Equipo crearEquipo(List<Personaje> personajes) {
        return se.crear(personajes);
    }
    
    public Equipo cambiarEquipo(long id, List<Personaje> personajes) {
        return se.cambiarMiembros(id, personajes);
    }
    
    public void eliminarEquipo(long id) {
        se.eliminar(id);
    }
    
    public List<Equipo> listaEquipos() {
        return se.listaEquipos(this.getId());
    }
    
    public Personaje crearPersonaje(String n, int atk, int def, Medio medio, Image img) {
        return sp.crear(n, atk, def, medio, img);
    }
    
    public Personaje cambiarArmaPersonaje(long id, Arma a) {
        return sp.cambiarArma(id, a);
    }
    
    public void eliminarPersonaje(Personaje p) {
        sp.eliminar(p.getId());
    }
    
    private List<Personaje> listaPersonajes() {
        return sp.listaPersonajes(this.getId());
    }
    
    @OneToMany
    @JoinColumn(name="USUARIO_PERSONAJES")
    public List<Personaje> getPersonajes() {
        return personajes;
    }
    
    @OneToMany
    @JoinColumn(name="USUARIO_EQUIPOS")
    public List<Equipo> getEquipos() {
        return equipos;
    }

    @Transient
    public ServicioPersonaje getSp() {
        return sp;
    }

    @Transient
    public ServicioEquipo getSe() {
        return se;
    }

    public final void setSp(ServicioPersonaje sp) {
        this.sp = sp;
    }

    public final void setSe(ServicioEquipo se) {
        this.se = se;
    }
    
    public void setPersonajes(List<Personaje> pers) {
        personajes = pers;
    }
    
    public void setEquipos(List<Equipo> eqp) {
        equipos = eqp;
    }
    
}
