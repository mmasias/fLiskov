public class Mundo {
    private Terreno[][] mapa;
    private Jugador jugador;
    private int ancho;
    private int alto;
    private int horaDelDia;

    public Mundo(int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;
        this.mapa = new Terreno[alto][ancho];
        this.horaDelDia = 12;
        inicializarMapa();
    }

    private void inicializarMapa() {

        for (int y = 0; y < alto; y++) {
            for (int x = 0; x < ancho; x++) {
                mapa[y][x] = new Suelo();
            }
        }

        for (int x = 0; x < ancho; x++) {
            mapa[alto / 2 - 1][x] = new AguasNormales();
            mapa[alto / 2][x] = new AguasNormales();
            mapa[alto / 2 + 1][x] = new AguasNormales();
        }

        mapa[alto / 2 - 1][3] = new AguasPutridas();        mapa[alto / 2 - 1][4] = new AguasPutridas();        mapa[alto / 2 - 1][5] = new AguasTurbulentas();        mapa[alto / 2 - 1][6] = new AguasTurbulentas();
        mapa[alto / 2 - 0][3] = new AguasPutridas();        mapa[alto / 2 - 0][4] = new AguasPutridas();        mapa[alto / 2 - 0][5] = new AguasTurbulentas();        mapa[alto / 2 - 0][6] = new AguasTurbulentas();
        mapa[alto / 2 + 1][3] = new AguasPutridas();        mapa[alto / 2 + 1][4] = new AguasPutridas();        mapa[alto / 2 + 1][5] = new AguasTurbulentas();        mapa[alto / 2 + 1][6] = new AguasTurbulentas();

        for (int x = 2; x < ancho; x++) {
            mapa[2][x] = new Montanas();
        }

        for (int y = alto - 3; y < alto; y++) {
            for (int x = 0; x < ancho; x++) {
                if (x % 3 == 0)
                    mapa[y][x] = new CespedBajo();
                else if (x % 3 == 1)
                    mapa[y][x] = new CespedMedio();
                else
                    mapa[y][x] = new CespedAlto();
            }
        }

        mapa[0][0] = new Paredes();
        mapa[0][1] = new Paredes();
        mapa[0][2] = new Paredes();
        mapa[0][3] = new Paredes();
        mapa[1][0] = new Paredes();
        mapa[1][3] = new Paredes();
    }

    public void agregarJugador(int x, int y) {
        this.jugador = new Jugador(x, y);
    }

    public void moverJugador(int dx, int dy) {
        int nuevaX = jugador.getX() + dx;
        int nuevaY = jugador.getY() + dy;

        if (nuevaX < 0 || nuevaX >= ancho || nuevaY < 0 || nuevaY >= alto) {
            System.out.println("No puedes moverte fuera de los límites del mundo.");
        } else {
            Terreno terrenoDestino = mapa[nuevaY][nuevaX];

            if (terrenoDestino.esTransitable() && terrenoDestino.puedeSerRecorridoPor(jugador.getMedioTransporte())) {
                double velocidad = terrenoDestino.obtenerFactorVelocidad() * jugador.getVelocidadBase();
                jugador.mover(nuevaX, nuevaY, velocidad);
            } else {
                if (!terrenoDestino.esTransitable()) {
                    System.out.println("El terreno en (" + nuevaX + ", " + nuevaY + ") no es transitable.");
                } else {
                    System.out.println("No puedes moverte a ese terreno con tu medio de transporte actual ("
                            + jugador.getMedioTransporte() + ").");
                }
            }
        }
    }

    public void mostrarMundo() {
        System.out.println("Mundo (Hora: " + horaDelDia + ":00)");
        System.out.println("Jugador en posición (" + jugador.getX() + ", " + jugador.getY() + ") con transporte: " + jugador.getMedioTransporte());

        for (int y = 0; y < alto; y++) {
            for (int x = 0; x < ancho; x++) {
                if (x == jugador.getX() && y == jugador.getY()) {
                    System.out.print(jugador.getAvatar());
                } else {
                    System.out.print(mapa[y][x].getSimbolo());
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public void avanzarHora() {
        horaDelDia = (horaDelDia + 1) % 24;
        System.out.println("La hora avanza. Ahora son las " + horaDelDia + ":00");
    }

    public void cambiarMedioTransporteJugador(MedioTransporte medio) {
        jugador.cambiarMedioTransporte(medio);
        System.out.println("Jugador ahora se mueve en: " + medio);
    }
}