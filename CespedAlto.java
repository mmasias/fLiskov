public class CespedAlto extends Cesped {
    public CespedAlto() {
        super('w', "VERDE_OSCURO", true, 0.5);
    }
    
    @Override
    public boolean puedeSerRecorridoPor(MedioTransporte medio) {
        return medio == MedioTransporte.CABALLO;
    }
}