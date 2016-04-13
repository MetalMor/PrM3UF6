package beans;

/**
 *
 * @author becari
 * @version 130416
 */
public class CombateSingular extends Combate {
    
    private Personaje pers1;
    private Personaje pers2;
    
    public CombateSingular(Personaje p1, Personaje p2) {
        pers1 = p1;
        pers2 = p2;
    }
    
    public void duelo() {
        // TODO
    }
    
}
