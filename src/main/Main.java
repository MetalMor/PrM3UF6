package main;

import beans.Personaje;
import beans.UsuarioAdministrador;
import beans.UsuarioRegular;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import jpa.ServicioAdmin;
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
        
        // Hola
        // Creas un servicio como pongo aqui.
        // Desde el servicio llamas a la funcion crear, mirate los parámetros q
        // tiene cada una antes de ponerselos a lo loco, algunos campos no pueden
        // ser null. Los que te pone por defecto no tienen por qué estar bien.
        // Todos los objetos tienen un toString, si los printas como hago con el
        // admin podras ver por pantalla si salen los datos bien.
        // Para ver la base de datos acuerdate de q en el netbeans le puedes
        // hacer queries si vas a la pestaña "services" donde el arbol de proyectos.
        ServicioAdmin sa = (ServicioAdmin) Utils.crearServicio("ServicioAdmin"); // creo servicio
        UsuarioAdministrador admin = (UsuarioAdministrador) sa.crear(); // creo admin
        System.out.println(admin); // printo admin
        /*if (!Utils.isNull(admin)) {
            System.out.println(admin);
        } else {
            System.out.println("Admin = null");
        }
        admin.crearArma("Palo de la verdad", 1, 1);
        UsuarioRegular user = (UsuarioRegular) admin.crearUsuario("prueba", "prueba123");
        System.out.println(user.crearPersonaje("pepito", 1, 1, Medio.CUEVA, Raza.TEMMIE, Habilidad.NINGUNA, null, true));
        System.out.println(user.crearPersonaje("juanito", 1, 1, Medio.MAR, Raza.ELFO, Habilidad.VELOCIDAD, null, true));
        System.out.println(user.crearPersonaje("jorgito", 1, 1, Medio.BOSQUE, Raza.TROLL, Habilidad.KAITO, null, true));
        System.out.println(user.crearPersonaje("pedrito", 1, 1, Medio.FUEGO, Raza.ORCO, Habilidad.NINGUNA, null, true));*/

    }
    
}
