package beans;

import java.awt.Image;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Transient;
import jpa.ServicioArma;
import jpa.ServicioUsuario;

/**
 * Clase que representa al usuario administrador del sistema, el cual puede crear
 * otros usuarios y armas para los personajes.
 *
 * @author mor
 * @version 130416
 */
@Entity
@Access(AccessType.PROPERTY)
public class UsuarioAdministrador extends Usuario {
    
    private ServicioUsuario su;
    private ServicioArma sa;
    
    public UsuarioAdministrador() {
        super();
        EntityManagerFactory emfu = Persistence.createEntityManagerFactory("ServicioUsuario");
        EntityManager emu = emfu.createEntityManager();
        EntityManagerFactory emfa = Persistence.createEntityManagerFactory("ServicioArma");
        EntityManager ema = emfa.createEntityManager();
        setSu(new ServicioUsuario(emu));
        setSa(new ServicioArma(ema));
    }
    
    public Arma crearArma(String n, int atk, int def, Image img) {
        return sa.crear(n, atk, def);
    }
    
    public Arma editarArma(int id, String n, int atk, int def, Image img) {
        return sa.cambiarStats(id, atk, def);
    }
    
    public void eliminarArma(Arma a) {
        sa.eliminar(a.getId());
    }
    
    public Usuario crearUsuario(String n, String c) {
        return su.crear(n, c);
    }
    
    public Usuario editarUsuario(long id, String n, String c) {
        return su.editar(id, n, c);
    }
    
    public void eliminarUsuario(Usuario u) {
        su.eliminar(u.getId());
    }

    @Transient
    public ServicioUsuario getSu() {
        return su;
    }

    @Transient
    public ServicioArma getSa() {
        return sa;
    }
    
    public final void setSu(ServicioUsuario su) {
        this.su = su;
    }

    public final void setSa(ServicioArma sa) {
        this.sa = sa;
    }
    
}
