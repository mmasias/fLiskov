import java.util.HashSet;
import java.util.Set;

public class TerrenosEstandar {
    public static void inicializar() {

        RegistroTerrenos.registrarTerreno("SUELO", () -> {
            Set<MedioTransporte> medios = new HashSet<>();
            medios.add(MedioTransporte.PIE);
            medios.add(MedioTransporte.CABALLO);
            return new Terreno('.', "MARRON", 1.0, new TransitabilidadEstandar(medios));
        });
        
        RegistroTerrenos.registrarTerreno("PAREDES", () -> {
            Set<MedioTransporte> medios = new HashSet<>();
            return new Terreno('#', "GRIS", 0.0, new TransitabilidadEstandar(medios));
        });
        
        RegistroTerrenos.registrarTerreno("CESPED_BAJO", () -> {
            Set<MedioTransporte> medios = new HashSet<>();
            medios.add(MedioTransporte.PIE);
            medios.add(MedioTransporte.CABALLO);
            return new Terreno(',', "VERDE_CLARO", 1.0, new TransitabilidadEstandar(medios));
        });
        
        RegistroTerrenos.registrarTerreno("CESPED_MEDIO", () -> {
            Set<MedioTransporte> medios = new HashSet<>();
            medios.add(MedioTransporte.PIE);
            medios.add(MedioTransporte.CABALLO);
            return new Terreno(';', "VERDE", 0.5, new TransitabilidadEstandar(medios));
        });
        
        RegistroTerrenos.registrarTerreno("CESPED_ALTO", () -> {
            Set<MedioTransporte> medios = new HashSet<>();
            medios.add(MedioTransporte.CABALLO);
            return new Terreno('w', "VERDE_OSCURO", 0.5, new TransitabilidadEstandar(medios));
        });
        
        RegistroTerrenos.registrarTerreno("AGUAS_NORMALES", () -> {
            Set<MedioTransporte> medios = new HashSet<>();
            medios.add(MedioTransporte.BOTE);
            return new Terreno('~', "AZUL", 1.0, new TransitabilidadEstandar(medios));
        });
        
        RegistroTerrenos.registrarTerreno("AGUAS_TURBULENTAS", () -> {
            Set<MedioTransporte> medios = new HashSet<>();
            medios.add(MedioTransporte.BOTE);
            return new Terreno('≈', "AZUL_OSCURO", 0.5, new TransitabilidadEstandar(medios));
        });
        
        RegistroTerrenos.registrarTerreno("MONTANAS", () -> {
            Set<MedioTransporte> medios = new HashSet<>();
            medios.add(MedioTransporte.ALFOMBRA_VOLADORA);
            return new Terreno('^', "MARRON_OSCURO", 1.0, new TransitabilidadEstandar(medios));
        });
    }
}
