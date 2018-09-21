
public class Fecha {
	 private int _dia;
	 private int _mes;
	 private int _agno;
	 
	 Fecha (int dia, int mes, int agno){
		 _dia=dia;
		 _mes=mes;
		 _agno=agno;
	 }
	 
	 public static Fecha parse(String cadena){
		 String []  values= cadena.split("\\-");
		 int dia = Integer.parseInt(values[0]);
		 int mes = Integer.parseInt(values[1]);
		 int agno = Integer.parseInt(values[2]);

		 return new Fecha (dia,mes,agno) ;
	 }
	 
	 public String toString(){
		 return _dia+"-"+_mes+"-"+_agno;
	 }
	 
	 public  int getDia(){
		 return _dia;
	 }
	 
	 public  int getMes(){
		 return _mes;
	 }

	 public  int getAgno(){
		 return _agno;
	 }
	 public boolean menor(Fecha of){
		 if (_agno<of.getAgno() ||
		     (_agno == of.getAgno() && _mes < of.getMes()) || 
		     (_agno == of.getAgno() && _mes==of.getMes() && _dia < of.getDia())) return true;
		 else return false;
	 }
	 
	 public boolean Igual(Fecha of){
		 if (_agno==of.getAgno() && _mes ==of.getMes() && _dia == of.getDia()) return true;
		 else return false;
	 }
}