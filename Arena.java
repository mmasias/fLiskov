public class Arena extends Terreno {
    public Arena() {
        super('-', "AMARILLO", true, 1.0);
    }
    
    @Override
    public boolean puedeSerRecorridoPor(MedioTransporte medio) {
        return medio == MedioTransporte.PIE || medio == MedioTransporte.CABALLO;
    }
}