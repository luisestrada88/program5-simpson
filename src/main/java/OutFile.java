/*
 * OutFile.java
 * Programa 5 (PSP2) - Integracion por regla de Simpson
 * Autor: Alejandro
 * Fecha: 2026-10-14
 * Reutilizada del Programa 3.
 */

import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Escribe un reporte de texto en un archivo, una linea por renglon.
 */
public class OutFile {

    /**
     * Escribe las lineas indicadas en el archivo de salida.
     *
     * @param ruta ruta del archivo que se va a escribir
     * @param lineas lineas que se van a escribir
     */
    public static void escribirArchivo(String ruta, ArrayList<String> lineas) {
        try {
            PrintWriter pw = new PrintWriter(ruta);

            for (int i = 0; i < lineas.size(); i++) {
                pw.println(lineas.get(i));
            }

            pw.close();
        } catch (Exception e) {
            System.out.println("Ocurrio un error al escribir el archivo");
        }
    }
}
