public abstract class Agua extends Terreno {
    public Agua(char simbolo, String color, double factorVelocidad) {
        super(simbolo, color, true, factorVelocidad);
    }
    
    @Override
    public boolean puedeSerRecorridoPor(MedioTransporte medio) {
        return medio == MedioTransporte.BOTE;
    }
}