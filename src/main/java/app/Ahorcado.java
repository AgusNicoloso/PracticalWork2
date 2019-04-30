package app;

import clases.Jugador;
import controladora.Tablero;

public class Ahorcado {

    public static void main(String[] args) {
        Thread p1 = new Jugador("Hilo1");
        Thread p2 = new Jugador("Hilo2");
        Tablero.iniciarjuego();
        p1.start();
        p2.start();
    }

}
