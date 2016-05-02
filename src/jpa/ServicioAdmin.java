package jpa;

import beans.Usuario;
import beans.UsuarioAdministrador;
import javax.persistence.EntityManager;

/**
 * Servicio de la unidad de persistencia para crear al usuario administrador en
 * la base de datos.
 * 
 * @author mor
 * @version 130416
 */
public class ServicioAdmin extends Servicio {

    public ServicioAdmin(EntityManager em) {
        super(em);
    }
    
    public UsuarioAdministrador crear() {
        //if (!existeAdmin()) {
            UsuarioAdministrador u = new UsuarioAdministrador();
            u.setNombre("root");
            u.setClave("roflmao1");
            u.setSa(this);
            getEm().getTransaction().begin();
            getEm().persist(u);
            getEm().getTransaction().commit();
            return u;
        //}
        //return null;
    }
    /*
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
    */
}
