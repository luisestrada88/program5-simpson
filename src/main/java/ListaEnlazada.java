/*
 * ListaEnlazada.java
 * Programa 5 (PSP2) - Integracion por regla de Simpson
 * Autor: Alejandro
 * Fecha: 2026-10-14
 * Reutilizada del Programa 3.
 * Extiende la lista del Programa 1: cada registro guarda dos numeros reales.
 */

/**
 * Lista enlazada simple de pares de numeros reales. Mantiene la
 * referencia al primer nodo y agrega siempre al final para conservar
 * el orden de lectura del archivo.
 */
public class ListaEnlazada {

    private Nodo cabeza;
    private int tamanio;

    /**
     * Crea una lista vacia.
     */
    public ListaEnlazada() {
        this.cabeza = null;
        this.tamanio = 0;
    }

    /**
     * Agrega un par al final de la lista.
     *
     * @param x primer valor del par
     * @param y segundo valor del par
     */
    public void agregar(double x, double y) {
        Nodo nuevo = new Nodo(x, y);

        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Nodo aux = cabeza;

            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }

            aux.setSiguiente(nuevo);
        }

        tamanio = tamanio + 1;
    }

    /**
     * @return el primer nodo de la lista, o null si esta vacia
     */
    public Nodo getCabeza() {
        return cabeza;
    }

    /**
     * @return cuantos pares tiene la lista
     */
    public int getTamanio() {
        return tamanio;
    }
}
