package empotrados_shaft_encoder;

public class Uno {
	public static void main(String[] args){
		//int vA[] = {0,1,1,0,1,0,0,0,0};
		//int vB[] = {0,0,1,1,1,1,0,1,0};
		
		//int vA[] = {0,1,1,1,1,1,1,0,0};
		//int vB[] = {0,0,1,0,1,0,1,1,0};
		
		//int vA[] = {0,1,0,1,0,1,1,0,0};
		//int vB[] = {0,0,0,0,0,0,1,1,0}; 
		
		//int vA[] = {0,1,0,1,0,0,0,0,1};
		//int vB[] = {0,0,0,0,0,1,0,1,1}; 
		
		//int vA[] = {0,1,1,0,0,1,0,1,0};
		//int vB[] = {0,0,1,1,0,0,0,0,0};
		
		//int vA[] = {0,1,1,0,0,1,1,0,0};
		//int vB[] = {0,0,1,1,0,0,1,1,0};
		
		int vA[] = {0,0,1,1,0,0,1,1,0};
		int vB[] = {0,1,1,0,0,1,1,0,0};
		int A = 0;
		int conteo = 0;
		String operacion = "suma";
		for(int i = 1; i < 9; i++){
			if(vB[i]==1){		
				if(A == 0 && vA[i] == 0){
					conteo--;
					operacion = "suma";
				}else if(A == 0 && vA[i] == 1){
					conteo--;
					operacion = "resta";
				}else if(A == 1 && vA[i] == 0){
					conteo++;
					operacion = "suma";
				}else{
					conteo++;
					operacion = "resta";
				}	
			}else{
				if(operacion.equals("suma")){
					if( A==1 && vA[i]==0){
						operacion = "resta";
						conteo--;
					}else{
						conteo++;
					}
		
				}else {		
					 if( A==0 && vA[i]==1){
						operacion = "suma";
						conteo++;
					}else{
						conteo--;
					}
				}
			}
			A=vA[i];
			System.out.println("conteo: " + conteo + ", en i: "+i +" operacion: "+operacion);
		}
		System.out.println("conteo final:" + conteo);
	}
	
}
/*if(A==0 && Aux == 0){
if(vA[i]==0){
	operacion = "suma";
	conteo--;
}else{
	operacion = "resta";//--
	conteo--;
}						
}else if(Aux == 0 && A==1){
if(vA[i]==0){
	operacion = "suma";
	conteo++;
}else{
	operacion = "resta";
	conteo++;
}
}else if( Aux == 1 && A==0){			
if(vA[i]==0){
	operacion = "suma";
	conteo--;
}else{
	operacion = "resta";
	conteo--;
}
}else if(A==1 && Aux == 1){
if(vA[i]==0){					
	operacion = "suma";
	conteo++;
}else{
	operacion = "resta";
	conteo++;
}
}*/