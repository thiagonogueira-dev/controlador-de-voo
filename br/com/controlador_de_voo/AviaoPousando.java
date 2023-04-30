package br.com.controlador_de_voo;

import java.util.concurrent.Semaphore;

public class AviaoPousando extends Thread {
	private int numVoo;
	private Semaphore semaforo;
	
	public AviaoPousando(int num, Semaphore sem) {
		this.numVoo = num;
		this.semaforo = sem;
		this.setPriority(7);
	}

	private void aviao_quer_pousar() {
		try {
			this.semaforo.acquire();
			aviao_pousou();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			this.semaforo.release();
		}
	}
	
	private void aviao_pousou(){
		System.out.println("AVIÃO " + this.numVoo + " POUSANDO");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("AVIÃO " + this.numVoo + " POUSOU");
	}
	
	public void run(){
		aviao_quer_pousar();
	}
	
}
