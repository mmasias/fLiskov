public class AguasRapidas extends AguasNormales {
    
    public AguasRapidas() {
        super('≋', "VIOLETA", 1.5);
    }
    
    @Override
    public boolean puedeSerRecorridoPor(MedioTransporte medio) {
        return true;
    }
    
    @Override
    public double obtenerFactorVelocidad() {
        return 1.5;
    }
}