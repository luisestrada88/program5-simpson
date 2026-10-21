/*
 * Simpson.java
 * Programa 5 (PSP2) - Integracion por regla de Simpson
 * Autor: Alejandro
 * Fecha: 2026-10-14
 */

/**
 * Integra numericamente la distribucion t con la regla de Simpson,
 * duplicando el numero de segmentos hasta que dos resultados seguidos
 * difieran menos que el error aceptable.
 */
public class Simpson {

    /** Error aceptable entre dos aproximaciones seguidas. */
    public static final double ERROR = 0.00001;

    /** Numero inicial de segmentos; debe ser par. */
    public static final int SEGMENTOS_INICIALES = 10;

    /**
     * Integra la distribucion t desde 0 hasta x con un numero fijo de
     * segmentos.
     *
     * @param x limite superior de la integral
     * @param dof grados de libertad
     * @param segmentos numero de segmentos, debe ser par
     * @return la aproximacion de la integral
     */
    public static double integrar(double x, double dof, int segmentos) {
        double ancho = x / segmentos;
        double suma = DistribucionT.evaluar(0, dof)
                + DistribucionT.evaluar(x, dof);

        for (int i = 1; i < segmentos; i++) {
            double multiplicador = 2;

            if (i % 2 != 0) {
                multiplicador = 4;
            }

            suma = suma + (multiplicador
                    * DistribucionT.evaluar(i * ancho, dof));
        }

        return (suma * ancho) / 3;
    }

    /**
     * Integra duplicando los segmentos hasta alcanzar la precision
     * indicada por ERROR.
     *
     * @param x limite superior de la integral
     * @param dof grados de libertad
     * @return el valor p de la integral
     */
    public static double calcularP(double x, double dof) {
        int segmentos = SEGMENTOS_INICIALES;
        double anterior = integrar(x, dof, segmentos);

        while (true) {
            segmentos = segmentos * 2;
            double actual = integrar(x, dof, segmentos);

            if (Math.abs(actual - anterior) < ERROR) {
                return actual;
            }

            anterior = actual;
        }
    }

    /**
     * Devuelve cuantos segmentos se necesitaron para alcanzar la
     * precision indicada por ERROR.
     *
     * @param x limite superior de la integral
     * @param dof grados de libertad
     * @return numero de segmentos usados en el resultado final
     */
    public static int segmentosUsados(double x, double dof) {
        int segmentos = SEGMENTOS_INICIALES;
        double anterior = integrar(x, dof, segmentos);

        while (true) {
            segmentos = segmentos * 2;
            double actual = integrar(x, dof, segmentos);

            if (Math.abs(actual - anterior) < ERROR) {
                return segmentos;
            }

            anterior = actual;
        }
    }
}
