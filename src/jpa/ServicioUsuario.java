package jpa;

import beans.Usuario;
import beans.UsuarioRegular;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author sergi
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
        if (!u.isNull()) {
            em.remove(u);
        }
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