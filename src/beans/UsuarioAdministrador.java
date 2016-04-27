package beans;

import java.awt.Image;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Transient;
import jpa.ServicioArma;
import jpa.ServicioUsuario;
import util.Utils;

/**
 * Clase que representa al usuario administrador del sistema, el cual puede crear
 * otros usuarios y armas para los personajes.
 *
 * @author mor
 * @version 130416
 */
@Entity
@Access(AccessType.PROPERTY)
@DiscriminatorValue(value = "A")
public class UsuarioAdministrador extends Usuario {
    
    public UsuarioAdministrador() {
        super();
    }
    
}
