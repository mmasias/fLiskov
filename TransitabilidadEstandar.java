import java.util.HashSet;
import java.util.Set;

public class TransitabilidadEstandar implements EstrategiaTransitabilidad {
    private final Set<MedioTransporte> mediosPermitidos;
    
    public TransitabilidadEstandar(Set<MedioTransporte> mediosPermitidos) {
        this.mediosPermitidos = new HashSet<>(mediosPermitidos);
    }
    
    @Override
    public boolean esTransitable() {
        return true;
    }
    
    @Override
    public boolean puedeSerRecorridoPor(MedioTransporte medio) {
        return mediosPermitidos.contains(medio);
    }
}