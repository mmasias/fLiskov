public abstract class Terreno {
    protected char simbolo;
    protected String color;
    protected boolean transitable;
    protected double factorVelocidad;
    
    public Terreno(char simbolo, String color, boolean transitable, double factorVelocidad) {
        this.simbolo = simbolo;
        this.color = color;
        this.transitable = transitable;
        this.factorVelocidad = factorVelocidad;
    }
    
    public boolean esTransitable() {
        return transitable;
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
    
    public abstract boolean puedeSerRecorridoPor(MedioTransporte medio);
}
