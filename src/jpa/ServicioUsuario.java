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
public class ServicioUsuario extends Servicio {

    public ServicioUsuario(EntityManager em) {
        super(em);
    }

    public Usuario crear(String n, String c) {
        Usuario u = new UsuarioRegular();
        u.setNombre(n);
        u.setClave(c);
        getEm().getTransaction().begin();
        getEm().persist(u);
        getEm().getTransaction().commit();
        return u;
    }

    public void eliminar(long id) {
        Usuario u = buscar(id);
        if (!u.checkNull()) {
            getEm().remove(u);
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
        return getEm().find(Usuario.class, id);
    }
    
    public List<Usuario> listaUsuarios() {
        TypedQuery<Usuario> query = getEm().createQuery(
                "SELECT e FROM USUARIO e", Usuario.class);
        return query.getResultList();
    }
    
}