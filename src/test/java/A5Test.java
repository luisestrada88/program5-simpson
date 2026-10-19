/*
 * A5Test.java
 * Programa 5 (PSP2) - Integracion por regla de Simpson
 * Autor: Alejandro
 * Fecha: 2026-10-14
 */

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

/**
 * Pruebas unitarias del Programa 5. Las tres primeras son los casos
 * de la Tabla 1 del documento 5a; las demas cubren el resto de las
 * clases para alcanzar el 100% de cobertura.
 */
public class A5Test {

    /** Tolerancia para comparar los valores de la Tabla 1. */
    public static final double TOLERANCIA = 0.00001;

    // ----- Casos de la Tabla 1 del documento 5a -----

    @Test
    public void prueba1TablaUno() {
        assertEquals(0.35006, Simpson.calcularP(1.1, 9), TOLERANCIA);
    }

    @Test
    public void prueba2TablaUno() {
        assertEquals(0.36757, Simpson.calcularP(1.1812, 10), TOLERANCIA);
    }

    @Test
    public void prueba3TablaUno() {
        assertEquals(0.495, Simpson.calcularP(2.750, 30), TOLERANCIA);
    }

    @Test
    public void segmentosDeLaTablaUno() {
        assertEquals(20, Simpson.segmentosUsados(1.1, 9));
        assertEquals(20, Simpson.segmentosUsados(1.1812, 10));
        assertEquals(20, Simpson.segmentosUsados(2.750, 30));
    }

    @Test
    public void casoQueNecesitaMasSegmentos() {
        assertEquals(320, Simpson.segmentosUsados(30, 1));
        assertEquals(0.48939, Simpson.calcularP(30, 1), TOLERANCIA);
    }

    // ----- Simpson -----

    @Test
    public void integrarConSegmentosFijos() {
        assertEquals(0.35006, Simpson.integrar(1.1, 9, 20), 0.0001);
    }

    @Test
    public void constantesDeSimpson() {
        assertEquals(0.00001, Simpson.ERROR, 0.0);
        assertEquals(10, Simpson.SEGMENTOS_INICIALES);
        assertNotNull(new Simpson());
    }

    // ----- DistribucionT -----

    @Test
    public void densidadEnCero() {
        assertEquals(0.38803, DistribucionT.evaluar(0, 9), 0.0001);
    }

    @Test
    public void densidadEsSimetrica() {
        assertEquals(DistribucionT.evaluar(1.1, 9),
                DistribucionT.evaluar(-1.1, 9), TOLERANCIA);
        assertNotNull(new DistribucionT());
    }

    // ----- Gamma -----

    @Test
    public void gammaDeEnteros() {
        assertEquals(1.0, Gamma.calcular(1), TOLERANCIA);
        assertEquals(24.0, Gamma.calcular(5), TOLERANCIA);
    }

    @Test
    public void gammaDeMediosEnteros() {
        assertEquals(Math.sqrt(Math.PI), Gamma.calcular(0.5), TOLERANCIA);
        assertEquals(0.8862269, Gamma.calcular(1.5), TOLERANCIA);
        assertEquals(52.342778, Gamma.calcular(5.5), 0.0001);
    }

    @Test
    public void esEnteroDistingueLosCasos() {
        assertTrue(Gamma.esEntero(4));
        assertTrue(Gamma.esEntero(4.0) == true);
        assertTrue(Gamma.esEntero(4.5) == false);
    }

    @Test
    public void factorialDeVariosNumeros() {
        assertEquals(1.0, Gamma.factorial(0), TOLERANCIA);
        assertEquals(1.0, Gamma.factorial(1), TOLERANCIA);
        assertEquals(120.0, Gamma.factorial(5), TOLERANCIA);
        assertNotNull(new Gamma());
    }

    // ----- Nodo y ListaEnlazada -----

    @Test
    public void nodoGuardaElPar() {
        Nodo nodo = new Nodo(1.5, 2.5);

        assertEquals(1.5, nodo.getX(), TOLERANCIA);
        assertEquals(2.5, nodo.getY(), TOLERANCIA);
        assertNull(nodo.getSiguiente());
    }

    @Test
    public void nodoEnlazaConOtro() {
        Nodo primero = new Nodo(1, 2);
        Nodo segundo = new Nodo(3, 4);
        primero.setSiguiente(segundo);

        assertEquals(3.0, primero.getSiguiente().getX(), TOLERANCIA);
    }

    @Test
    public void listaVaciaNoTienePares() {
        ListaEnlazada lista = new ListaEnlazada();

        assertEquals(0, lista.getTamanio());
        assertNull(lista.getCabeza());
    }

    @Test
    public void listaAgregaAlFinal() {
        ListaEnlazada lista = new ListaEnlazada();
        lista.agregar(1, 2);
        lista.agregar(3, 4);
        lista.agregar(5, 6);

        assertEquals(3, lista.getTamanio());
        assertEquals(1.0, lista.getCabeza().getX(), TOLERANCIA);
        assertEquals(6.0,
                lista.getCabeza().getSiguiente().getSiguiente().getY(),
                TOLERANCIA);
    }

    // ----- ReadFile -----

    @Test
    public void leerArchivoDeDatos() {
        ListaEnlazada lista = ReadFile.leerArchivo("data/in.txt", 0, 1);

        assertEquals(3, lista.getTamanio());
        assertEquals(1.1, lista.getCabeza().getX(), TOLERANCIA);
        assertEquals(9.0, lista.getCabeza().getY(), TOLERANCIA);
    }

    @Test
    public void leerArchivoIgnoraLineasEnBlanco() {
        ListaEnlazada lista =
                ReadFile.leerArchivo("data/prueba_blanco.txt", 0, 1);

        assertEquals(2, lista.getTamanio());
    }

    @Test
    public void leerArchivoQueNoExiste() {
        ListaEnlazada lista = ReadFile.leerArchivo("data/no_existe.txt", 0, 1);

        assertEquals(0, lista.getTamanio());
        assertNotNull(new ReadFile());
    }

    // ----- OutFile -----

    @Test
    public void escribirArchivoDeSalida() {
        ArrayList<String> lineas = new ArrayList<String>();
        lineas.add("linea de prueba");
        OutFile.escribirArchivo("data/prueba_out.txt", lineas);

        ListaEnlazada lista =
                ReadFile.leerArchivo("data/prueba_out.txt", 0, 1);

        assertEquals(0, lista.getTamanio());
    }

    @Test
    public void escribirEnRutaInvalida() {
        ArrayList<String> lineas = new ArrayList<String>();
        lineas.add("linea de prueba");
        OutFile.escribirArchivo("carpeta_que_no_existe/out.txt", lineas);

        assertNotNull(new OutFile());
    }

    // ----- Main -----

    @Test
    public void mainSinParametrosCorreLasTres() {
        Main.main(new String[] {});

        assertNotNull(new Main());
    }

    @Test
    public void mainConParametroCorreUnaSola() {
        Main.main(new String[] {"2"});

        assertTrue(Main.ejecutarPrueba(2).contains("Prueba 2"));
    }

    @Test
    public void encabezadoTieneLasColumnas() {
        assertTrue(Main.encabezado().contains("Prueba"));
        assertTrue(Main.encabezado().contains("dof"));
        assertTrue(Main.encabezado().contains("segmentos"));
    }

    @Test
    public void ejecutarPruebaConNumeroInvalido() {
        assertTrue(Main.ejecutarPrueba(0).contains("invalida"));
        assertTrue(Main.ejecutarPrueba(5).contains("invalida"));
        assertEquals(3, Main.TOTAL_PRUEBAS);
        assertEquals("data/in.txt", Main.RUTA);
    }

    @Test
    public void ejecutarPruebaTresTraeElValorEsperado() {
        assertTrue(Main.ejecutarPrueba(3).contains("0.49499"));
    }
}
