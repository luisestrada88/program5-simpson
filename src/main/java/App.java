/*
 * App.java
 * Programa 5 (PSP2) - Integracion por la regla de Simpson
 * Autor: Alejandro
 * Fecha: 2026-10-19
 */

/**
 * Punto de entrada del Programa 5. Corre los tres casos de la Tabla 1
 * del documento 5a, o solo uno si recibe su numero como parametro.
 */
public class App {

    /** Valores de x de los tres casos de la Tabla 1. */
    public static final double[] VALORES_X = {1.1, 1.1812, 2.750};

    /** Grados de libertad de los tres casos de la Tabla 1. */
    public static final int[] VALORES_DOF = {9, 10, 30};

    /** Numero de casos de prueba del documento. */
    public static final int TOTAL_PRUEBAS = 3;

    /**
     * Ejecuta la prueba indicada por parametro, o las tres si no se
     * recibe ninguno.
     *
     * @param args numero de prueba a ejecutar (1 a 3), opcional
     */
    public static void main(String[] args) {
        String reporte = encabezado();

        if (args.length == 0) {
            for (int i = 1; i <= TOTAL_PRUEBAS; i++) {
                reporte = reporte + ejecutarPrueba(i) + "\n";
            }
        } else {
            reporte = reporte
                    + ejecutarPrueba(Integer.parseInt(args[0])) + "\n";
        }

        System.out.print(reporte);

        Output salida = new Output();
        salida.writeData(Logic.RUTA_SALIDA, reporte);
    }

    /**
     * @return el encabezado del reporte
     */
    public static String encabezado() {
        return "INTEGRACION NUMERICA - REGLA DE SIMPSON\n"
                + "Distribucion t\n\n"
                + String.format("%-8s %-10s %-6s %-12s %-10s",
                        "Prueba", "x", "dof", "p", "segmentos")
                + "\n"
                + "--------------------------------------------------\n";
    }

    /**
     * Ejecuta uno de los casos de prueba de la Tabla 1.
     *
     * @param numero numero de prueba, de 1 a 3
     * @return el renglon del reporte con el resultado
     */
    public static String ejecutarPrueba(int numero) {
        if (numero < 1 || numero > TOTAL_PRUEBAS) {
            return "Prueba invalida: " + numero
                    + ". Use un numero de 1 a 3.";
        }

        Logic logica = new Logic(VALORES_X[numero - 1],
                VALORES_DOF[numero - 1]);
        logica.logic1a();

        return logica.reportar(numero);
    }
}
