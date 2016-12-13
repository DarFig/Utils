package ordenacion;


public class Ordenacion {
	
	/**
	 * Ordenación en coste asintótico cuadrático en el número de datos
	 * @param v T
	 */
	public static <T extends Comparable<T>> void seleccion(T v[]) {
		for(int i = 0; i!=v.length-1; i++) {
			int iMenor = i, j = i;
			while(j!=v.length-1) {
				j++;
				if(v[j].compareTo(v[iMenor])<0) {
					iMenor = j;
				}
			}
			T dato = v[i];
			v[i] = v[iMenor];
			v[iMenor] = dato;
		}
	}
	/**
	 * Ordenación en coste asintótico cuadrático en el número de datos
	 * @param v int
	 */
	public static void seleccion(int v[]) {
		for(int i = 0; i!=v.length-1; i++) {
			int iMenor = i, j = i;
			while(j!=v.length-1) {
				j++;
				if(v[j] < v[iMenor]) {
					iMenor = j;
				}
			}
			int dato = v[i];
			v[i] = v[iMenor];
			v[iMenor] = dato;
		}
	}
}
