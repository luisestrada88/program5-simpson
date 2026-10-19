/*
 * Gamma.java
 * Programa 5 (PSP2) - Integracion por regla de Simpson
 * Autor: Alejandro
 * Fecha: 2026-10-14
 */

/**
 * Calcula la funcion gamma para multiplos de un medio, que es lo que
 * necesita la distribucion t. Usa las dos identidades del documento 5a:
 * para enteros, gamma(n) = (n - 1)!; para medios enteros se parte de
 * gamma(1/2) = raiz de pi y se aplica gamma(z + 1) = z * gamma(z).
 */
public class Gamma {

    /**
     * Calcula gamma(z) para z entero o medio entero positivo.
     *
     * @param z valor al que se le calcula gamma
     * @return el valor de gamma(z)
     */
    public static double calcular(double z) {
        if (esEntero(z)) {
            return factorial((int) z - 1);
        }

        double resultado = Math.sqrt(Math.PI);
        double actual = 0.5;

        while (actual < z - 0.000000001) {
            resultado = resultado * actual;
            actual = actual + 1;
        }

        return resultado;
    }

    /**
     * Indica si el valor es un numero entero.
     *
     * @param z valor que se revisa
     * @return true si z no tiene parte decimal
     */
    public static boolean esEntero(double z) {
        return Math.abs(z - Math.round(z)) < 0.000000001;
    }

    /**
     * Calcula el factorial de un entero no negativo.
     *
     * @param n numero al que se le calcula el factorial
     * @return el valor de n!
     */
    public static double factorial(int n) {
        double resultado = 1;

        for (int i = 2; i <= n; i++) {
            resultado = resultado * i;
        }

        return resultado;
    }
}
