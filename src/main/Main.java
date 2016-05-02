package main;

import beans.Arma;
import beans.Personaje;
import beans.UsuarioAdministrador;
import beans.UsuarioRegular;
import beans.Equipo;
import beans.Ranking;
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
        
        ServicioUsuario us = (ServicioUsuario) Utils.crearServicio("ServicioUsuario");
        ServicioPersonaje sp = (ServicioPersonaje) Utils.crearServicio("ServicioPersonaje");
        ServicioArma sarma = (ServicioArma) Utils.crearServicio("ServicioArma");
        ServicioRanking sr = (ServicioRanking) Utils.crearServicio("ServicioRanking");
        //ServicioEquipo se = (ServicioEquipo) Utils.crearServicio("ServicioEquipo");
        ServicioAdmin sa = (ServicioAdmin) Utils.crearServicio("ServicioAdmin"); // creo servicio
        //creando
        UsuarioAdministrador admin = (UsuarioAdministrador) sa.crear(); // creo admin
        Arma arma = (Arma) sarma.crear("Hacha", 2, 2);
       
        UsuarioRegular usuario = (UsuarioRegular) us.crear("edgar123", "contra");
       
        //
        Personaje personaje = (Personaje) sp.crear("OrcodeMoria", 3, 2, Medio.CUEVA, Raza.ORCO, Habilidad.KAITO, usuario, true);
        Personaje personaje2 = (Personaje) sp.crear("blipblop", 3, 2, Medio.CUEVA, Raza.TEMMIE, Habilidad.KAITO, usuario, true);
        //Equipo equipo =(Equipo) se.crear(, "Equipo1", "somoslosmejores",usuario );
        

     
       // arma.getSa().cambiarStats(52, "MAZA", 7, 1); //No va
//        arma.getSa().eliminar(52); //No va
//        
//           usuario.getSu().editar(101, "edgarv2", "123");// No va
//        usuario.getSu().buscar(1);
//        usuario.getSu().eliminar(101); // No va
        
        System.out.println(admin); // printo admin
        System.out.println(arma);
        System.out.println(usuario);
        System.out.println(arma.getSa().crear("MAZA", 5, 2));
         System.out.println(usuario.getSu().buscar(1));
         System.out.println(arma.getSa().buscar(51));
         //Este de Personaje solo hay que crear otra arma
         // System.out.println(personaje.getSp().crear("Elfo", 5, 2, Medio.BOSQUE, Raza.ELFO, Habilidad.KAITO, arma, usuario, true));
         
         
         
          System.out.println(personaje);
//        System.out.println(equipo);
        
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
