public class NIF {
	private int _num;
	private char _letra;
	
	public NIF (int num){
		_num = num;
		_letra = calculaLetra(num);
	}
	
	public NIF (String num){
		char lastChar = num.charAt(num.length()-1);
		if (lastChar >= 'A' && lastChar <= 'Z') {
			_num =	Integer.parseInt(num.substring(0, num.length()-1));
			_letra = calculaLetra(_num);
			if (_letra != num.charAt(num.length()-1))
					System.out.println("Error letra. Cambio letra DNI");
		} else {
				_num =	Integer.parseInt(num);
				_letra = calculaLetra(_num);
		}
		
	}
	
	public int getNum(){
		return _num;
	}
	
	public char getLetra(){
		return _letra;
	}
	
	public static char calculaLetra(int dni){
    String juegoCaracteres="TRWAGMYFPDXBNJZSQVHLCKET";
    int modulo= dni % 23;
    char letra = juegoCaracteres.charAt(modulo);
    return letra; 
    } 
	
	public static NIF parseNIF(String num){
	    return new NIF(num); 
	} 
	
	public String toString(){
		return Integer.toString(_num) +_letra;
	}
	
	public boolean mayor(NIF dni){
		return _num > dni.getNum();
	}
	
	public boolean menor(NIF dni){
		return _num < dni.getNum();
	}	
	
	public boolean menorIgual(NIF dni){
		return _num <= dni.getNum();
	}	
	
	public boolean igual (NIF dni){
			return _num == dni.getNum();
	}
}