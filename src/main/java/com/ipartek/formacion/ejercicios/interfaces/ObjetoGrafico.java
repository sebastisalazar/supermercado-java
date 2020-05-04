package com.ipartek.formacion.ejercicios.interfaces;

/**
 * Una Clase es abstract cuando tiene almenos un metodo abstract
 * No se pueden crear objetos de esta Clase, porque le falta implementar el metodo dibujar
 *
 */
public abstract class ObjetoGrafico {
	
	
	void mover(int x, int y) {
		System.out.println("Nos hemos movido a  la nueva posicvion x=" + x + " y=" + y);
	}

	abstract void dibujar();
	
}
