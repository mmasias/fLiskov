public class AguasPutridas extends Agua {
    private boolean navegable;

    public AguasPutridas() {
        super('~', "VERDE_PANTANO", 0.4);
        this.navegable = Math.random() > 0.5;
    }

    @Override
    public boolean puedeSerRecorridoPor(MedioTransporte medio) {
        return (medio == MedioTransporte.BOTE) ? navegable : false;
    }
}