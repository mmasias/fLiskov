import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RegistroTerrenos {
    private static final Map<String, Proveedor<Terreno>> proveedores = new HashMap<>();
    
    @FunctionalInterface
    public interface Proveedor<T> {
        T crear();
    }

    public static void registrarTerreno(String nombre, Proveedor<Terreno> proveedor) {
        proveedores.put(nombre, proveedor);
    }
    
    public static Terreno crearTerreno(String nombre) {
        Proveedor<Terreno> proveedor = proveedores.get(nombre);
        if (proveedor == null) {
            throw new IllegalArgumentException("Tipo de terreno no registrado: " + nombre);
        }
        return proveedor.crear();
    }
    
    public static Set<String> getTiposRegistrados() {
        return new HashSet<>(proveedores.keySet());
    }    
}