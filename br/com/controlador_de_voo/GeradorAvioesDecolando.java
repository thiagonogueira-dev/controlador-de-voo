package br.com.controlador_de_voo;

import java.util.concurrent.Semaphore;

public class GeradorAvioesDecolando extends Thread {
	private int numAvioes;
	private Semaphore semaforo;
	
	public GeradorAvioesDecolando(int num, Semaphore sem) {
		this.numAvioes = num;
		this.semaforo = sem;
	}
	
	public void run(){
		int numAv = 1;
		for(int i = 0; i < numAvioes; i++) {
			AviaoDecolando avDecolando = new AviaoDecolando(numAv, semaforo);
			avDecolando.start();
			numAv += 2;
			double intervalo = 1000 + (4000 - 1000) * Math.random();
			try {
				Thread.sleep((int) intervalo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
