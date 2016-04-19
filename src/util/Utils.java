package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import jpa.Servicio;
import jpa.ServicioAdmin;
import jpa.ServicioArma;
import jpa.ServicioEquipo;
import jpa.ServicioPersonaje;
import jpa.ServicioRanking;
import jpa.ServicioUsuario;

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
    
    public static Servicio crearServicio(String persUd) {
        EntityManager em = crearEntityManager(persUd);
        switch(persUd) {
            case "ServicioAdmin":
                return new ServicioAdmin(em);
            case "ServicioArma":
                return new ServicioArma(em);
            case "ServicioEquipo":
                return new ServicioEquipo(em);
            case "ServicioPersonaje":
                return new ServicioPersonaje(em);
            case "ServicioRanking":
                return new ServicioRanking(em);
            case "ServicioUsuario":
                return new ServicioUsuario(em);
        }
        return null;
    }
    
    private static EntityManager crearEntityManager(String persUd) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(persUd);
        return emf.createEntityManager();
    }
    
}
