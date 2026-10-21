/*
 * ReadFile.java
 * Programa 5 (PSP2) - Integracion por regla de Simpson
 * Autor: Alejandro
 * Fecha: 2026-10-14
 * Reutilizada del Programa 3.
 * Reutilizada de los programas 1 y 2: ahora arma pares en la lista.
 */

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Lee el archivo de datos historicos y carga dos de sus columnas en
 * una lista enlazada de pares.
 */
public class ReadFile {

    /**
     * Lee el archivo y devuelve los pares formados por las columnas
     * indicadas. Las columnas se numeran desde 0.
     *
     * @param ruta ruta del archivo que se va a leer
     * @param columnaX numero de columna que se usara como x
     * @param columnaY numero de columna que se usara como y
     * @return lista con los pares leidos; vacia si ocurre un error
     */
    public static ListaEnlazada leerArchivo(String ruta, int columnaX,
            int columnaY) {
        ListaEnlazada lista = new ListaEnlazada();

        try {
            BufferedReader br = new BufferedReader(new FileReader(ruta));
            String linea = "";

            while ((linea = br.readLine()) != null) {
                String limpia = linea.trim();

                if (limpia.equals("") == false) {
                    String[] datos = limpia.split("\\s+");
                    double x = Double.parseDouble(datos[columnaX]);
                    double y = Double.parseDouble(datos[columnaY]);
                    lista.agregar(x, y);
                }
            }

            br.close();
        } catch (Exception e) {
            System.out.println("Ocurrio un error al leer el archivo: " + ruta);
        }

        return lista;
    }
}
