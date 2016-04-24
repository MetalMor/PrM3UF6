package collection;

import java.util.ArrayList;
import java.util.Collection;
/**
 *
 * @author Edgar Ben
 */
public class ListaOrdenada<T> extends ArrayList {

    /**
     * Constructor de tamany estàtic.
     * 
     * @param initialCapacity Valor integer del límit en el nombre d'elements.
     */
    public ListaOrdenada(int initialCapacity) {
        super(initialCapacity);
    }

    /**
     * Constructor sense arguments.
     */
    public ListaOrdenada() { }

    /**
     * Constructor a partir d'una colecció predefinida.
     * 
     * @param c Objecte que implementa la interfície Collection.
     */
    public ListaOrdenada(Collection c) {
        super(c);
        this.sort(new RankingComparator());
    }
    
}
