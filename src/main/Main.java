package main;

import beans.Arma;
import beans.Personaje;
import beans.UsuarioAdministrador;
import beans.UsuarioRegular;
import beans.Equipo;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import jpa.ServicioEquipo;
import jpa.ServicioAdmin;
import jpa.ServicioArma;
import jpa.ServicioPersonaje;
import jpa.ServicioRanking;
import jpa.ServicioUsuario;
import static org.eclipse.persistence.sessions.SessionProfiler.Transaction;
import props.Habilidad;
import props.Medio;
import props.Raza;
import util.Utils;

/**
 *
 * @author mor
 * @version 080416
 */
public class Main extends Application {
    
    public Main() { }
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("LOGIN_FC.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //launch(args);
        try {
            ServicioAdmin sad = (ServicioAdmin) Utils.crearServicio("ServicioAdmin");
            ServicioPersonaje sp1 = (ServicioPersonaje) Utils.crearServicio("ServicioPersonaje");
            ServicioPersonaje sp2 = (ServicioPersonaje) Utils.crearServicio("ServicioPersonaje");
            ServicioPersonaje sp3 = (ServicioPersonaje) Utils.crearServicio("ServicioPersonaje");
            ServicioPersonaje sp4 = (ServicioPersonaje) Utils.crearServicio("ServicioPersonaje");
            ServicioArma sar1 = (ServicioArma) Utils.crearServicio("ServicioArma");
            ServicioArma sar2 = (ServicioArma) Utils.crearServicio("ServicioArma");
            ServicioEquipo se1 = (ServicioEquipo) Utils.crearServicio("ServicioEquipo");
            ServicioEquipo se2 = (ServicioEquipo) Utils.crearServicio("ServicioEquipo");
            ServicioUsuario su1 = (ServicioUsuario) Utils.crearServicio("ServicioUsuario");
            ServicioUsuario su2 = (ServicioUsuario) Utils.crearServicio("ServicioUsuario");

            UsuarioAdministrador admin = sad.crear();

            UsuarioRegular usr1 = su1.crear("edgar", "prueba123");
            List<Personaje> list1 = new ArrayList<>();
            UsuarioRegular usr2 = su2.crear("joel", "prueba123");
            List<Personaje> list2 = new ArrayList<>();

            Arma a1 = sar1.crear("Palo", 2, 0);
            Arma a2 = sar2.crear("Tapa de la basura", 0, 2);

            Personaje p1 = sp1.crear("Marielfo", 1, 2, Medio.MAR, Raza.ELFO, Habilidad.VELOCIDAD, a1, usr1, true);
            list1.add(p1);
            Personaje p2 = sp2.crear("Gorko", 2, 1, Medio.CUEVA, Raza.ORCO, Habilidad.NINGUNA, a2, usr1, true);
            list1.add(p2);
            Personaje p3 = sp3.crear("Trololololó", 1, 2, Medio.FUEGO, Raza.TROLL, Habilidad.KAITO, a1, usr2, true);
            list2.add(p3);
            Personaje p4 = sp4.crear("tEMMIE!", 2, 1, Medio.BOSQUE, Raza.TEMMIE, Habilidad.NINGUNA, a2, usr2, true);
            list2.add(p4);

            Equipo e1 = se1.crear("Petadores de anos", "esaekalo", usr1);
            e1 = se1.cambiarMiembros(e1.getId(), list1);
            Equipo e2 = se2.crear("Los cortapichas", "olakease", usr2);
            e2 = se2.cambiarMiembros(e2.getId(), list2);

            System.out.println("OK");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("NOPE");
        }
        
    }
    
}
