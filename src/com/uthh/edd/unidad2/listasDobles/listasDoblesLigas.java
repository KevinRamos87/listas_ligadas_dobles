/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uthh.edd.unidad2.listasDobles;
import java.util.Scanner;
/**
 *
 * @author danie
 */
public class listasDoblesLigas {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        listaDoble lista = new listaDoble();
        //nsnddpa comit

        int opcion;

        do {

            System.out.println("\n========= MENÚ LISTA DOBLEMENTE ENLAZADA =========");
            System.out.println("1. Insertar al inicio");
            System.out.println("2. Insertar al final");
            System.out.println("3. Insertar en posición");
            System.out.println("4. Insertar ordenado");
            System.out.println("5. Eliminar al inicio");
            System.out.println("6. Eliminar al final (eliminarUltimo)");
            System.out.println("7. Eliminar por valor");
            System.out.println("8. Eliminar por posición");
            System.out.println("9. Imprimir y ver tamaño");
            System.out.println("0. Salir");

            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    System.out.print("Ingresa el valor: ");
                    lista.InsertaInicio(sc.nextInt());
                    break;

                case 2:
                    System.out.print("Ingresa el valor: ");
                    lista.insertarFinal(sc.nextInt());
                    break;

                case 3:
                    System.out.print("Ingresa la posición: ");
                    int pos = sc.nextInt();

                    System.out.print("Ingresa el valor: ");
                    int valor = sc.nextInt();

                    lista.insertarEnPosicion(pos, valor);
                    break;

                case 4:
                    System.out.print("Ingresa el valor a insertar ordenadamente: ");
                    int ordenado = sc.nextInt();

                    lista.insertarOrdenado(ordenado);
                    break;

                case 5:
                    if (!lista.estaVacia()) {
                        System.out.println("Dato eliminado: "
                                + lista.eliminarInicio());
                    } else {
                        System.out.println("La lista está vacía");
                    }
                    break;

                case 6:
                    System.out.println(lista.eliminarUltimo()
                            ? "Último nodo eliminado"
                            : "La lista está vacía");
                    break;

                case 7:
                    System.out.print("Ingresa el valor a eliminar: ");
                    int eliminado = sc.nextInt();

                    System.out.println(lista.eliminarPorValor(eliminado)
                            ? "Valor eliminado correctamente"
                            : "Valor no encontrado");
                    break;

                case 8:
                    System.out.print("Ingresa la posición a eliminar: ");
                    int posicion = sc.nextInt();

                    System.out.println("Dato eliminado: "
                            + lista.eliminarEnPosicion(posicion));
                    break;

                case 9:
                    System.out.println("\nContenido de la lista:");
                    System.out.println(lista);
                    System.out.println("Tamaño de la lista: "
                            + lista.getTamanio());
                    break;

                case 0:
                    System.out.println("Hasta luego");
                    break;

                default:
                    System.out.println("Opción inválida");
            }

        } while (opcion != 0);

        sc.close();
    }
}