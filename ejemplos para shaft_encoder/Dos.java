package empotrados_shaft_encoder;

public class Dos {
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
		int conteo = 0;
		int estado = 0;
		for(int i = 1; i < 9; i++){
			//tres//
			 if(vA[i] == 0 && vB[i] == 0){
				 if(estado == 2){					 
					 conteo--;
				 }else{
					 conteo++;
				 }
				 estado = 0;
			 }else if(vA[i] == 0 && vB[i] == 1){
				 if(estado == 0){					 
					 conteo--;
				 }else{
					 conteo++;
				 }
				 estado = 1;
			 }else if(vA[i] == 1 && vB[i] == 0){
				 if(estado == 3){					 
					 conteo--;
				 }else{
					 conteo++;
				 }
				 estado = 2;
			 }else {
				 if(estado == 1){					 
					 conteo--;
				 }else{
					 conteo++;
				 }
				 estado = 3;
			 }
			 //DOS//
			/*if(estado == 0){
				if(vA[i]==1 && vB[i] == 1){
					conteo--;
					estado = 1;
				}else if(vB[i] == 1){
					conteo--;
					estado = 0;
				}else if(vA[i]==1){
					conteo++;
					estado = 1;
				}else {
					conteo++;
					estado = 0;
				}
			}else{
				if(vA[i]==1 && vB[i] == 1){
					conteo++;
					estado = 1;
				}else if(vB[i] == 1){
					conteo++;
					estado = 0;
				}else if(vA[i]==1){
					conteo--;
					estado = 1;
				}else {
					conteo--;
					estado = 0;
				}
			}*/
			System.out.println("conteo: " + conteo + ", en i: "+i +" estado: "+estado );
		}
		System.out.println("conteo final:" + conteo);
	}
}
