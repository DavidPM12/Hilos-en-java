package Ejercicio3;

import java.util.ArrayList;

public class Lonja {

    private int numero = 0;
    private ArrayList<Integer> lonja;

    public Lonja(int numero) {
        this.numero = numero;
        this.lonja = new ArrayList<Integer>();
    }

    public synchronized void echarAlalonja(int numatun) {
        while (lonja.size() >= 6) {
            System.out.println("\tLONJA LLENA: Esperando comprador ");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        lonja.add(numatun);
        System.out.println("**********************************");
        System.out.println("************A la venta:  " + numatun + "********");
        System.out.println("**********************************");
        numatun++;
        notifyAll();
    }

    public synchronized int sacardelalonja(int numerocomprador) {
        while (lonja.size() == 0) {
            System.out.println("*********************LONJA VACÍA: Esperando pescador ");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int numatun = lonja.remove(0);
        int atumcompra = (int) ((Math.random() * 3) + 1);
        if (atumcompra > lonja.size()) {
            System.out.println("El comprador " + numerocomprador + " compra " + 1 + ":");
            System.out.println("El atún " + numatun);
        } else {
            System.out.println("El comprador " + numerocomprador + " compra " + atumcompra + ":");
            for (int i = 0; i < atumcompra; i++) {
                System.out.println("El atún " + numatun);
                numatun++;
            }
        }

        notifyAll();
        return numatun;
    }
}
