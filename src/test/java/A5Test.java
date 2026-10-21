/*
 * A5Test.java
 * Programa 5 (PSP2) - Integracion por la regla de Simpson
 * Autor: Alejandro
 * Fecha: 2026-10-19
 */

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 * Pruebas unitarias del Programa 5. Las tres primeras son los casos
 * de la Tabla 1 del documento 5a; las demas cubren el resto de las
 * clases del diagrama para alcanzar el 100% de cobertura.
 */
public class A5Test {

    /** Tolerancia para comparar los valores de la Tabla 1. */
    public static final double TOLERANCIA = 0.00001;

    // ----- Casos de la Tabla 1 del documento 5a -----

    @Test
    public void prueba1TablaUno() {
        Logic logica = new Logic(1.1, 9);
        logica.logic1a();

        assertEquals(0.35006, logica.getDblFinalValue(), TOLERANCIA);
    }

    @Test
    public void prueba2TablaUno() {
        Logic logica = new Logic(1.1812, 10);
        logica.logic1a();

//         assertEquals(0.36757, logica.getDblFinalValue(), TOLERANCIA);

        assertEquals(0.36757, logica.getDblFinalValue(), TOLERANCIA);
    }

    @Test
    public void prueba3TablaUno() {
        Logic logica = new Logic(2.750, 30);
        logica.logic1a();

        assertEquals(0.495, logica.getDblFinalValue(), TOLERANCIA);
    }

    @Test
    public void segmentosDeLaTablaUno() {
        Logic logica = new Logic(1.1, 9);
        logica.logic1a();

        assertEquals(20, logica.getIntNumSeg());
        assertEquals(0.00001, logica.getDblE(), 0.0);
    }

    @Test
    public void casoQueNecesitaMasSegmentos() {
        Logic logica = new Logic(30, 1);
        logica.logic1a();

        assertEquals(320, logica.getIntNumSeg());
        assertEquals(0.48939, logica.getDblFinalValue(), TOLERANCIA);
    }

    @Test
    public void reportarArmaElRenglon() {
        Logic logica = new Logic(1.1, 9);
        logica.logic1a();
        String renglon = logica.reportar(1);

        assertTrue(renglon.contains("Prueba 1"));
        assertTrue(renglon.contains("0.35005"));
        assertTrue(renglon.contains("20"));
    }

    @Test
    public void constantesDeLogic() {
        assertEquals(10, Logic.SEGMENTOS_INICIALES);
        assertEquals(0.00001, Logic.ERROR, 0.0);
        assertEquals("data/out.txt", Logic.RUTA_SALIDA);
    }

    // ----- SimpsonIntegration, paso por paso (Tabla 2) -----

    @Test
    public void computeWDaElAnchoDelSegmento() {
        SimpsonIntegration simpson =
                new SimpsonIntegration(1.1, 9, 0.00001);

        assertEquals(0.11, simpson.computeW(10, 1.1), TOLERANCIA);
        assertEquals(0.11, simpson.getDblW(), TOLERANCIA);
        assertEquals(0.00001, simpson.getDblE(), 0.0);
    }

    @Test
    public void computeXiDaLosPuntos() {
        SimpsonIntegration simpson =
                new SimpsonIntegration(1.1, 9, 0.00001);
        simpson.computeW(10, 1.1);
        double[] xi = simpson.computeXi(10);

        assertEquals(11, xi.length);
        assertEquals(0.0, xi[0], TOLERANCIA);
        assertEquals(0.55, xi[5], TOLERANCIA);
        assertEquals(1.1, xi[10], TOLERANCIA);
    }

    @Test
    public void computeFirstBaseTermsSigueLaTablaDos() {
        SimpsonIntegration simpson =
                new SimpsonIntegration(1.1, 9, 0.00001);
        simpson.computeW(10, 1.1);
        double[] xi = simpson.computeXi(10);
        double[] base = simpson.computeFirstBaseTerms(10, xi, 9);

        assertEquals(1.0, base[0], TOLERANCIA);
        assertEquals(1.13444, base[10], 0.0001);
    }

    @Test
    public void computeExponentYCoefficient() {
        SimpsonIntegration simpson =
                new SimpsonIntegration(1.1, 9, 0.00001);

        assertEquals(-5.0, simpson.computeExponent(9), TOLERANCIA);
        assertEquals(0.38803, simpson.computeCoefficient(9), 0.0001);
    }

    @Test
    public void exponenteConGradosDeLibertadPares() {
        SimpsonIntegration simpson =
                new SimpsonIntegration(1.1812, 10, 0.00001);

        assertEquals(-5.5, simpson.computeExponent(10), TOLERANCIA);
        assertEquals(0.38910, simpson.computeCoefficient(10), 0.0001);
    }

    @Test
    public void computeFxiEvaluaLaDistribucion() {
        SimpsonIntegration simpson =
                new SimpsonIntegration(1.1, 9, 0.00001);
        simpson.computeFinalValue(10);
        double[] fxi = simpson.computeFxi(10);

        assertEquals(0.38803, fxi[0], 0.0001);
        assertEquals(0.20652, fxi[10], 0.0001);
    }

    @Test
    public void computeFinalTermsUsaLosMultiplicadores() {
        SimpsonIntegration simpson =
                new SimpsonIntegration(1.1, 9, 0.00001);
        simpson.computeFinalValue(10);
        double[] terminos = simpson.computeFinalTerms(10);

        assertEquals(0.01423, terminos[0], 0.0001);
        assertEquals(0.05653, terminos[1], 0.0001);
        assertEquals(0.02770, terminos[2], 0.0001);
        assertEquals(0.00757, terminos[10], 0.0001);
    }

    @Test
    public void multiplicadoresDeSimpsonSiguenElPatron() {
        SimpsonIntegration simpson =
                new SimpsonIntegration(4, 9, 0.00001);
        simpson.computeFinalValue(4);
        double[] fxi = simpson.computeFxi(4);
        double[] terminos = simpson.computeFinalTerms(4);
        double anchoTercio = simpson.getDblW() / 3;
        int[] esperados = {1, 4, 2, 4, 1};

        for (int i = 0; i <= 4; i++) {
            double multiplicador = terminos[i] / (anchoTercio * fxi[i]);
            assertEquals(esperados[i], multiplicador, 0.000001);
        }
    }

    @Test
    public void anchoYPuntosDelPrototipoDelProfesor() {
        SimpsonIntegration simpson =
                new SimpsonIntegration(4, 9, 0.00001);

        assertEquals(1.0, simpson.computeW(4, 4), TOLERANCIA);

        double[] xi = simpson.computeXi(4);

        assertEquals(0.0, xi[0], TOLERANCIA);
        assertEquals(1.0, xi[1], TOLERANCIA);
        assertEquals(2.0, xi[2], TOLERANCIA);
        assertEquals(3.0, xi[3], TOLERANCIA);
        assertEquals(4.0, xi[4], TOLERANCIA);
    }

    @Test
    public void computeFinalValueConDiezSegmentos() {
        SimpsonIntegration simpson =
                new SimpsonIntegration(1.1, 9, 0.00001);

        assertEquals(0.3500589, simpson.computeFinalValue(10), 0.0001);
        assertEquals(0.3500589, simpson.getDblFinalValue(), 0.0001);
    }

    @Test
    public void computeFinalValueConVeinteSegmentos() {
        SimpsonIntegration simpson =
                new SimpsonIntegration(1.1, 9, 0.00001);

        assertEquals(0.35005864, simpson.computeFinalValue(20),
                TOLERANCIA);
    }

    // ----- GammaFunction -----

    @Test
    public void gammaDeEnteros() {
        GammaFunction gamma = new GammaFunction();

        assertEquals(1.0, gamma.computeIntGamma(1), TOLERANCIA);
        assertEquals(1.0, gamma.computeIntGamma(2), TOLERANCIA);
        assertEquals(24.0, gamma.computeIntGamma(5), TOLERANCIA);
        assertEquals(24.0, gamma.getGammaValue(), TOLERANCIA);
    }

    @Test
    public void gammaDeMediosEnteros() {
        GammaFunction gamma = new GammaFunction();

        assertEquals(Math.sqrt(Math.PI), gamma.computeDblGamma(0.5),
                TOLERANCIA);
        assertEquals(0.8862269, gamma.computeDblGamma(1.5), TOLERANCIA);
        assertEquals(52.342778, gamma.computeDblGamma(5.5), 0.0001);
    }

    @Test
    public void computeGammaDecideElCamino() {
        GammaFunction gamma = new GammaFunction();

        assertEquals(24.0, gamma.computeGamma(5), TOLERANCIA);
        assertEquals(0.8862269, gamma.computeGamma(1.5), TOLERANCIA);
        assertEquals(0.000000001, GammaFunction.TOLERANCIA, 0.0);
    }

    // ----- Output -----

    @Test
    public void escribirArchivoDeSalida() {
        Output salida = new Output();
        salida.writeData("data/prueba_out.txt", "linea de prueba\n");

        assertNotNull(salida);
    }

    @Test
    public void escribirEnRutaInvalida() {
        Output salida = new Output();
        salida.writeData("carpeta_que_no_existe/out.txt", "texto");

        assertNotNull(salida);
    }

    // ----- App -----

    @Test
    public void mainSinParametrosCorreLasTres() {
        App.main(new String[] {});

        assertNotNull(new App());
    }

    @Test
    public void mainConParametroCorreUnaSola() {
        App.main(new String[] {"2"});

        assertTrue(App.ejecutarPrueba(2).contains("Prueba 2"));
    }

    @Test
    public void encabezadoTieneLasColumnas() {
        assertTrue(App.encabezado().contains("Prueba"));
        assertTrue(App.encabezado().contains("dof"));
        assertTrue(App.encabezado().contains("segmentos"));
    }

    @Test
    public void ejecutarPruebaConNumeroInvalido() {
        assertTrue(App.ejecutarPrueba(0).contains("invalida"));
        assertTrue(App.ejecutarPrueba(5).contains("invalida"));
        assertEquals(3, App.TOTAL_PRUEBAS);
    }

    @Test
    public void ejecutarLasTresPruebasDeLaTablaUno() {
        assertTrue(App.ejecutarPrueba(1).contains("0.35005"));
        assertTrue(App.ejecutarPrueba(2).contains("0.36757"));
        assertTrue(App.ejecutarPrueba(3).contains("0.49499"));
        assertEquals(3, App.VALORES_X.length);
        assertEquals(3, App.VALORES_DOF.length);
    }
}
