package beans;

import java.util.List;

/**
 *
 * @author mor
 * @version 130416
 */
public class UsuarioRegular extends Usuario {
    
    private List<Personaje> personajes;
    
    public void crearPersonaje() {
        // TODO
    }
    
    public void editarPersonaje() {
        // TODO
    }
    
    public void eliminarPersonaje(Personaje p) {
        // TODO
    }
    
    private void actualizarPersonajes() {
        // TODO a esto se le llamará cuando haya un cambio en la BD para que
        // actualice la lista de personajes del usuario
    }
    
}
