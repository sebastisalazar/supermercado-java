package com.ipartek.formacion.ejercicios.interfaces;

public class Prueba {

	public static void main(String[] args) {
		
		
		Canario c = new Canario();
		Perro p = new Perro();
		
		System.out.println( c.cantar() );
		System.out.println( p.cantar() );
		
		
		//no se pueden crear objetos de la calse asbtracta
		// ObjetoGrafico og = new ObjetoGrafico();
		
		Cuadrado cuadrado = new Cuadrado();
		
		cuadrado.mover(2, 3);  // este es el metodo implementado en ObjetoGrafico
		cuadrado.dibujar();   // este es el metodo sobreescrito en Cuadrado
		
		Triangulo tri = new Triangulo();
		tri.mover(1,1);
		tri.dibujar();
		
		
		

	}

}
