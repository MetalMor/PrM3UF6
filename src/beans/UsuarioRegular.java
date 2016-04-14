package beans;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import jpa.ServicioEquipo;
import jpa.ServicioPersonaje;
import props.Arma;
import props.Medio;

/**
 * Clase que representa un usuario regular del sistema, el cual puede organizar
 * sus personajes y equipos con funciones de persistencia.
 *
 * @author mor
 * @version 130416
 */
public class UsuarioRegular extends Usuario {
    
    private ServicioPersonaje sp;
    private ServicioEquipo se;
    
    public UsuarioRegular() {
        super();
        EntityManagerFactory emfp = Persistence.createEntityManagerFactory("ServicioPersonaje");
        EntityManager emp = emfp.createEntityManager();
        EntityManagerFactory emfe = Persistence.createEntityManagerFactory("ServicioEquipo");
        EntityManager eme = emfe.createEntityManager();
        sp = new ServicioPersonaje(emp);
        se = new ServicioEquipo(eme);
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
    
}
