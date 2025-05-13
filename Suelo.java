public class Suelo extends Terreno {
    public Suelo() {
        super('.', "MARRON", true, 1.0);
    }
    
    @Override
    public boolean puedeSerRecorridoPor(MedioTransporte medio) {
        return medio == MedioTransporte.PIE || medio == MedioTransporte.CABALLO;
    }
}