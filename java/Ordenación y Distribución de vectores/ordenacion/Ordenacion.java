package ordenacion;


public class Ordenacion {
	//=====================================================
	//seleccion
	//=====================================================
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
	
	//=====================================================
	//insercion
	//=====================================================
	/**
	 * Ordenación en coste asintótico cuadrático en el número de datos
	 * @param v T
	*/
	public static <T extends Comparable<T>> void insercion(T v[]){
		for(int i = 1; i<=v.length-1; i++){
			T dato = v[i];
			int j = i, iLimite = 0;
			while(j!=iLimite){
				if(v[j-1].compareTo(dato)<0){
					iLimite = j;
				} else {
					v[j] = v[j-1];
					j--;
				}
			}
			v[j] = dato;
		}
	}
	
	/**
	 * Ordenación en coste asintótico cuadrático en el número de datos
	 * @param v int
	*/
	public static void insercion(int v[]){
		for(int i = 1; i<=v.length-1; i++){
			int dato = v[i];
			int j = i, iLimite = 0;
			while(j!=iLimite){
				if(v[j-1] < dato){
					iLimite = j;
				} else {
					v[j] = v[j-1];
					j--;
				}
			}
			v[j] = dato;
		}
	}
	
	//=====================================================
	//intercambio directo
	//=====================================================
	/**
	* Ordenación en coste asintótico cuadrático en el número de datos
	* @param v T
	*/
	public static <T extends Comparable<T>> void intercambio (T v[]){
		for(int i = 0; i < v.length; i++){
			for(int j = 0; j != v.length-1-i; j++){
				if(v[j+1].compareTo(v[j])<=0){
					T dato = v[j];
					v[j] = v[j+1];
					v[j+1] = dato;
				}
			}
		}
	}
		
	/**
	* Ordenación en coste asintótico cuadrático en el número de datos
	* @param v int
	*/
	public static void intercambio (int v[]){
		for(int i = 0; i < v.length; i++){
			for(int j = 0; j != v.length-1-i; j++){
				if(v[j+1]<=v[j]){
					int dato = v[j];
					v[j] = v[j+1];
					v[j+1] = dato;
				}
			}
		}
	}
	
	
}
	


