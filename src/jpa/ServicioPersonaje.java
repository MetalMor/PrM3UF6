package jpa;

import beans.Personaje;
import beans.Usuario;
import java.awt.Image;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import props.Arma;
import props.Medio;

/**
 * Servicio de la unidad de persistencia que permite a un usuario regular organizar
 * sus personajes.
 *
 * @author mor
 * @version 110416
 */
public class ServicioPersonaje {
    
    protected EntityManager em;

    public ServicioPersonaje() { }
    
    public ServicioPersonaje(EntityManager em) {
        this.em = em;
    }
    
    public Personaje crear(String n, int atk, int def, Medio medio, Image img) {
        Personaje p = new Personaje();
        p.setNombre(n);
        p.setAtk(atk);
        p.setDef(def);
        p.setMedio(medio);
        p.setImagen(img);
        em.persist(p);
        return p;
    }

    public void eliminar(long id) {
        Personaje p = buscar(id);
        if (!p.checkNull()) {
            em.remove(p);
        }
    }

    public Personaje cambiarArma(long id, Arma a) {
        Personaje p = em.find(Personaje.class, id);
        if (!p.checkNull()) {
            p.setArma(a);
        }
        return p;
    }
    
    public Personaje buscar(long id) {
        return em.find(Personaje.class, id);
    }
    
    public List<Personaje> listaPersonajes(long propietarioId) {
        TypedQuery<Personaje> query = em.createQuery(
                "SELECT p FROM PERSONAJE p WHERE p.PERSONAJE_PROPIETARIO=:propietarioId", Personaje.class);
        query.setParameter("propietarioId", propietarioId);
        return query.getResultList();
    }
    
}
