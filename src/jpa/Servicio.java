package jpa;

import javax.persistence.EntityManager;

/**
 * Clase abstracta para definir el tipo general Servicio, del cual se podrá crear
 * cualquier objeto de una clase hijo desde el método correspondiente en Utils.
 *
 * @author mor
 * @version 160416
 */
public abstract class Servicio {
    
    private EntityManager em;
    
    public Servicio(EntityManager em) {
        setEm(em);
    }
    
    public EntityManager getEm() {
        return em;
    }
    
    public final void setEm(EntityManager em) {
        this.em = em;
    }
    
}
