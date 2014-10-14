/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamemoryusage;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author eslem
 */
public class JavaMemoryUsage {

    static List<Object> permanente = new ArrayList<Object>();

    public static void main(String[] args) throws InterruptedException {
        GastadorMemoria gastadorMemoria = new GastadorMemoria();
        gastadorMemoria.start();
    }

    static class GastadorMemoria extends Thread {

        @Override
        public void run() {
            try {
                for (int i = 0; i < 5000; i++) {
                    Object object = new byte[1024 * 10]; //Usar la memoria

                    if ((i % 2) == 0) {
                        System.out.println("Añadiendo objeto permanente:" + i);
                        permanente.add(object);
                    }

                    Thread.sleep(200);
                }
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
