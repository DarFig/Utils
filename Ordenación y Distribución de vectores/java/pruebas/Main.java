package pruebas;

import distribucion.Distribucion;
import ordenacion.Ordenacion;

public class Main {
	public static void imprimir(int[] v){
		for(int i : v){
			System.out.print(i+" ");
		}
		System.out.println("");
	}
	public static boolean compare(int[] v1, int[] v2){
		for (int i = 0; i<v1.length-1; i++){
			if(v1[i]!=v2[i]){
				return false;
			}
		}
		return true;
	}
	public static void pruebaDistribucion(){
		System.out.println("=================================");
		int v[] = {10, 20, 15, 4, 5, 40, 8, 4, 30, 3};
		int a = 15;
		System.out.print("Antes: ");
		imprimir(v);
		Distribucion.distribucion(v, a);
		System.out.print("Distribuido respecto a "+ a + ": ");
		imprimir(v);
	}
	public static void pruebaSeleccion(){
		System.out.println("=================================");
		int v1[] = {3, 4, 4, 5, 8, 10, 15, 20, 30, 40};
		int v[] = {10, 20, 15, 4, 5, 40, 8, 4, 30, 3};
		System.out.print("Antes: ");
		imprimir(v);
		Ordenacion.seleccion(v);
		System.out.print("Ordenado: ");
		imprimir(v);
		if(compare(v1,v)) {
			System.out.println("Prueba correcta");
		}else {
			System.out.println("Prueba incorrecta");
		}
	}
	public static void pruebaInsercion(){
		System.out.println("=================================");
		int v1[] = {3, 4, 4, 5, 8, 10, 15, 20, 30, 40};
		int v[] = {10, 20, 15, 4, 5, 40, 8, 4, 30, 3};
		System.out.print("Antes: ");
		imprimir(v);
		Ordenacion.insercion(v);
		System.out.print("Ordenado: ");
		imprimir(v);
		if(compare(v1,v)) {
			System.out.println("Prueba correcta");
		}else {
			System.out.println("Prueba incorrecta");
		}
	}
	public static void pruebaIntercambio(){
		System.out.println("=================================");
		int v1[] = {3, 4, 4, 5, 8, 10, 15, 20, 30, 40};
		int v[] = {10, 20, 15, 4, 5, 40, 8, 4, 30, 3};
		System.out.print("Antes: ");
		imprimir(v);
		Ordenacion.intercambio(v);
		System.out.print("Ordenado: ");
		imprimir(v);
		if(compare(v1,v)) {
			System.out.println("Prueba correcta");
		}else {
			System.out.println("Prueba incorrecta");
		}
	}
	public static void main(String [] args){
		//pruebaDistribucion();
		//pruebaSeleccion();
		//pruebaInsercion();
		pruebaIntercambio();
	}
}
