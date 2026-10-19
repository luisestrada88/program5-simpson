/*
 * SimpsonIntegration.java
 * Programa 5 (PSP2) - Integracion por la regla de Simpson
 * Autor: Alejandro
 * Fecha: 2026-10-19
 */

/**
 * Integra la distribucion t de 0 a x con la regla de Simpson. Cada
 * paso del calculo es un metodo, siguiendo el diagrama de clases del
 * documento 5a y las columnas de la Tabla 2.
 */
public class SimpsonIntegration {

    private int intNumSeg;
    private double dblW;
    private double dblE;
    private int intDOF;
    private double dblX;
    private double[] dblTotXi;
    private double[] dblFirstBaseTerms;
    private double dblExponent;
    private double dblCoeff;
    private double[] dblFxi;
    private double[] dblFinalTerms;
    private double dblFinalValue;

    /**
     * Crea la integracion para un caso de prueba.
     *
     * @param dblX limite superior de la integral
     * @param intDOF grados de libertad
     * @param dblE error aceptable entre dos aproximaciones
     */
    public SimpsonIntegration(double dblX, int intDOF, double dblE) {
        this.dblX = dblX;
        this.intDOF = intDOF;
        this.dblE = dblE;
    }

    /**
     * Calcula el ancho de cada segmento.
     *
     * @param intNumSeg numero de segmentos, debe ser par
     * @param dblX limite superior de la integral
     * @return el ancho W del segmento
     */
    public double computeW(int intNumSeg, double dblX) {
        this.intNumSeg = intNumSeg;
        this.dblX = dblX;
        dblW = dblX / intNumSeg;

        return dblW;
    }

    /**
     * Calcula los puntos x(i) de la Tabla 2.
     *
     * @param intNumSeg numero de segmentos
     * @return el arreglo con los valores de x(i)
     */
    public double[] computeXi(int intNumSeg) {
        dblTotXi = new double[intNumSeg + 1];

        for (int i = 0; i <= intNumSeg; i++) {
            dblTotXi[i] = i * dblW;
        }

        return dblTotXi;
    }

    /**
     * Calcula el termino base 1 + x(i)^2 / dof de cada punto.
     *
     * @param intNumSeg numero de segmentos
     * @param dblTotXi puntos x(i)
     * @param intDOF grados de libertad
     * @return el arreglo con los terminos base
     */
    public double[] computeFirstBaseTerms(int intNumSeg, double[] dblTotXi,
            int intDOF) {
        dblFirstBaseTerms = new double[intNumSeg + 1];

        for (int i = 0; i <= intNumSeg; i++) {
            dblFirstBaseTerms[i] = 1
                    + ((dblTotXi[i] * dblTotXi[i]) / intDOF);
        }

        return dblFirstBaseTerms;
    }

    /**
     * Calcula el exponente -(dof + 1) / 2 de la distribucion t.
     *
     * @param intDOF grados de libertad
     * @return el valor del exponente
     */
    public double computeExponent(int intDOF) {
        dblExponent = -(intDOF + 1) / 2.0;

        return dblExponent;
    }

    /**
     * Calcula el coeficiente de la distribucion t, formado por las dos
     * funciones gamma y la raiz de dof por pi.
     *
     * @param intDOF grados de libertad
     * @return el valor del coeficiente
     */
    public double computeCoefficient(int intDOF) {
        GammaFunction gamma = new GammaFunction();
        double arriba = gamma.computeGamma((intDOF + 1) / 2.0);
        double abajo = Math.sqrt(intDOF * Math.PI)
                * gamma.computeGamma(intDOF / 2.0);
        dblCoeff = arriba / abajo;

        return dblCoeff;
    }

    /**
     * Evalua la distribucion t en cada punto x(i).
     *
     * @param intNumSeg numero de segmentos
     * @return el arreglo con los valores F(x(i))
     */
    public double[] computeFxi(int intNumSeg) {
        dblFxi = new double[intNumSeg + 1];

        for (int i = 0; i <= intNumSeg; i++) {
            dblFxi[i] = dblCoeff
                    * Math.pow(dblFirstBaseTerms[i], dblExponent);
        }

        return dblFxi;
    }

    /**
     * Calcula los terminos finales de la Tabla 2, que son el ancho
     * entre tres por el multiplicador de Simpson por F(x(i)).
     *
     * @param intNumSeg numero de segmentos
     * @return el arreglo con los terminos finales
     */
    public double[] computeFinalTerms(int intNumSeg) {
        dblFinalTerms = new double[intNumSeg + 1];

        for (int i = 0; i <= intNumSeg; i++) {
            double multiplicador = 2;

            if (i == 0 || i == intNumSeg) {
                multiplicador = 1;
            } else if (i % 2 != 0) {
                multiplicador = 4;
            }

            dblFinalTerms[i] = (dblW / 3) * multiplicador * dblFxi[i];
        }

        return dblFinalTerms;
    }

    /**
     * Ejecuta todos los pasos y suma los terminos finales.
     *
     * @param intNumSeg numero de segmentos, debe ser par
     * @return la aproximacion de la integral
     */
    public double computeFinalValue(int intNumSeg) {
        computeW(intNumSeg, dblX);
        computeXi(intNumSeg);
        computeFirstBaseTerms(intNumSeg, dblTotXi, intDOF);
        computeExponent(intDOF);
        computeCoefficient(intDOF);
        computeFxi(intNumSeg);
        computeFinalTerms(intNumSeg);

        dblFinalValue = 0;

        for (int i = 0; i <= intNumSeg; i++) {
            dblFinalValue = dblFinalValue + dblFinalTerms[i];
        }

        return dblFinalValue;
    }

    /**
     * @return el error aceptable configurado
     */
    public double getDblE() {
        return dblE;
    }

    /**
     * @return el ancho del segmento
     */
    public double getDblW() {
        return dblW;
    }

    /**
     * @return el ultimo valor calculado de la integral
     */
    public double getDblFinalValue() {
        return dblFinalValue;
    }
}
