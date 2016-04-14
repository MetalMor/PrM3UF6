package jpa;

import beans.Usuario;
import beans.UsuarioRegular;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 * Servicio de la unidad de persistencia que organiza los usuarios regulares que
 * pueden participar en el juego. Creado para el usuario administrador.
 *
 * @author mor
 * @version 130416
 */
public class ServicioUsuario {

    protected EntityManager em;

    public ServicioUsuario(EntityManager em) {
        this.em = em;
    }

    public Usuario crear(String n, String c) {
        Usuario u = new UsuarioRegular();
        u.setNombre(n);
        u.setClave(c);
        em.persist(u);
        return u;
    }

    public void eliminar(long id) {
        Usuario u = buscar(id);
        if (!u.checkNull()) {
            em.remove(u);
        }
    }

    public Usuario editar(long id, String n, String c) {
        Usuario u = buscar(id);
        if (!u.checkNull()) {
            u.setNombre(n);
            u.setClave(c);
        }
        return u;
    }
    
    public Usuario buscar(long id) {
        return em.find(Usuario.class, id);
    }
    
    public List<Usuario> listaUsuarios() {
        TypedQuery<Usuario> query = em.createQuery(
                "SELECT e FROM USUARIO e", Usuario.class);
        return query.getResultList();
    }
    
}