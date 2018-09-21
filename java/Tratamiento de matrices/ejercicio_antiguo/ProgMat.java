
public class ProgMat {
public static void main(String[] args){
int [][] ms={{1,2,3},
			 {2,1,4},
			 {3,4,5}};
int [][] mns={{1,2,3},
			  {7,1,4},
			  {3,4,5}};
int [][] mt={{1,2,3},
		     {0,1,4},
		     {0,0,5}};
Matriz matriz_ms=new Matriz(ms);
Matriz matriz_mns=new Matriz(mns);
Matriz matriz_mt=new Matriz(mt);
System.out.println(matriz_ms);
if (matriz_ms.simetrica()) System.out.println("Es simetrica");
else System.out.println("No es simetrica");
System.out.println(matriz_mns);
if (matriz_mns.simetrica()) System.out.println("Es simetrica");
else System.out.println("No es simetrica");
System.out.println(matriz_mt);
if (matriz_mt.triangular()) System.out.println("Es triangular");
else System.out.println("No es triangular");
System.out.println(matriz_mns);
if (matriz_mns.triangular()) System.out.println("Es triangular");
else System.out.println("No es triangular");
System.out.println("suma Matrices");
System.out.println(matriz_ms);
System.out.println("MAS");
System.out.println(matriz_mns);
System.out.println("IGUAL");
System.out.println(Matriz.suma(matriz_ms, matriz_mns));
System.out.println("producto Matrices");
System.out.println(matriz_ms);
System.out.println("POR");
System.out.println(matriz_mns);
System.out.println("IGUAL");
System.out.println(Matriz.producto(matriz_ms, matriz_mns));
System.out.println("TRAPUESTA de");
System.out.println(matriz_mns);
System.out.println("IGUAL");
System.out.println(matriz_mns.transpuesta());
System.out.println("TRANPONER");
System.out.println(matriz_mns);
matriz_mns.transponer();
System.out.println("QUEDA");
System.out.println(matriz_mns);
}
}