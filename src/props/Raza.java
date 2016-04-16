package props;

/**
 * Enumeración que define la raza que puede tener cada personaje.
 *
 * @author mor
 * @version 130416
 */
public enum Raza {
    
    ELFO("elfo"),
    TROLL("orco"),
    ORCO("trol"), 
    HUMANO("humano"), 
    DEMONIO("demonio"), 
    TEMMIE("tEMMIE!");
    
    private String nombre;
    
    private Raza() { }
    private Raza(String n) {
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
