package controladora;

import clases.ConectarBD;
import java.util.ArrayList;
import java.util.List;

public class Tablero {

    private static List<Character> palabraAAdivinar = new ArrayList();
    private static List<Character> palabraAdivinada = new ArrayList();
    private static List<Character> letraselejidas = new ArrayList();
    private static String palabra = null;
    private static int vidas = 0;

    public Tablero() {

    }

    public static List<Character> getPalabraAAdivinar() {
        return palabraAAdivinar;
    }

    public static List<Character> getPalabraAdivinada() {
        return palabraAdivinada;
    }

    public static String getPalabra() {
        return palabra;
    }

    public static int getVidas() {
        return vidas;
    }

    public static void setVidas(int vidas) {
        Tablero.vidas = vidas;
    }

    public static List<Character> getLetraselejidas() {
        return letraselejidas;
    }

    public static void setLetraselejidas(Character letra) {
        letraselejidas.add(letra);
    }

    public static void iniciarjuego() {
        palabra = ConectarBD.palabra();
        char[] aCaracteres = palabra.toCharArray();
        for (int x = 0; x < aCaracteres.length; x++) {
            palabraAAdivinar.add(aCaracteres[x]);
        }
        vidas = (palabraAAdivinar.size()) * 2;
        limpiar();
    }

    private static void limpiar() {
        for (int i = 0; i < palabraAAdivinar.size(); i++) {
            palabraAdivinada.add(' ');
        }
    }

    public static void imprimir() {
        System.out.println("----------- LETRAS ENCONTRADAS -----------");
        for (int i = 0; i < palabraAdivinada.size(); i++) {
            if (palabraAdivinada.get(i).equals(' ')) {
                System.out.print("-");
            } else {
                System.out.print(palabraAdivinada.get(i));
            }

        }
        System.out.println("");
    }

    public static boolean verificar(Character letra) {
        boolean encontro = false;
        for (int i = 0; i < palabraAAdivinar.size(); i++) {
            if (palabraAAdivinar.get(i).equals(letra)) {
                palabraAdivinada.set(i, letra);
                encontro = true;
            }
        }
        return encontro;
    }

    public static int getCantidadElementos() {
        return palabraAAdivinar.size();
    }

    public static boolean verificarGanador() {
        boolean valor = true;
        for (int i = 0; i < palabraAdivinada.size(); i++) {
            if (palabraAdivinada.get(i).equals(' ')) {
                valor = false;
            }
        }
        return valor;
    }

}
