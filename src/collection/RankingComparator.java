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
        Ranking ranking1 = (Ranking) r1;
        Ranking ranking2 = (Ranking) r2;
        
        return ranking1.compareTo(ranking2);
    }
}
