package distribucion;


/**
 * 
 * @author Dariel
 *
 */
public class Distribucion {
	/**
	 * Para todo valor de v[] tendremos:
	 * 		-si:v[i]<=frontera -> en v[] todo j perteneciente a [0,i] cumple v[j]<=0
	 * 		-si:v[i]> frontera -> en v[] todo j perteneciente a [i, v.length-1] cumple v[j]>0
	 * Coste: O(n)
	 * @param v T array
	 * @param frontera T
	 * 
	 */
	public static <T extends Comparable<T>> void distribucion(T[] v, T frontera) {
		int inferior = 0, superior = v.length-1;
		while(inferior != superior+1){
			if(v[inferior].compareTo(frontera) <= 0) {
				inferior++;
			} else if( v[superior].compareTo(frontera) > 0) {
				superior--;
			} else {
				T dato = v[inferior];
				v[inferior] = v[superior];
				v[superior] = dato;
				inferior--;
				superior--;
			}
		}
	}
	/**
	 * Para todo valor de v[] tendremos:
	 * 		-si:v[i]<=frontera -> en v[] todo j perteneciente a [0,i] cumple v[j]<=0
	 * 		-si:v[i]> frontera -> en v[] todo j perteneciente a [i, v.length-1] cumple v[j]>0
	 * Coste: O(n)
	 * @param v T array
	 * @param frontera int
	 * 
	 */
	public static void distribucion(int[] v, int frontera) {
		int inferior = 0, superior = v.length-1;
		while(inferior != superior+1){
			if(v[inferior] <= frontera) {
				inferior++;
			} else if( v[superior] > frontera) {
				superior--;
			} else {
				int dato = v[inferior];
				v[inferior] = v[superior];
				v[superior] = dato;
				inferior--;
				superior--;
			}
		}
	}

}
