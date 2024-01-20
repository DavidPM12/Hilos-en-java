package Ejercicio3;

public class DiaMercado {
	public static void main(String[] args) throws InterruptedException {
		int tam=6;
		//crear la lonja y los hilos
		Lonja lonja=new Lonja(tam);
		Comprador c1=new Comprador(lonja, 1);
		Comprador c2=new Comprador(lonja, 2);
		Comprador c3=new Comprador(lonja, 3);
		Pescador p=new Pescador(lonja);
		p.start();
		c1.start();
		c2.start();
		c3.start();
		
		p.join();
		c1.join();
		c2.join();
		c3.join();
		
	}
}