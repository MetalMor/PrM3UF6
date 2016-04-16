package props;

/**
 * Enumeracion que contiene los diferentes tipos de medio natural a los que cada
 * personaje está asociado.
 *
 * @author mor
 * @version 130416
 */
public enum Medio {
    
    BOSQUE("bosque"), 
    CUEVA("cueva"), 
    MAR("mar"), 
    HIELO("hielo"), 
    FUEGO("fuego");
    
    private String nombre;
    
    private Medio() { }
    
    private Medio(String n) {
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
