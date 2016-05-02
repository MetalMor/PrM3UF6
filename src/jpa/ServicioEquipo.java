package jpa;

import beans.Equipo;
import beans.Personaje;
import beans.UsuarioRegular;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import util.Utils;

/**
 * Servicio de la unidad de persistencia que permite a un usuario regular organizar
 * sus equipos de combate.
 *
 * @author mor
 * @version 130416
 */
public class ServicioEquipo extends Servicio {

    public ServicioEquipo(EntityManager em) {
        super(em);
    }
    
    public Equipo crear(String n, String lema, UsuarioRegular u) {
        Equipo e = new Equipo();
        e.setNombre(n);
        e.setLema(lema);
        e.setPropietario(u);
        e.setSe(this);
        getEm().getTransaction().begin();
        getEm().persist(e);
        getEm().getTransaction().commit();
        return e;
    }
    
    public Equipo buscar(long id) {
        return getEm().find(Equipo.class, id);
    }
    
    public Equipo addMiembro(long id, Personaje p) {
        Equipo e = buscar(id);
        if(!e.checkNull())
            e.getMiembros().add(p);
        return e;
    }
    
    public Equipo cambiarMiembros(long id, List<Personaje> personajes) {
        Equipo e = buscar(id);
        if(!e.checkNull())
            e.setMiembros(personajes);
        ServicioPersonaje sp;
        for (Personaje p: personajes) {
            sp = (ServicioPersonaje) Utils.crearServicio("ServicioPersonaje");
            sp.cambiarEquipo(p.getId(), e);
        }
        return e;
    }
    
    public void eliminar(long id) {
        Equipo e = getEm().find(Equipo.class, id);
        if (!e.checkNull()) {
            getEm().remove(e);
        }
    }
    
    public List<Equipo> listaEquipos(long propietarioId) {
        TypedQuery<Equipo> query = getEm().createQuery(
                "SELECT e FROM PERSONAJE e", Equipo.class);
        return query.getResultList();
    }
    
}
