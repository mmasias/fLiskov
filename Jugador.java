public class Jugador {
    private int x;
    private int y;
    private MedioTransporte medioTransporte;
    private double velocidadBase;

    public Jugador(int x, int y) {
        this.x = x;
        this.y = y;
        this.medioTransporte = MedioTransporte.PIE;
        this.velocidadBase = 1.0;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public char getAvatar() {
        char[] avatar = { '@', 'H', 'B', 'A' };
        return avatar[medioTransporte.ordinal()];
    }

    public MedioTransporte getMedioTransporte() {
        return medioTransporte;
    }

    public double getVelocidadBase() {
        return velocidadBase;
    }

    public void cambiarMedioTransporte(MedioTransporte nuevoMedio) {
        this.medioTransporte = nuevoMedio;
        switch (nuevoMedio) {
            case PIE -> velocidadBase = 1.0;
            case CABALLO -> velocidadBase = 1.5;
            case BOTE -> velocidadBase = 1.2;
            case ALFOMBRA_VOLADORA -> velocidadBase = 2.0;
        }
    }

    public void mover(int nuevaX, int nuevaY, double velocidad) {
        this.x = nuevaX;
        this.y = nuevaY;
        System.out.println("Jugador se mueve a posición (" + x + ", " + y + ") con velocidad " + velocidad);
    }
}