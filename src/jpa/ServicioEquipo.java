package jpa;

import beans.Equipo;
import beans.Personaje;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author mor
 * @version 130416
 */
public class ServicioEquipo {
    
    private EntityManager em;
    
    public ServicioEquipo(EntityManager em) {
        this.em = em;
    }
    
    public Equipo crear(List<Personaje> personajes) {
        Equipo e = new Equipo();
        e.setMiembros(personajes);
        em.persist(e);
        return e;
    }
    
    public Equipo buscar(long id) {
        return em.find(Equipo.class, id);
    }
    
    public Equipo cambiarMiembros(long id, List<Personaje> personajes) {
        Equipo e = buscar(id);
        if(!e.isNull())
            e.setMiembros(personajes);
        return e;
    }
    
    public void eliminar(long id) {
        Equipo e = em.find(Equipo.class, id);
        if (!e.isNull()) {
            em.remove(e);
        }
    }
    
    public List<Equipo> listaEquipos() {
        TypedQuery<Equipo> query = em.createQuery(
                "SELECT e FROM PERSONAJE e", Equipo.class);
        return query.getResultList();
    }
    
}
