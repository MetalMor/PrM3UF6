package jpa;

import beans.Personaje;
import beans.Usuario;
import java.awt.Image;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import beans.Arma;
import beans.UsuarioRegular;
import props.Habilidad;
import props.Medio;
import props.Raza;
import util.Utils;

/**
 * Servicio de la unidad de persistencia que permite a un usuario regular organizar
 * sus personajes.
 *
 * @author mor
 * @version 110416
 */
public class ServicioPersonaje extends Servicio {

    public ServicioPersonaje(EntityManager em) {
        super(em);
    }
    
    public Personaje crear(String n, int atk, int def, Medio medio, Raza raza, Habilidad hab, Arma a, UsuarioRegular u, boolean ready) {
        Personaje p = new Personaje();
        p.setNombre(n);
        p.setAtk(atk);
        p.setDef(def);
        p.setMedio(medio);
        p.setRaza(raza);
        p.setHabilidad(hab);
        p.setPropietario(u);
        p.setArma(a);
        p.setReady(ready);
        p.setSp(this);
        p.setRanking(((ServicioRanking) Utils.crearServicio("ServicioRanking")).crear(0, 0, 0));
        getEm().getTransaction().begin();
        getEm().persist(p);
        getEm().getTransaction().commit();
        return p;
    }

    public void eliminar(long id) {
        Personaje p = buscar(id);
        if (!p.checkNull()) {
            getEm().remove(p);
        }
    }

    public Personaje cambiarArma(long id, Arma a) {
        Personaje p = buscar(id);
        if (!p.checkNull()) {
            p.setArma(a);
        }
        return p;
    }
    
    public Personaje buscar(long id) {
        return getEm().find(Personaje.class, id);
    }
    
    public List<Personaje> listaPersonajes(long propietarioId) {
        TypedQuery<Personaje> query = getEm().createQuery(
                "SELECT p FROM PERSONAJE p WHERE p.PERSONAJE_PROPIETARIO=:propietarioId", Personaje.class);
        query.setParameter("propietarioId", propietarioId);
        return query.getResultList();
    }
    
}
