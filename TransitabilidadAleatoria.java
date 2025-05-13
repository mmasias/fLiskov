import java.util.HashSet;
import java.util.Set;

public class TransitabilidadAleatoria implements EstrategiaTransitabilidad {
    private final Set<MedioTransporte> mediosPermitidos;
    private final boolean esTransitable;
    
    public TransitabilidadAleatoria(Set<MedioTransporte> mediosPermitidos, double probabilidadTransitable) {
        this.mediosPermitidos = new HashSet<>(mediosPermitidos);
        this.esTransitable = Math.random() < probabilidadTransitable;
    }
    
    @Override
    public boolean esTransitable() {
        return esTransitable;
    }
    
    @Override
    public boolean puedeSerRecorridoPor(MedioTransporte medio) {
        return esTransitable && mediosPermitidos.contains(medio);
    }
}