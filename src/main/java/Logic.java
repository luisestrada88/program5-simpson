/*
 * Logic.java
 * Programa 5 (PSP2) - Integracion por la regla de Simpson
 * Autor: Alejandro
 * Fecha: 2026-10-19
 */

import java.util.Locale;

/**
 * Controla el proceso del programa: duplica el numero de segmentos
 * hasta que dos aproximaciones seguidas difieran menos que el error
 * aceptable, y manda escribir el reporte.
 */
public class Logic {

    /** Numero inicial de segmentos; debe ser par. */
    public static final int SEGMENTOS_INICIALES = 10;

    /** Error aceptable entre dos aproximaciones seguidas. */
    public static final double ERROR = 0.00001;

    /** Ruta del archivo de salida. */
    public static final String RUTA_SALIDA = "data/out.txt";

    private int intNumSeg;
    private double dblE;
    private int intDOF;
    private double dblX;
    private double dblFinalValue;

    /**
     * Crea el proceso para un caso de prueba de la Tabla 1.
     *
     * @param dblX limite superior de la integral
     * @param intDOF grados de libertad
     */
    public Logic(double dblX, int intDOF) {
        this.dblX = dblX;
        this.intDOF = intDOF;
        this.dblE = ERROR;
        this.intNumSeg = SEGMENTOS_INICIALES;
    }

    /**
     * Calcula el valor p duplicando los segmentos hasta alcanzar la
     * precision pedida, y guarda cuantos segmentos se necesitaron.
     */
    public void logic1a() {
        SimpsonIntegration simpson =
                new SimpsonIntegration(dblX, intDOF, dblE);
        intNumSeg = SEGMENTOS_INICIALES;
        double anterior = simpson.computeFinalValue(intNumSeg);

        while (true) {
            intNumSeg = intNumSeg * 2;
            double actual = simpson.computeFinalValue(intNumSeg);

            if (Math.abs(actual - anterior) < dblE) {
                dblFinalValue = actual;
                return;
            }

            anterior = actual;
        }
    }

    /**
     * Arma el renglon del reporte con el resultado de este caso.
     *
     * @param numero numero de prueba que se esta reportando
     * @return el renglon formateado
     */
    public String reportar(int numero) {
        return String.format(Locale.US,
                "%-8s %-10.4f %-6d %-12.8f %-10d",
                "Prueba " + numero, dblX, intDOF, dblFinalValue,
                intNumSeg);
    }

    /**
     * @return el valor p calculado
     */
    public double getDblFinalValue() {
        return dblFinalValue;
    }

    /**
     * @return cuantos segmentos se necesitaron
     */
    public int getIntNumSeg() {
        return intNumSeg;
    }

    /**
     * @return el error aceptable configurado
     */
    public double getDblE() {
        return dblE;
    }
}
