public class Terreno {
    private final char simbolo;
    private final String color;
    private final double factorVelocidad;
    private final EstrategiaTransitabilidad estrategiaTransitabilidad;
    
    public Terreno(char simbolo, String color, double factorVelocidad, 
                  EstrategiaTransitabilidad estrategiaTransitabilidad) {
        this.simbolo = simbolo;
        this.color = color;
        this.factorVelocidad = factorVelocidad;
        this.estrategiaTransitabilidad = estrategiaTransitabilidad;
    }
    
    public boolean esTransitable() {
        return estrategiaTransitabilidad.esTransitable();
    }
    
    public boolean puedeSerRecorridoPor(MedioTransporte medio) {
        return estrategiaTransitabilidad.puedeSerRecorridoPor(medio);
    }
    
    public double obtenerFactorVelocidad() {
        return factorVelocidad;
    }
    
    public char getSimbolo() {
        return simbolo;
    }
    
    public String getColor() {
        return color;
    }
}