package br.com.controlador_de_voo;

import java.util.concurrent.Semaphore;

public class AviaoDecolando extends Thread {
	private int numVoo;
	private Semaphore semaforo;
	
	public AviaoDecolando(int num, Semaphore sem) {
		this.numVoo = num;
		this.semaforo = sem;
		this.setPriority(5);
	}
	
	private void aviao_quer_decolar() {
		try {
			this.semaforo.acquire();
			aviao_decolou();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			this.semaforo.release();
		}
	}
	
	private void aviao_decolou() {
		System.out.println("AVIÃO " + this.numVoo + " DECOLANDO");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("AVIÃO " + this.numVoo + " DECOLOU");
	}
	
	public void run() {
		aviao_quer_decolar();
	}
}
