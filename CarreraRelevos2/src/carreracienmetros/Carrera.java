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
public class Carrera {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Thread> Equipos = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            var hilo = new Thread(new Equipo(i));
            hilo.start();
            Equipos.add(hilo);
        }

        // Esperar a que todos los equipos terminen
        for (Thread hilo : Equipos) {
            try {
                hilo.join();
            } catch (InterruptedException e) {
                System.out.println("Hilo interrumpido: " + e.getMessage());
            }
        }

        System.out.println("Todos los equipos han terminado la carrera.");
    }
}
