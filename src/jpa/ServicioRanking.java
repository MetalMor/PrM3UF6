package jpa;

import beans.Ranking;
import javax.persistence.EntityManager;

/**
 * Servicio de la unidad de persistencia para controlar el guardado y consulta
 * de datos del ránking de cada personaje.
 *
 * @author mor
 * @version 130416
 */
public class ServicioRanking {
    
    private EntityManager em;
    
    public ServicioRanking() { }
    
    public ServicioRanking(EntityManager em) {
        this.em = em;
    }
    
    public Ranking crear(int victorias, int empates, int derrotas) {
        Ranking r = new Ranking();
        r.setVictorias(victorias);
        r.setEmpates(empates);
        r.setDerrotas(derrotas);
        em.persist(r);
        return r;
    }
    
    public Ranking buscar(long id) {
        return em.find(Ranking.class, id);
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
            em.remove(r);
    }
    
}
