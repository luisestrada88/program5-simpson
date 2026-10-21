/*
 * Main.java
 * Programa 5 (PSP2) - Integracion por regla de Simpson
 * Autor: Alejandro
 * Fecha: 2026-10-14
 */

import java.util.ArrayList;
import java.util.Locale;

/**
 * Punto de entrada del Programa 5. Integra la distribucion t con la
 * regla de Simpson para los casos de la Tabla 1 del documento 5a.
 * Ejecuta una prueba a la vez cuando recibe su numero como parametro,
 * o las tres si no recibe ninguno.
 */
public class Main {

    /** Ruta del archivo con los casos de prueba. */
    public static final String RUTA = "data/in.txt";

    /** Numero de casos de prueba del documento. */
    public static final int TOTAL_PRUEBAS = 3;

    /**
     * Ejecuta la prueba indicada por parametro, o las tres si no se
     * recibe ninguno.
     *
     * @param args numero de prueba a ejecutar (1 a 3), opcional
     */
    public static void main(String[] args) {
        ArrayList<String> reporte = new ArrayList<String>();

        reporte.add("INTEGRACION NUMERICA - REGLA DE SIMPSON");
        reporte.add("Distribucion t   Datos: " + RUTA);
        reporte.add("");
        reporte.add(encabezado());
        reporte.add("--------------------------------------------------");

        if (args.length == 0) {
            for (int i = 1; i <= TOTAL_PRUEBAS; i++) {
                reporte.add(ejecutarPrueba(i));
            }
        } else {
            reporte.add(ejecutarPrueba(Integer.parseInt(args[0])));
        }

        for (int i = 0; i < reporte.size(); i++) {
            System.out.println(reporte.get(i));
        }

        OutFile.escribirArchivo("data/out.txt", reporte);
    }

    /**
     * @return el encabezado de la tabla de resultados
     */
    public static String encabezado() {
        return String.format("%-8s %-10s %-6s %-12s %-10s",
                "Prueba", "x", "dof", "p", "segmentos");
    }

    /**
     * Ejecuta uno de los casos de prueba del documento 5a.
     *
     * @param numero numero de prueba, de 1 a 3
     * @return el renglon del reporte con el resultado
     */
    public static String ejecutarPrueba(int numero) {
        if (numero < 1 || numero > TOTAL_PRUEBAS) {
            return "Prueba invalida: " + numero + ". Use un numero de 1 a 3.";
        }

        ListaEnlazada casos = ReadFile.leerArchivo(RUTA, 0, 1);
        Nodo caso = casos.getCabeza();

        for (int i = 1; i < numero; i++) {
            caso = caso.getSiguiente();
        }

        double x = caso.getX();
        double dof = caso.getY();

        return String.format(Locale.US, "%-8s %-10.4f %-6.0f %-12.8f %-10d",
                "Prueba " + numero, x, dof,
                Simpson.calcularP(x, dof),
                Simpson.segmentosUsados(x, dof));
    }
}
