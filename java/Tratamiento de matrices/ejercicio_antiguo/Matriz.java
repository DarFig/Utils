import java.util.Scanner;

public class Matriz {
	private int _filas;//se definen las variables privadas para protegerlas
	private int _columnas;
	private int [][] _m;
	

	public Matriz (int[][] m){
		_filas = m.length;
		_columnas = m[0].length;
		_m = new int[_filas][_columnas];//se guarda espacio en memoria para la matriz
		for(int i = 0; i<m.length;i++){
			for(int j = 0; j<m[0].length;j++){
				_m[i][j] = m[i][j];
			}
		}
	}

	public Matriz (int filas, int columnas){
		_filas = filas;
		_columnas = columnas;
		_m = new int[_filas][_columnas];
	}
	public int getValAt(int fila, int columna){//metodos get para devolver valor de una posicion especifica
		return _m [fila] [columna];
	
	}
	public void setValAt(int fila, int columna, int valor){//metodo para guaredar un valor en una posicion especifica
		_m [fila] [columna] = valor;
	
	}
	public int getFilas(){//devulve el número de filas
		return _filas;
	
	}
	public int getColumnas(){//devuelve el número de columnas
		return _columnas;
	
	}
	public int [] getFila(int fila){// devuelve un array con los valores de una fila
		int [] auxFila = new int [_columnas];
		for(int j = 0; j<_columnas;j++){
			auxFila[j] = _m [fila] [j];
		}
		return auxFila;
	}
	public int [] getColumna(int columna){//devuelve un array con los valores de una columna
		int [] auxColumna = new int [_filas];
		for(int j = 0; j<_filas;j++){
			auxColumna[j] = _m [j] [columna];
		}
		return auxColumna;
	
	}
	public String toString (){//devuelve una cadena que contiene la matriz para su impresión por pantalla
		String cadena = " ";
		int i = 0, j;
		while(i < _filas){
		j = 0;
		while(j < _columnas){
		cadena= cadena + " " + _m[i][j];
		j++;
		}
		cadena = cadena + "\n ";
		i++;
		}
		return cadena;
	}
	public static Matriz leeMatriz(){//lee matriz cuadrada
		Scanner entrada = new Scanner(System.in);
		System.out.println("Leer matriz");
		String lineaMatriz = entrada.nextLine();//lectura de la primera linea
		String[] valoresLinea = lineaMatriz.split(" ");
		int dim = valoresLinea.length;//dimensión de la matriz
		int[][] matriz = new int[dim][dim];//se guarda espacio en memoria para la nueva matriz
		for (int i = 0; i < dim; i++){//guardamos los valores leidos en la matriz
			for(int j = 0; j < dim; j++){
				matriz[i][j] = Integer.parseInt(valoresLinea[j]);
			}
			if (i != dim-1){
				lineaMatriz = entrada.nextLine();
				valoresLinea = lineaMatriz.split(" ");
			}
		}
		Matriz leerMatriz = new Matriz(matriz);//convertimos la matriz en un objeto del tipo de la clase Matriz
		return leerMatriz;
				
	}
	public static Matriz leeMatriz(int dim){//lee matriz cuadrada
		Scanner entrada = new Scanner(System.in);
		int[] [] matriz = new int [dim] [dim];//aqui recibimos la dimensión por lo cual se inicializa la matriz de inmediato
		for(int i = 0; i<dim; i++){
			for(int j = 0; j<dim; j++){
				matriz [i][j] = entrada.nextInt();
			}
		}
		Matriz leerMatriz = new Matriz(matriz);
		return leerMatriz;
	}
	public static Matriz leeMatriz(int filas, int columnas){
		Scanner entrada = new Scanner(System.in);
		int[] [] matriz = new int [filas] [columnas];//aqui la matriz no es cuadrada por lo que tenemos distintos valores
		for(int i = 0; i<filas; i++){
			for(int j = 0; j<columnas; j++){
				matriz [i][j] = entrada.nextInt();
			}
		}
		Matriz leerMatriz = new Matriz(matriz);
		return leerMatriz;
	
	}
	public static Matriz producto (Matriz m1, Matriz m2){
		if (m1.getColumnas() == m2.getFilas()) {//para poder multiplicar la columnas de la primera deben ser iguales a las filas de la segunda
		      Matriz producto = new Matriz(m1.getFilas(), m2.getColumnas());// espacio de la nueva matriz, un objeto del tipo de la clase Matriz
		      for ( int i = 0 ; i < m1.getFilas() ; i++ ) { 
		        for ( int j = 0 ; j < m2.getColumnas() ; j++ ) { 
		          int suma = 0;// Se calcula el valor a almacenar como la suma de varias multiplicaciones
		          for ( int k = 0 ; k < m1.getColumnas() ; k++ ) {
		            suma += m1.getValAt(i, k) * m2.getValAt(k, j);
		          } 
		          producto.setValAt(i, j, suma);// Se almacena el valor en la posición adecuada
		        }
		      }
		      return producto;// Devolvemos la matriz recien creada que contiene la multiplicación
		    } 
		else // Devolvemos null cuando no es posible hacer la multiplicación
			return null;	    
	}
	public static Matriz suma (Matriz m1, Matriz m2){
		if((m1.getFilas()==m2.getFilas())&&(m1.getColumnas()==m2.getColumnas())){//par que la suma sea posible deben coincidir las dimensiones de las matrices
			Matriz suma = new Matriz(m1.getFilas(), m1.getColumnas());//el objeto suma de tipo Matriz para guardar la matriz reultante
		    for (int i=0; i < m1.getFilas(); i++) {
		        for (int j=0; j < m1.getColumnas(); j++) {	
		        	suma.setValAt(i, j, (m1.getValAt(i, j) + m2.getValAt(i, j)));//guardamos el valor en la posicion correspondiente	
		        }
		    }return suma;//devolvemos la matriz suma
		}
		else
			return null;//en caso de no ser posible las suma se devuelve nulo
	}
	public Matriz transpuesta (){//transpone una matriz y devuelve la matriz resultante
		int matriz[][] = new int [_m[0].length][_m.length];
        for(int i = 0; i < _m.length; i++){
            for (int j = 0; j <_m[0].length; j++){
                matriz[j][i] = _m[i][j];
            }
        }
        Matriz transpuesta = new Matriz(matriz);
		return transpuesta;
	}
	public void transponer (){//traspone la matriz reescribiendo el resultado en la misma dirección de memoria
		int matriz[][] = new int [_m[0].length][_m.length];
		for(int i = 0; i < _m.length; i++){
            for (int j = 0; j <_m[0].length; j++){
            	matriz[j] [i] = _m[i][j];//se guardará el proceso en otra dirección mientras se calcula el resultado total
            }
        }
		for(int i = 0; i < _m.length; i++){
            for (int j = 0; j <_m[0].length; j++){
            	_m[i][j]=matriz[i][j];//finalmente lo volvemos a poner en la dirección de memoria inicial reescribiendo los valores iniciales
            }
		}    
	}
	public boolean simetrica(){//nos dirá si una matriz es o no simétrica respecto a la diagonal principal
		boolean simetrica = true;
		int i, j;
		i = 0;
		while((i<_m.length)&&(simetrica)){//se comprueban las posiciones en el array bideimensional
			j = 1;
			while((j<_m[i].length)&&(simetrica)){
				simetrica = (_m[i][j] == _m[j][i]);
				j++;
			}
			i++;
		}
		return simetrica;
	}
	public boolean triangular(){//ceros debajo de la diagonal principal
		boolean triangular = true;
		int i = 1, j = 0;
		while((i<_m.length)&&(triangular)){
			while((j<i)&&(triangular)){
				if(_m[i][j]!=0)
					triangular = false;
				else
					j++;
			}
			i++;
		}
		return triangular;
	}
}
