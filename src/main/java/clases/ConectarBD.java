package clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class ConectarBD {

    public static void setGanador(String nombre, String palabra) {
        try {

            String query = "INSERT INTO ganadores (fecha,nombre,palabraganadora) values (now(),'" + nombre + "','" + palabra + "')";
            Statement miStatement = conectarbd();
            miStatement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static int countpalabras() {
        int count = 0;
        try {
            Statement miStatement = conectarbd();
            ResultSet rs = miStatement.executeQuery("SELECT count(*) as cantidad FROM palabras");
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("No se pudieron saber cuantas palabras hay en la BD");
        }
        return count;
    }

    public static String palabra() {
        Random random = new Random();
        String palabra = null;
        int max = countpalabras();
        try {
            Statement miStatement = conectarbd();
            int randomNumber = random.nextInt(max - 1 + 1 - 0) + 0;
            ResultSet rs = miStatement.executeQuery("SELECT palabra FROM palabras LIMIT " + randomNumber + ", 1");
            while (rs.next()) {
                palabra = rs.getString(1);
            }
        } catch (SQLException e) {
            System.out.println("No se pudo seleccionar la palabra");
        }
        return palabra;
    }

    private static Statement conectarbd() {
        Connection miConexion;
        Statement miStatement = null;
        try {
            //Creo la conexion con la base de datos
            miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/ahorcado", "root", "");
            //Creo el statement
            miStatement = miConexion.createStatement();
        } catch (SQLException ex) {
            //De no conectar tira un error
            System.out.println("No conecta");
        }
        //Retorno el statement
        return miStatement;
    }

}
