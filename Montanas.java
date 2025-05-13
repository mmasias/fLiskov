public class Montanas extends Terreno {
    public Montanas() {
        super('^', "MARRON_OSCURO", true, 1.0);
    }
    
    @Override
    public boolean puedeSerRecorridoPor(MedioTransporte medio) {
        return medio == MedioTransporte.ALFOMBRA_VOLADORA;
    }
}