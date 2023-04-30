package br.com.controlador_de_voo;

import java.util.concurrent.Semaphore;

public class TesteMain {
	public static void main(String[] args) {
		Semaphore sem = new Semaphore(1);
		GeradorAvioesDecolando gerAvDecolando = new GeradorAvioesDecolando(20, sem);
		GeradorAvioesPousando gerAvPousando = new GeradorAvioesPousando(20, sem);
		gerAvDecolando.start();
		gerAvPousando.start();
	}
}
