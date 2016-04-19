package jpa;

import java.awt.Image;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import beans.Arma;

/**
 * Servicio de la unidad de persistencia para crear/modificar/eliminar armas,
 * creado para el usuario administrador.
 *
 * @author mor
 * @version 130416
 */
public class ServicioArma extends Servicio {

    public ServicioArma(EntityManager em) {
        super(em);
    }
    
    public Arma crear(String n, int atk, int def) {
        Arma a = new Arma();
        a.setNombre(n);
        a.setAtk(atk);
        a.setDef(def);
//        a.setImagen(img);
        getEm().getTransaction().begin();
        getEm().persist(a);
        getEm().getTransaction().commit();
        return a;
    }
    
    public void eliminar(long id) {
        Arma a = buscar(id);
        if (!a.checkNull()) {
            getEm().remove(a);
        }
    }
    
    public Arma buscar(long id) {
        return getEm().find(Arma.class, id);
    }
    
    public Arma cambiarStats(long id, String n, int atk, int def) {
        Arma a = getEm().find(Arma.class, id);
        if (!a.checkNull()) {
            a.setNombre(n);
            a.setAtk(atk);
            a.setDef(def);
//            a.setImagen(img);
        }
        return a;
    }
    
    public List<Arma> listaArmas() {
        TypedQuery<Arma> query = getEm().createQuery(
                "SELECT e FROM ARMA e", Arma.class);
        return query.getResultList();
    }
    
}
