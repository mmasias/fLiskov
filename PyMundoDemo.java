public class PyMundoDemo {
    public static void main(String[] args) {

        TerrenosEstandar.inicializar();
        TerrenosEspeciales.inicializar();
        RegistroTerrenosExtendido.inicializar();
        
        Console console = new Console();
        Mundo mundo = new Mundo(30, 15);

        mundo.agregarJugador(1, 1);
        boolean jugando = true;
        while (jugando) {
            console.clearScreen();
            mundo.avanzarHora();
            mundo.mostrarMundo();
            switch (console.readChar("Movimiento?")) {
                case 'w' -> mundo.moverJugador(0, -1);
                case 'a' -> mundo.moverJugador(-1, 0);
                case 's' -> mundo.moverJugador(0, 1);
                case 'd' -> mundo.moverJugador(1, 0);
                case 'p' -> mundo.cambiarMedioTransporteJugador(MedioTransporte.PIE);
                case 'h' -> mundo.cambiarMedioTransporteJugador(MedioTransporte.CABALLO);
                case 'b' -> mundo.cambiarMedioTransporteJugador(MedioTransporte.BOTE);
                case 'c' -> mundo.cambiarMedioTransporteJugador(MedioTransporte.ALFOMBRA_VOLADORA);
                case 'q' -> jugando = !jugando;
            }
        }
    }
}