package clases;

import controladora.Tablero;

public class Jugador extends Thread {

    private String nombre;
    private static boolean jugar = true;
    private static boolean termino = false;

    public Jugador(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isJugar() {
        return jugar;
    }

    public void setJugar(boolean jugar) {
        Jugador.jugar = jugar;
    }

    @Override
    public synchronized void run() {
        while (!termino) {
            if (!(Tablero.getPalabraAAdivinar().equals(Tablero.getPalabraAdivinada())) || Tablero.getVidas() > 0) {
                if (this.isJugar()) {
                    this.setJugar(false);
                    char letra = this.pedirLetra();
                    this.verificar(letra);
                } else {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public Character pedirLetra() {
        int num1 = 97;
        int num2 = 122;
        int numAleatorio = (int) Math.floor(Math.random() * (num2 - num1) + num1);
        char letra = (char) numAleatorio;
        return letra;
    }

    private void verificar(Character letra) {
        while (Tablero.getLetraselejidas().contains(letra)) {
            letra = this.pedirLetra();
        }
        if (Tablero.verificar(letra)) {
            System.out.println("El jugador " + this.getNombre() + " encontro " + letra);
            System.out.println("Intentos restantes: " + Tablero.getVidas());
            System.out.println("Letras erradas: " + Tablero.getLetraselejidas());
        } else {
            Tablero.setVidas(Tablero.getVidas() - 1);
            System.out.println("El jugador " + this.getNombre() + " dijo mal la letra " + letra);
            System.out.println("Intentos restantes: " + Tablero.getVidas());
            System.out.println("Letras erradas: " + Tablero.getLetraselejidas());
        }
        if ((Tablero.getPalabraAAdivinar().equals(Tablero.getPalabraAdivinada()))) {
            Tablero.setLetraselejidas(letra);
            System.out.println(this.getNombre() + " encontro la letra '" + letra + "' y adivino la palabra");
            System.out.println("La palabra era: " + Tablero.getPalabraAAdivinar());
            ConectarBD.setGanador(this.getNombre(), Tablero.getPalabra());
            this.setJugar(false);
            this.termino = true;
            this.notifyAll();
        } else {
            Tablero.imprimir();
            Tablero.setLetraselejidas(letra);
            if (Tablero.getVidas() == 0) {
                this.termino = true;
            }
            this.setJugar(true);
            this.notifyAll();
        }
    }
}
