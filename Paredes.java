public class Paredes extends Terreno {
    public Paredes() {
        super('#', "GRIS", false, 0.0);
    }
    
    @Override
    public boolean puedeSerRecorridoPor(MedioTransporte medio) {
        return false; // Las paredes no son transitables por ningún medio
    }
}