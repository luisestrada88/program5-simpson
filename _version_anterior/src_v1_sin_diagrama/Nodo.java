/*
 * Nodo.java
 * Programa 5 (PSP2) - Integracion por regla de Simpson
 * Autor: Alejandro
 * Fecha: 2026-10-14
 * Reutilizada del Programa 3.
 */

/**
 * Nodo de la lista enlazada. Cada nodo guarda un par de numeros reales
 * y la referencia al siguiente nodo de la lista.
 */
public class Nodo {

    private double x;
    private double y;
    private Nodo siguiente;

    /**
     * Crea un nodo con el par indicado y sin nodo siguiente.
     *
     * @param x primer valor del par
     * @param y segundo valor del par
     */
    public Nodo(double x, double y) {
        this.x = x;
        this.y = y;
        this.siguiente = null;
    }

    /**
     * @return el primer valor del par
     */
    public double getX() {
        return x;
    }

    /**
     * @return el segundo valor del par
     */
    public double getY() {
        return y;
    }

    /**
     * @return el siguiente nodo, o null si este es el ultimo
     */
    public Nodo getSiguiente() {
        return siguiente;
    }

    /**
     * @param siguiente nodo que va despues de este
     */
    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}
