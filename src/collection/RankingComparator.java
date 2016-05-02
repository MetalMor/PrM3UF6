package collection;

import beans.Ranking;
import java.util.Comparator;

/**
 *
 * @author Edgar Ben
 */
public class RankingComparator implements Comparator {
    @Override
    public int compare(Object r1, Object r2) {
        return ((Ranking) r2).compareTo((Ranking) r2);
    }
}
