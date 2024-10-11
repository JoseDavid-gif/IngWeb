/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carreracienmetros;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class Equipo implements Runnable {

    int nombre;

    Equipo(int nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        System.out.println("Nombre del equipo: " + nombre);
        ArrayList<Thread> Corredores = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            var hilo = new Thread(new Corredor(i, nombre));
            hilo.start();
            Corredores.add(hilo);
        }

        // Esperar a que todos los hilos terminen
        for (Thread hilo : Corredores) {
            try {
                hilo.join();
            } catch (InterruptedException e) {
                System.out.println("Hilo interrumpido: " + e.getMessage());
            }
        }

        System.out.println("Equipo " + nombre + " ha terminado la carrera.");
    }
}
