package controller;

import java.util.concurrent.Semaphore;

public class ThreadCruzamento extends Thread {

	private Semaphore semaforo;
	private String sentido;
	private int carro;

	public ThreadCruzamento(Semaphore semaforo, int carro) {
		this.semaforo = semaforo;
		this.carro = carro;
	}

	@Override
	public void run() {
		try {
			semaforo.acquire();
			sleep(1000);
			andar();
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
		} finally {
			semaforo.release();
		}
	}

	private void andar() {
		int sentido = (int) ((Math.random() * 3) + 1);
		switch (sentido) {
		case 1:
			System.out.println("Veículo #" + carro + " está virando a direita.");
			break;

		case 2:
			System.out.println("Veículo #" + carro + " está virando a esquerda.");
			break;

		case 3:
			System.out.println("Veículo #" + carro + " indo reto.");
			break;
		}
	}
}
