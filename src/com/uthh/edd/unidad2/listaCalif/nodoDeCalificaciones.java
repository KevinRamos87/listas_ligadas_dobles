/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uthh.edd.unidad2.listaCalif;

/**
 *
 * @author danie
 */
public class nodoDeCalificaciones {
     private int dato;          // valor almacenado en el nodo
    private nodoDeCalificaciones siguiente;     // referencia al siguiente nodo (null si es el último)

    // Constructores
    public nodoDeCalificaciones(int dato) {
        this.dato = dato;
        this.siguiente = null;
    }
    
    public nodoDeCalificaciones(int x, nodoDeCalificaciones sig){
        this.dato = x;
        this.siguiente = sig;
    }
    
    // Getters y Setters
    public void setDato(int x){
        this.dato = x;
    }
    
    public int getDato(){
        return dato;
    }
    
    public void setSiguiente(nodoDeCalificaciones sig){
        this.siguiente = sig;
    }
    
    public nodoDeCalificaciones getSiguiente(){
        return siguiente;
    }
    
}
