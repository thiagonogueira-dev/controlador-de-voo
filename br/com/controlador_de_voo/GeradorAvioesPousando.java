package br.com.controlador_de_voo;

import java.util.concurrent.Semaphore;

public class GeradorAvioesPousando extends Thread {
	private int numAvioes;
	private Semaphore semaforo;
	
	public GeradorAvioesPousando(int num, Semaphore sem) {
		this.numAvioes = num;
		this.semaforo = sem;
	}
	
	public void run() {
		int numAv = 2;
		for(int i = 0; i < numAvioes; i++) {
			AviaoPousando avPousando = new AviaoPousando(numAv, semaforo);
			avPousando.start();
			numAv += 2;
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
