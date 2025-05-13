import java.util.HashSet;
import java.util.Set;

public class TerrenoFactory {
    
    public static Terreno crearSuelo() {
        Set<MedioTransporte> mediosPermitidos = new HashSet<>();
        mediosPermitidos.add(MedioTransporte.PIE);
        mediosPermitidos.add(MedioTransporte.CABALLO);
        
        return new Terreno('.', "MARRON", 1.0, new TransitabilidadEstandar(mediosPermitidos));
    }
    
    public static Terreno crearParedes() {
        Set<MedioTransporte> mediosPermitidos = new HashSet<>();
        
        return new Terreno('#', "GRIS", 0.0, new TransitabilidadEstandar(mediosPermitidos)); // Conjunto vacío = no transitable
    }
    
    public static Terreno crearCespedBajo() {
        Set<MedioTransporte> mediosPermitidos = new HashSet<>();
        mediosPermitidos.add(MedioTransporte.PIE);
        mediosPermitidos.add(MedioTransporte.CABALLO);
        
        return new Terreno(',', "VERDE_CLARO", 1.0, new TransitabilidadEstandar(mediosPermitidos));
    }
    
    public static Terreno crearCespedMedio() {
        Set<MedioTransporte> mediosPermitidos = new HashSet<>();
        mediosPermitidos.add(MedioTransporte.PIE);
        mediosPermitidos.add(MedioTransporte.CABALLO);
        
        return new Terreno(';', "VERDE", 0.5, new TransitabilidadEstandar(mediosPermitidos));
    }
    
    public static Terreno crearCespedAlto() {
        Set<MedioTransporte> mediosPermitidos = new HashSet<>();
        mediosPermitidos.add(MedioTransporte.CABALLO);
        
        return new Terreno('w', "VERDE_OSCURO", 0.5, new TransitabilidadEstandar(mediosPermitidos));
    }
    
    public static Terreno crearAguasNormales() {
        Set<MedioTransporte> mediosPermitidos = new HashSet<>();
        mediosPermitidos.add(MedioTransporte.BOTE);
        
        return new Terreno('~', "AZUL", 1.0, new TransitabilidadEstandar(mediosPermitidos));
    }
    
    public static Terreno crearAguasTurbulentas() {
        Set<MedioTransporte> mediosPermitidos = new HashSet<>();
        mediosPermitidos.add(MedioTransporte.BOTE);
        
        return new Terreno('≈', "AZUL_OSCURO", 0.5, new TransitabilidadEstandar(mediosPermitidos));
    }
       
    public static Terreno crearAguasPutridas() {
        Set<MedioTransporte> mediosPermitidos = new HashSet<>();
        mediosPermitidos.add(MedioTransporte.BOTE);
        
        return new Terreno('~', "VERDE_PANTANO", 0.4, new TransitabilidadAleatoria(mediosPermitidos, 0.5));
    }
    
    public static Terreno crearAguasRapidas() {
        Set<MedioTransporte> mediosPermitidos = new HashSet<>();

        mediosPermitidos.add(MedioTransporte.PIE);
        mediosPermitidos.add(MedioTransporte.CABALLO);
        mediosPermitidos.add(MedioTransporte.BOTE);
        mediosPermitidos.add(MedioTransporte.ALFOMBRA_VOLADORA);
        
        return new Terreno('≋', "VIOLETA", 1.5, new TransitabilidadEstandar(mediosPermitidos));
    }
    
    public static Terreno crearMontanas() {
        Set<MedioTransporte> mediosPermitidos = new HashSet<>();
        mediosPermitidos.add(MedioTransporte.ALFOMBRA_VOLADORA);
        
        return new Terreno('^', "MARRON_OSCURO", 1.0, new TransitabilidadEstandar(mediosPermitidos));
    }
}