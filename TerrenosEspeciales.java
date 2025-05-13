import java.util.HashSet;
import java.util.Set;

public class TerrenosEspeciales {
    public static void inicializar() {
        
        RegistroTerrenos.registrarTerreno("AGUAS_PUTRIDAS", () -> {
            Set<MedioTransporte> medios = new HashSet<>();
            medios.add(MedioTransporte.BOTE);
            return new Terreno('~', "VERDE_PANTANO", 0.4, new TransitabilidadAleatoria(medios, 0.5));
        });

        RegistroTerrenos.registrarTerreno("AGUAS_RAPIDAS", () -> {
            Set<MedioTransporte> medios = new HashSet<>();
            medios.add(MedioTransporte.PIE);
            medios.add(MedioTransporte.CABALLO);
            medios.add(MedioTransporte.BOTE);
            medios.add(MedioTransporte.ALFOMBRA_VOLADORA);
            return new Terreno('≋', "VIOLETA", 1.5, new TransitabilidadEstandar(medios));
        });
    }
}
