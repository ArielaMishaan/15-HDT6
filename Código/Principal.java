import java.util.ArrayList;

/*
 * Ariela Mishaan (22052)
 * Algoritmos y Estructuras de Datos Sección 40
 * Hoja de Trabajo 6
 * 06-03-2023
 * Clase Principal: interactúa con el usuario.
 */

public class Principal{
    public static void main(String[] args) {

        Archivo archivo = new Archivo("./ListadoProducto.txt");
        ArrayList<String> lineasDatos = archivo.leerArchivo();
        
    }
}