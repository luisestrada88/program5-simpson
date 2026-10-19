/*
 * DistribucionT.java
 * Programa 5 (PSP2) - Integracion por regla de Simpson
 * Autor: Alejandro
 * Fecha: 2026-10-14
 */

/**
 * Funcion de densidad de la distribucion t de Student. Es la funcion
 * que se integra con la regla de Simpson, segun el documento 5a.
 */
public class DistribucionT {

    /**
     * Evalua la densidad de la distribucion t en el punto indicado.
     *
     * @param x punto donde se evalua la funcion
     * @param dof grados de libertad
     * @return el valor de la funcion en x
     */
    public static double evaluar(double x, double dof) {
        double numerador = Gamma.calcular((dof + 1) / 2);
        double denominador = Math.sqrt(dof * Math.PI)
                * Gamma.calcular(dof / 2);
        double base = 1 + ((x * x) / dof);
        double exponente = -(dof + 1) / 2;

        return (numerador / denominador) * Math.pow(base, exponente);
    }
}
