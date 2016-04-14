package jpa;

import beans.Personaje;
import beans.Usuario;
import beans.UsuarioAdministrador;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

/**
 * Servicio de la unidad de persistencia para crear al usuario administrador en
 * la base de datos.
 * 
 * @author mor
 * @version 130416
 */
public class ServicioAdmin {
    
    private EntityManager em;
    
    public ServicioAdmin(EntityManager em) {
        this.em = em;
    }
    
    public Usuario crear() {
        if (!existeAdmin()) {
            Usuario u = new UsuarioAdministrador();
            u.setNombre("root");
            u.setClave("roflmao1");
            em.persist(u);
            return u;
        }
        return null;
    }
    
    public boolean existeAdmin() {
        TypedQuery<Usuario> query = em.createQuery(
                "SELECT u FROM USUARIO u WHERE u.USUARIO_NOMBRE=:nombre", Usuario.class);
        query.setParameter("nombre", "root");
        try {
            query.getSingleResult();
        } catch (NoResultException nrEx) {
            return false;
        } finally {
            return true;
        }
    }
    
}
