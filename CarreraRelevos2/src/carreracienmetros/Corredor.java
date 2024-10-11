/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carreracienmetros;

import java.util.Random;

/**
 *
 * @author Usuario
 */
public class Corredor implements Runnable {

    Random rd = new Random();
    int num_cor;
    int nombreEquipo;

    Corredor(int num_cor, int nombreEquipo) {
        this.num_cor = num_cor;
        this.nombreEquipo = nombreEquipo;
    }

    @Override
    public void run() {
        int distancia = 0;
        while (distancia <= 100) {
            System.out.println("Equipo " + nombreEquipo + " Corredor " + num_cor + " distancia " + distancia + " metros.");
            distancia += rd.nextInt(3) + 1;
            try {
                Thread.sleep(100); // Simula el tiempo de avance
            } catch (InterruptedException e) {
                System.out.println("Corredor interrumpido: " + e.getMessage());
            }
        }
        System.out.println("Equipo " + nombreEquipo + " Corredor " + num_cor + " ha terminado.");
    }
}
