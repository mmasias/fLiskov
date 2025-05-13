import java.util.HashSet;
import java.util.Set;

public class RegistroTerrenosExtendido {
    public static void inicializar() {
        RegistroTerrenos.registrarTerreno("LAVA", () -> {
            Set<MedioTransporte> medios = new HashSet<>();
            medios.add(MedioTransporte.ALFOMBRA_VOLADORA);
            return new Terreno('&', "ROJO", 0.3, new TransitabilidadEstandar(medios));
        });
        
        RegistroTerrenos.registrarTerreno("PANTANO", () -> {
            Set<MedioTransporte> medios = new HashSet<>();
            medios.add(MedioTransporte.PIE);
            return new Terreno('%', "VERDE_MARRON", 0.2, new TransitabilidadEstandar(medios));
        });
    }
}
