/*
 * GammaFunction.java
 * Programa 5 (PSP2) - Integracion por la regla de Simpson
 * Autor: Alejandro
 * Fecha: 2026-10-19
 */

/**
 * Calcula la funcion gamma segun el documento 5a. Para valores enteros
 * usa gamma(n) = (n - 1)!; para medios enteros parte de
 * gamma(1/2) = raiz de pi y aplica gamma(z + 1) = z * gamma(z).
 */
public class GammaFunction {

    /** Tolerancia para comparar numeros reales. */
    public static final double TOLERANCIA = 0.000000001;

    private double gammaValue;

    /**
     * Calcula gamma de un valor entero.
     *
     * @param intValue valor entero al que se le calcula gamma
     * @return el valor de gamma(intValue)
     */
    public double computeIntGamma(int intValue) {
        gammaValue = 1;

        for (int i = 2; i <= intValue - 1; i++) {
            gammaValue = gammaValue * i;
        }

        return gammaValue;
    }

    /**
     * Calcula gamma de un medio entero.
     *
     * @param doubleValue valor medio entero al que se le calcula gamma
     * @return el valor de gamma(doubleValue)
     */
    public double computeDblGamma(double doubleValue) {
        gammaValue = Math.sqrt(Math.PI);
        double actual = 0.5;

        while (actual < doubleValue - TOLERANCIA) {
            gammaValue = gammaValue * actual;
            actual = actual + 1;
        }

        return gammaValue;
    }

    /**
     * Calcula gamma decidiendo si el valor es entero o medio entero.
     *
     * @param value valor al que se le calcula gamma
     * @return el valor de gamma(value)
     */
    public double computeGamma(double value) {
        if (Math.abs(value - Math.round(value)) < TOLERANCIA) {
            return computeIntGamma((int) Math.round(value));
        }

        return computeDblGamma(value);
    }

    /**
     * @return el ultimo valor de gamma calculado
     */
    public double getGammaValue() {
        return gammaValue;
    }
}
