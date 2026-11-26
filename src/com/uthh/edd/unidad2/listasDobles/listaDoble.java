/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uthh.edd.unidad2.listasDobles;

/**
 *
 * @author danie
 */
public class listaDoble {

    private int tamanio;
    private nodoDoble cabeza;
    private nodoDoble cola;

    // Constructor
    public listaDoble() {
        tamanio = 0;
        cabeza = null;
        cola = null;
    }

    // Verificar si la lista esta vacia
    public boolean estaVacia() {
        return cabeza == null;
    }

    // Obtener tamaño
    public int getTamanio() {
        return tamanio;
    }

    // Metodo toString
    @Override
    public String toString() {
        String res = "NULL";
        nodoDoble aux = cabeza;

        while (aux != null) {
            res = res + " <--> [" + aux.getDato() + "]";
            aux = aux.getSiguiente();
        }

        res = res + " <--> NULL";
        return res;
    }

    // Obtener nodo por posicion
    public nodoDoble obtenerNodo(int pos) {

        if (pos <= 0 || pos > tamanio) {
            throw new IllegalStateException("La posicion esta fuera del rango");
        }

        nodoDoble aux = cabeza;

        for (int i = 1; i < pos; i++) {
            aux = aux.getSiguiente();
        }

        return aux;
    }

    // Insertar al inicio
    public void InsertaInicio(int valor) {
        nodoDoble nuevo = new nodoDoble(valor);

        if (estaVacia()) {
            cola = nuevo;
        } else {
            cabeza.setAnterior(nuevo);
            nuevo.setSiguiente(cabeza);
        }

        cabeza = nuevo;
        tamanio++;
    }

    // Insertar al final
    public void insertarFinal(int valor) {
        nodoDoble nuevo = new nodoDoble(valor);

        if (estaVacia()) {
            cabeza = nuevo;
        } else {
            cola.setSiguiente(nuevo);
            nuevo.setAnterior(cola);
        }

        cola = nuevo;
        tamanio++;
    }

    // Insertar en una posicion
    public void insertarEnPosicion(int pos, int valor) {

        if (pos <= 0 || pos > tamanio + 1) {
            throw new IllegalStateException("La posicion esta fuera del rango");
        }

        //
        // Caso 1: insertar al inicio
        if (pos == 1) {
            InsertaInicio(valor);
            return;
        }

        // Caso 2: insertar al final
        if (pos == tamanio + 1) {
            insertarFinal(valor);
            return;
        }

        // Caso 3: insertar en medio
        nodoDoble aux = obtenerNodo(pos - 1);
        nodoDoble nuevo = new nodoDoble(valor);

        nuevo.setSiguiente(aux.getSiguiente());
        nuevo.setAnterior(aux);

        aux.getSiguiente().setAnterior(nuevo);
        aux.setSiguiente(nuevo);

        tamanio++;
    }

    // Insertar ordenadamente de menor a mayor
    public void insertarOrdenado(int dato) {

        nodoDoble nuevo = new nodoDoble(dato);

        if (estaVacia()) {
            cabeza = nuevo;
            cola = nuevo;
            tamanio++;
            return;
        }

        // Caso 1: insertar al inicio
        if (dato <= cabeza.getDato()) {
            nuevo.setSiguiente(cabeza);
            cabeza.setAnterior(nuevo);

            cabeza = nuevo;
            tamanio++;
            return;
        }

        // Caso 2: insertar al final
        if (dato >= cola.getDato()) {
            cola.setSiguiente(nuevo);
            nuevo.setAnterior(cola);

            cola = nuevo;
            tamanio++;
            return;
        }

        // Caso 3: insertar en medio
        nodoDoble aux = cabeza;

        while (aux != null) {

            if (dato <= aux.getDato()) {
                nuevo.setSiguiente(aux);
                nuevo.setAnterior(aux.getAnterior());

                aux.getAnterior().setSiguiente(nuevo);
                aux.setAnterior(nuevo);

                tamanio++;
                return;
            }

            aux = aux.getSiguiente();
        }
    }

    // Eliminar al inicio
    public int eliminarInicio() {

        if (estaVacia()) {
            throw new IllegalStateException("La lista esta vacia");
        }

        int dato = cabeza.getDato();

        // Caso 1: solamente existe un nodo
        if (tamanio == 1) {
            cabeza = null;
            cola = null;
        } else {
            // Caso 2: existen varios nodos
            cabeza = cabeza.getSiguiente();
            cabeza.setAnterior(null);
        }

        tamanio--;
        return dato;
    }

    // Eliminar al final
    public boolean eliminarUltimo() {

        if (estaVacia()) {
            return false;
        }

        // Caso 1: solamente existe un nodo
        if (tamanio == 1) {
            cabeza = null;
            cola = null;
        } else {
            // Caso 2: existen varios nodos
            cola = cola.getAnterior();
            cola.setSiguiente(null);
        }

        tamanio--;
        return true;
    }

    // Eliminar por valor
    public boolean eliminarPorValor(int x) {

        if (estaVacia()) {
            return false;
        }

        // Caso 1: el valor esta en la cabeza
        if (cabeza.getDato() == x) {
            eliminarInicio();
            return true;
        }

        // Caso 2: buscar el valor
        nodoDoble aux = cabeza;

        while (aux != null) {

            if (aux.getDato() == x) {

                // Si es el ultimo nodo
                if (aux == cola) {
                    cola = cola.getAnterior();
                    cola.setSiguiente(null);
                } else {
                    aux.getAnterior().setSiguiente(aux.getSiguiente());
                    aux.getSiguiente().setAnterior(aux.getAnterior());
                }

                tamanio--;
                return true;
            }

            aux = aux.getSiguiente();
        }

        return false;
    }

    // Eliminar en una posicion
    public int eliminarEnPosicion(int pos) {

        if (pos <= 0 || pos > tamanio) {
            throw new IllegalStateException("La posicion esta fuera del rango");
        }

        // Caso 1: eliminar al inicio
        if (pos == 1) {
            return eliminarInicio();
        }

        // Caso 2: eliminar al final
        if (pos == tamanio) {
            int dato = cola.getDato();

            cola = cola.getAnterior();
            cola.setSiguiente(null);

            tamanio--;
            return dato;
        }

        // Caso 3: eliminar en medio
        nodoDoble objetivo = obtenerNodo(pos);

        int dato = objetivo.getDato();

        objetivo.getAnterior().setSiguiente(objetivo.getSiguiente());
        objetivo.getSiguiente().setAnterior(objetivo.getAnterior());

        tamanio--;
        return dato;
    }
}