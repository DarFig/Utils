package pruebas;

import distribucion.Distribucion;

public class Main {
	public static void imprimir(int[] v){
		for(int i : v){
			System.out.print(i+" ");
		}
		System.out.println("");
	}
	public static void pruebaDistribucion(){
		int v[] = {10, 20, 15, 4, 5, 40, 8, 4, 30, 3};
		int a = 15;
		System.out.print("Antes: ");
		imprimir(v);
		Distribucion.distribucion(v, a);
		System.out.print("Distribuido respecto a "+ a + ": ");
		imprimir(v);

	}
	public static void main(String [] args){
		pruebaDistribucion();
	}
}
