/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uthh.edd.unidad2.listaCalif;

/**
 *
 * @author danie
 */
public class listaCalificaciones {
    private nodoDeCalificaciones cabeza;   // primer nodo de la lista
    private int tamanio;                   // cantidad de calificaciones almacenadas

    public listaCalificaciones() {
        this.cabeza = null;
        this.tamanio = 0;
    }

    public boolean estaVacia() {
        if (cabeza == null) {
            return true;
        } else {
            return false;
        }
    }
    
      public boolean calificacionValida(int valor) {
        return valor >= 0 && valor <= 10;
    }

    // Ver el total de estudiantes que ya entregaron
    public int totalEstudiantes() {
        return tamanio;
    }

    public void insertarInicio(int x) {
        nodoDeCalificaciones nuevo = new nodoDeCalificaciones(x);
        nuevo.setSiguiente(cabeza);
        cabeza = nuevo;
        tamanio++;
    }

    // Insertar calificación manteniendo la lista ordenada de menor a mayor
     public void agregarCalificacion(int valor) {

        if (!calificacionValida(valor)) {
            throw new IllegalArgumentException("Calificacion invalida");
        }

        if (estaVacia()) {
            insertarInicio(valor);
            return;
        }

        if (valor <= cabeza.getDato()) {
            insertarInicio(valor);
            return;
        }

        nodoDeCalificaciones aux = cabeza;

        while (aux.getSiguiente() != null
                && valor > aux.getSiguiente().getDato()) {

            aux = aux.getSiguiente();
        }

        nodoDeCalificaciones nuevo = new nodoDeCalificaciones(valor);

        nuevo.setSiguiente(aux.getSiguiente());
        aux.setSiguiente(nuevo);

        tamanio++;
    }

    // Mostrar lista
    @Override
    public String toString() {

        String res = "";
        nodoDeCalificaciones aux = cabeza;

        while (aux != null) {
            res = res + "[" + aux.getDato() + "]->";
            aux = aux.getSiguiente();
        }

        res = res + "null";

        return res;
    }

    // Obtener nodo por posicion
    public nodoDeCalificaciones obtenerNodo(int pos) {

        if (pos <= 0 || pos > tamanio) {
            throw new IllegalStateException("Posicion fuera de rango");
        }

        nodoDeCalificaciones aux = cabeza;

        for (int i = 1; i < pos; i++) {
            aux = aux.getSiguiente();
        }

        return aux;
    }

    // Consultar calificacion por posicion
    public int consultarPosicion(int pos) {
        return obtenerNodo(pos).getDato();
    }

    // Consultar calificacion minima
    public int calificacionMinima() {

        if (estaVacia()) {
            throw new IllegalStateException("Lista vacia");
        }

        return cabeza.getDato();
    }

    // Consultar calificacion maxima
    public int calificacionMaxima() {

        if (estaVacia()) {
            throw new IllegalStateException("Lista vacia");
        }

        nodoDeCalificaciones aux = cabeza;

        while (aux.getSiguiente() != null) {
            aux = aux.getSiguiente();
        }

        return aux.getDato();
    }

    // Consultar mediana
    public double calificacionMediana() {

        if (estaVacia()) {
            throw new IllegalStateException("Lista vacia");
        }

        nodoDeCalificaciones aux = cabeza;

        // Caso: cantidad impar
        if (tamanio % 2 != 0) {

            int posMediana = (tamanio + 1) / 2;

            for (int i = 1; i < posMediana; i++) {
                aux = aux.getSiguiente();
            }

            return aux.getDato();
        }

        // Caso: cantidad par
        int pos1 = tamanio / 2;
        int pos2 = pos1 + 1;

        for (int i = 1; i < pos1; i++) {
            aux = aux.getSiguiente();
        }

        int valor1 = aux.getDato();
        int valor2 = aux.getSiguiente().getDato();

        return (valor1 + valor2) / 2.0;
    }

    // Buscar una calificacion especifica
    public boolean buscar(int valor) {

        nodoDeCalificaciones aux = cabeza;

        while (aux != null) {

            if (aux.getDato() == valor) {
                return true;
            }

            aux = aux.getSiguiente();
        }

        return false;
    }

    // Eliminar una calificacion por valor
    public boolean eliminarPorValor(int valor) {

        if (estaVacia()) {
            return false;
        }

        // Caso: eliminar la cabeza
        if (cabeza.getDato() == valor) {
            cabeza = cabeza.getSiguiente();
            tamanio--;
            return true;
        }

        nodoDeCalificaciones aux = cabeza;

        while (aux.getSiguiente() != null) {

            if (aux.getSiguiente().getDato() == valor) {

                aux.setSiguiente(
                    aux.getSiguiente().getSiguiente()
                );

                tamanio--;
                return true;
            }

            aux = aux.getSiguiente();
        }

        return false;
    }

    // Corregir una calificacion por posicion
    public void corregirCalificacion(int pos, int nuevoValor) {

        if (!calificacionValida(nuevoValor)) {
            throw new IllegalArgumentException("Calificacion invalida");
        }

        // Validar que la posicion exista
        obtenerNodo(pos);

        // Eliminar la calificacion anterior
        int anterior = obtenerNodo(pos).getDato();

        eliminarPorValorEnPosicion(pos);

        // Insertar nuevamente para conservar el orden
        agregarCalificacion(nuevoValor);
    }

    // Eliminar por posicion
    public int eliminarPorValorEnPosicion(int pos) {

        if (pos <= 0 || pos > tamanio) {
            throw new IllegalStateException("Posicion fuera de rango");
        }

        if (pos == 1) {

            int dato = cabeza.getDato();
            cabeza = cabeza.getSiguiente();
            tamanio--;

            return dato;
        }

        nodoDeCalificaciones aux = cabeza;

        for (int i = 1; i < pos - 1; i++) {
            aux = aux.getSiguiente();
        }

        nodoDeCalificaciones objetivo = aux.getSiguiente();

        int dato = objetivo.getDato();

        aux.setSiguiente(objetivo.getSiguiente());

        tamanio--;

        return dato;
    }

    // Eliminar calificaciones invalidas
    public int eliminarInvalidas() {

        int eliminadas = 0;

        while (cabeza != null && !calificacionValida(cabeza.getDato())) {
            cabeza = cabeza.getSiguiente();
            tamanio--;
            eliminadas++;
        }

        nodoDeCalificaciones aux = cabeza;

        while (aux != null && aux.getSiguiente() != null) {

            if (!calificacionValida(aux.getSiguiente().getDato())) {

                aux.setSiguiente(aux.getSiguiente().getSiguiente());

                tamanio--;
                eliminadas++;

            } else {

                aux = aux.getSiguiente();
            }
        }

        return eliminadas;
    }
}