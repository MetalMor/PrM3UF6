package props;

import javax.persistence.Entity;

/**
 * Enumeracion que clasifica las posibles habilidades especiales para cada
 * personaje.
 *
 * @author mor
 * @version 130416
 */
public enum Habilidad {
    
    NINGUNA("ninguna"), 
    VELOCIDAD("velocidad extrema"), 
    KAITO("ataque de Kaito");
    
    private String nombre;
    
    private Habilidad() { }
    
    private Habilidad(String n) {
        setNombre(n);
    }
    
    public String getNombre() {
        return nombre;
    }
    
    private void setNombre(String n) {
        nombre = n;
    }
    
    @Override
    public String toString() {
        return getNombre();
    }
    
}