/*
 * Output.java
 * Programa 5 (PSP2) - Integracion por la regla de Simpson
 * Autor: Alejandro
 * Fecha: 2026-10-19
 */

import java.io.PrintWriter;

/**
 * Escribe el reporte de resultados en un archivo de texto.
 * En el diagrama de clases del 5a esta clase aparece como "output";
 * aqui se escribe con mayuscula inicial para cumplir el estandar de
 * codificacion de Oracle, que pide ese estilo en los nombres de clase.
 */
public class Output {

    /**
     * Escribe el texto indicado en el archivo de salida.
     *
     * @param outFile ruta del archivo que se va a escribir
     * @param outText texto completo del reporte
     */
    public void writeData(String outFile, String outText) {
        try {
            PrintWriter pw = new PrintWriter(outFile);
            pw.print(outText);
            pw.close();
        } catch (Exception e) {
            System.out.println("Ocurrio un error al escribir el archivo");
        }
    }
}
