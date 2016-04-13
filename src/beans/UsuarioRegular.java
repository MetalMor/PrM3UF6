package beans;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import jpa.ServicioEquipo;
import jpa.ServicioPersonaje;
import props.Medio;

/**
 *
 * @author mor
 * @version 130416
 */
public class UsuarioRegular extends Usuario {
    
    private ServicioPersonaje sp;
    private ServicioEquipo se;
    private List<Personaje> personajes;
    private List<Equipo> equipos;
    
    public UsuarioRegular() {
        super();
        personajes = new ArrayList<>();
        equipos = new ArrayList<>();
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
    
    public void editarPersonaje() {
        
    }
    
    public void eliminarPersonaje(Personaje p) {
        sp.eliminar(p.getId());
    }
    
    private void actualizarPersonajes() {
        // TODO a esto se le llamará cuando haya un cambio en la BD para que
        // actualice la lista de personajes del usuario
    }
    
}
