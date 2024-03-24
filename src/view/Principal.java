package view;

import java.util.concurrent.Semaphore;

import controller.ThreadCruzamento;

public class Principal {
	public static void main(String[] args) {

		Semaphore semaforo = new Semaphore(1);
		for (int i = 0; i < 10; i++) {
			Thread t = new ThreadCruzamento(semaforo, i);
			t.start();
		}
	}
}
