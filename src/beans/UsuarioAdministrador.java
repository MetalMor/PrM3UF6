package beans;

import java.awt.Image;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import jpa.ServicioArma;
import jpa.ServicioUsuario;
import props.Arma;

/**
 *
 * @author mor
 * @version 130416
 */
public class UsuarioAdministrador extends Usuario {
    
    private ServicioUsuario su;
    private ServicioArma sa;
    
    public UsuarioAdministrador() {
        super();
        EntityManagerFactory emfu = Persistence.createEntityManagerFactory("ServicioUsuario");
        EntityManager emu = emfu.createEntityManager();
        EntityManagerFactory emfa = Persistence.createEntityManagerFactory("ServicioPersonaje");
        EntityManager ema = emfa.createEntityManager();
        su = new ServicioUsuario(emu);
        sa = new ServicioArma(ema);
    }
    
    public void crearArma(String n, int atk, int def, Image img) {
        sa.crear(n, atk, def, img);
    }
    
    public void editarArma(int id) {
        // TODO
    }
    
    public void eliminarArma(Arma a) {
        sa.eliminar(a.getId());
    }
    
    public void crearUsuario(String n, String c) {
        su.crear(n, c);
    }
    
    public void editarUsuario() {
        // TODO
    }
    
    public void eliminarUsuario(Usuario u) {
        su.eliminar(u.getId());
    }
    
}
