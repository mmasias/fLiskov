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
                mapa[y][x] = RegistroTerrenos.crearTerreno("SUELO");
            }
        }

        for (int x = 0; x < ancho; x++) {
            mapa[alto / 2 - 1][x] = RegistroTerrenos.crearTerreno("AGUAS_NORMALES");
            mapa[alto / 2 - 0][x] = RegistroTerrenos.crearTerreno("AGUAS_NORMALES");
            mapa[alto / 2 + 1][x] = RegistroTerrenos.crearTerreno("AGUAS_NORMALES");
        }

        mapa[alto / 2 - 1][3] = RegistroTerrenos.crearTerreno("AGUAS_PUTRIDAS");        mapa[alto / 2 - 1][4] = RegistroTerrenos.crearTerreno("AGUAS_PUTRIDAS");        mapa[alto / 2 - 1][5] = RegistroTerrenos.crearTerreno("AGUAS_TURBULENTAS");        mapa[alto / 2 - 1][6] = RegistroTerrenos.crearTerreno("AGUAS_TURBULENTAS");  mapa[alto / 2 - 1][7] = RegistroTerrenos.crearTerreno("AGUAS_RAPIDAS"); mapa[alto / 2 - 1][8] = RegistroTerrenos.crearTerreno("AGUAS_RAPIDAS"); mapa[alto / 2 - 1][9] = RegistroTerrenos.crearTerreno("AGUAS_RAPIDAS");
        mapa[alto / 2 - 0][3] = RegistroTerrenos.crearTerreno("AGUAS_PUTRIDAS");        mapa[alto / 2 - 0][4] = RegistroTerrenos.crearTerreno("AGUAS_PUTRIDAS");        mapa[alto / 2 - 0][5] = RegistroTerrenos.crearTerreno("AGUAS_TURBULENTAS");        mapa[alto / 2 - 0][6] = RegistroTerrenos.crearTerreno("AGUAS_TURBULENTAS");  mapa[alto / 2 - 0][7] = RegistroTerrenos.crearTerreno("AGUAS_RAPIDAS"); mapa[alto / 2 - 0][8] = RegistroTerrenos.crearTerreno("AGUAS_RAPIDAS"); mapa[alto / 2 - 0][9] = RegistroTerrenos.crearTerreno("AGUAS_RAPIDAS");
        mapa[alto / 2 + 1][3] = RegistroTerrenos.crearTerreno("AGUAS_PUTRIDAS");        mapa[alto / 2 + 1][4] = RegistroTerrenos.crearTerreno("AGUAS_PUTRIDAS");        mapa[alto / 2 + 1][5] = RegistroTerrenos.crearTerreno("AGUAS_TURBULENTAS");        mapa[alto / 2 + 1][6] = RegistroTerrenos.crearTerreno("AGUAS_TURBULENTAS");  mapa[alto / 2 + 1][7] = RegistroTerrenos.crearTerreno("AGUAS_RAPIDAS"); mapa[alto / 2 + 1][8] = RegistroTerrenos.crearTerreno("AGUAS_RAPIDAS"); mapa[alto / 2 + 1][9] = RegistroTerrenos.crearTerreno("AGUAS_RAPIDAS");

        for (int x = 2; x < ancho; x++) {
            mapa[2][x] = RegistroTerrenos.crearTerreno("MONTANAS");
        }

        for (int y = alto - 3; y < alto; y++) {
            for (int x = 0; x < ancho; x++) {
                if (x % 3 == 0)
                    mapa[y][x] = RegistroTerrenos.crearTerreno("CESPED_BAJO");
                else if (x % 3 == 1)
                    mapa[y][x] = RegistroTerrenos.crearTerreno("CESPED_MEDIO");
                else
                    mapa[y][x] = RegistroTerrenos.crearTerreno("CESPED_ALTO");
            }
        }

        mapa[0][0] = RegistroTerrenos.crearTerreno("PAREDES");
        mapa[0][1] = RegistroTerrenos.crearTerreno("PAREDES");
        mapa[0][2] = RegistroTerrenos.crearTerreno("PAREDES");
        mapa[0][3] = RegistroTerrenos.crearTerreno("PAREDES");
        mapa[1][0] = RegistroTerrenos.crearTerreno("PAREDES");
        mapa[1][3] = RegistroTerrenos.crearTerreno("PAREDES");

        mapa[2][2] = RegistroTerrenos.crearTerreno("LAVA");
        mapa[2][3] = RegistroTerrenos.crearTerreno("LAVA");
        
        for (int x = 2; x < 5; x++) {
            for (int y = alto-5; y < alto-3; y++) {
                mapa[y][x] = RegistroTerrenos.crearTerreno("PANTANO");
            }
        }         
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