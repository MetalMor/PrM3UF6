package jpa;

import beans.Personaje;
import beans.Ranking;
import javax.persistence.EntityManager;

/**
 * Servicio de la unidad de persistencia para controlar el guardado y consulta
 * de datos del ránking de cada personaje.
 *
 * @author mor
 * @version 130416
 */
public class ServicioRanking extends Servicio {

    public ServicioRanking(EntityManager em) {
        super(em);
    }
    
    public Ranking crear(int victorias, int empates, int derrotas, Personaje p) {
        Ranking r = new Ranking();
        r.setVictorias(victorias);
        r.setEmpates(empates);
        r.setDerrotas(derrotas);
        r.setPropietario(p);
        r.setSr(this);
        getEm().getTransaction().begin();
        getEm().persist(r);
        getEm().getTransaction().commit();
        return r;
    }
    
    public Ranking buscar(long id) {
        return getEm().find(Ranking.class, id);
    }
    
    public Ranking victoria(long id) {
        Ranking r = buscar(id);
        if (!r.checkNull()) {
            r.addVictoria();
        }
        return r;
    }
    
    public Ranking derrota(long id) {
        Ranking r = buscar(id);
        if (!r.checkNull()) {
            r.addDerrota();
        }
        return r;
    }
    
    public Ranking empate(long id) {
        Ranking r = buscar(id);
        if (!r.checkNull()) {
            r.addEmpate();
        }
        return r;
    }
    
    public void eliminar(long id) {
        Ranking r = buscar(id);
        if(!r.checkNull())
            getEm().remove(r);
    }
    
}
