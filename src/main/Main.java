package main;

import beans.Usuario;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import jpa.ServicioAdmin;
import util.Utils;

/**
 *
 * @author mor
 * @version 080416
 */
public class Main extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //launch(args);
        EntityManagerFactory emfa = Persistence.createEntityManagerFactory("ServicioAdmin");
        EntityManager ema = emfa.createEntityManager();
        ServicioAdmin sa = new ServicioAdmin(ema);
        Usuario admin = sa.crear();
        if (!Utils.isNull(admin)) {
            System.out.println(admin);
        } else {
            System.out.println("Admin = null");
        }
    }
    
}
