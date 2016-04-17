package main;

import beans.UsuarioAdministrador;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import jpa.ServicioAdmin;
import static org.eclipse.persistence.sessions.SessionProfiler.Transaction;
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
        ServicioAdmin sa = (ServicioAdmin) Utils.crearServicio("ServicioAdmin");
        sa.getEm().getTransaction().begin();
        UsuarioAdministrador admin = (UsuarioAdministrador) sa.crear();
        if (!Utils.isNull(admin)) {
            System.out.println(admin);
        } else {
            System.out.println("Admin = null");
        }
        System.out.println(admin.crearArma("Palo de la verdad", 1, 1));
        sa.getEm().getTransaction().commit();
    }
    
}
