package util;

/**
 * Clase de utilidad con diferentes métodos estáticos a usar en toda la aplicación.
 *
 * @author mor
 * @version 130416
 */
public class Utils {
    
    public static boolean isNull(Object o) {
        return o == null;
    }

    public static Long generarId() {
        return System.currentTimeMillis();
    }
    
}
