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
        ServicioAdmin sad = (ServicioAdmin) Utils.crearServicio("ServicioAdmin");
        ServicioRanking sr = (ServicioRanking) Utils.crearServicio("ServicioRanking");
        ServicioPersonaje sp = (ServicioPersonaje) Utils.crearServicio("ServicioPersonaje");
        ServicioArma sar = (ServicioArma) Utils.crearServicio("ServicioArma");
        ServicioEquipo se = (ServicioEquipo) Utils.crearServicio("ServicioEquipo");
        ServicioUsuario su1 = (ServicioUsuario) Utils.crearServicio("ServicioUsuario");
        ServicioUsuario su2 = (ServicioUsuario) Utils.crearServicio("ServicioUsuario");
        
        UsuarioAdministrador admin = sad.crear();
        
        UsuarioRegular usr1 = su1.crear("edgar", "prueba123");
        List<Personaje> list1 = new ArrayList<>();
        UsuarioRegular usr2 = su2.crear("joel", "prueba123");
        List<Personaje> list2 = new ArrayList<>();
        
        Arma a1 = sar.crear("Palo", 2, 0);
        Arma a2 = sar.crear("Tapa de la basura", 0, 2);
        
        Personaje p1 = sp.crear("Marielfo", 1, 2, Medio.MAR, Raza.ELFO, Habilidad.VELOCIDAD, null, usr1, true);
        list1.add(p1);
        Personaje p2 = sp.crear("Gorko", 2, 1, Medio.CUEVA, Raza.ORCO, Habilidad.NINGUNA, null, usr1, true);
        list1.add(p2);
        Personaje p3 = sp.crear("Trololololó", 1, 2, Medio.FUEGO, Raza.TROLL, Habilidad.KAITO, null, usr2, true);
        list2.add(p3);
        Personaje p4 = sp.crear("tEMMIE!", 2, 1, Medio.BOSQUE, Raza.TEMMIE, Habilidad.NINGUNA, null, usr2, true);
        list2.add(p4);
        
        Equipo e1 = se.crear(list1, "Petadores de anos", "esaekalo", usr1);
        Equipo e2 = se.crear(list2, "Los cortapichas", "olakease", usr2);
        
    }
    
}
