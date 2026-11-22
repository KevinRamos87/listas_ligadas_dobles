/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uthh.edd.unidad2.listaCalif;
import java.util.Scanner;
/**
 *
 * @author danie
 */
public class listasCalifi {
    

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        listaCalificaciones lista = new listaCalificaciones();

        int opcion;

        do {

            System.out.println("\n===== SISTEMA DE CALIFICACIONES =====");
            System.out.println("1. Agregar calificacion");
            System.out.println("2. Mostrar calificaciones");
            System.out.println("3. Consultar por posicion");
            System.out.println("4. Consultar calificacion minima");
            System.out.println("5. Consultar calificacion maxima");
            System.out.println("6. Consultar mediana");
            System.out.println("7. Corregir calificacion");
            System.out.println("8. Eliminar calificacion");
            System.out.println("9. Eliminar calificaciones invalidas");
            System.out.println("10. Buscar calificacion");
            System.out.println("11. Total de estudiantes que entregaron");
            System.out.println("0. Salir");

            System.out.print("Opcion: ");
            opcion = teclado.nextInt();

            switch (opcion) {

                case 1:
                    System.out.print("Ingresa la calificacion: ");
                    int valor = teclado.nextInt();

                    try {
                        lista.agregarCalificacion(valor);
                        System.out.println("Calificacion agregada");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    System.out.println("Lista de calificaciones:");
                    System.out.println(lista);
                    break;

                case 3:
                    System.out.print("Ingresa la posicion: ");
                    int pos = teclado.nextInt();

                    try {
                        System.out.println("Calificacion: "
                                + lista.consultarPosicion(pos));
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    try {
                        System.out.println("Calificacion minima: "
                                + lista.calificacionMinima());
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 5:
                    try {
                        System.out.println("Calificacion maxima: "
                                + lista.calificacionMaxima());
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 6:
                    try {
                        System.out.println("Mediana: "
                                + lista.calificacionMediana());
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 7:
                    System.out.print("Posicion a corregir: ");
                    int posicion = teclado.nextInt();

                    System.out.print("Nueva calificacion: ");
                    int nueva = teclado.nextInt();

                    try {
                        lista.corregirCalificacion(posicion, nueva);
                        System.out.println("Calificacion corregida");
                        System.out.println(lista);
                    } catch (IllegalArgumentException | IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 8:
                    System.out.print("Calificacion a eliminar: ");
                    int eliminar = teclado.nextInt();

                    if (lista.eliminarPorValor(eliminar)) {
                        System.out.println("Calificacion eliminada");
                    } else {
                        System.out.println("Calificacion no encontrada");
                    }
                    break;

                case 9:
                    int eliminadas = lista.eliminarInvalidas();

                    System.out.println("Calificaciones invalidas eliminadas: "
                            + eliminadas);
                    break;

                case 10:
                    System.out.print("Calificacion a buscar: ");
                    int buscar = teclado.nextInt();

                    if (lista.buscar(buscar)) {
                        System.out.println("La calificacion si existe");
                    } else {
                        System.out.println("La calificacion no existe");
                    }
                    break;

                case 11:
                    System.out.println("Total de estudiantes que entregaron: "
                            + lista.totalEstudiantes());
                    break;

                case 0:
                    System.out.println("Hasta luego");
                    break;

                default:
                    System.out.println("Opcion invalida");
            }

        } while (opcion != 0);

        teclado.close();
    }

}
