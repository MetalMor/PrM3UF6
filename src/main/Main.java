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
        
    }
    
}
