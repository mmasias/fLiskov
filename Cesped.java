public abstract class Cesped extends Terreno {
    public Cesped(char simbolo, String color, boolean transitable, double factorVelocidad) {
        super(simbolo, color, transitable, factorVelocidad);
    }
    
    @Override
    public boolean puedeSerRecorridoPor(MedioTransporte medio) {
        return medio == MedioTransporte.PIE || medio == MedioTransporte.CABALLO || medio == MedioTransporte.ALFOMBRA_VOLADORA;
    }
}