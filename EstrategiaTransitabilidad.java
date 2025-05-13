public interface EstrategiaTransitabilidad {
    boolean esTransitable();
    boolean puedeSerRecorridoPor(MedioTransporte medio);
}