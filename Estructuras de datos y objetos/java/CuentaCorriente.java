/*
FICHERO:CuentaCorriente.java
DESCRIPCION: la clase CuentaCorriente define y gestiona objetos del tipo CuentaCorriente.
*/
public class CuentaCorriente {

	private String _titular;
	private float _saldo = 0;
	private NIF _dni;
	private final static int MAX = 5;
	private  float [] _movimientos = new float [MAX];
	private Fecha [] _fechas = new Fecha [MAX];
	private int _numMovimientos = 0;
	

	public CuentaCorriente(String t, NIF dni)
	{
		_titular = t;
		_dni = dni;
	}
	
	public CuentaCorriente(String t, int s, NIF dni)
	{
		_titular = t;
		_saldo = s;
		_dni = dni;
	}
	
	public CuentaCorriente(String t, int s, NIF dni, Fecha[] fechas, float[] movimientos)
	{
		_titular = t;
		_saldo = s;
		_dni = dni;
		_fechas = fechas;
		float[] movimientos_cp=new float[MAX];
		
		for (int i=0; i< movimientos.length;i++){
			movimientos_cp[i] = movimientos[i];
		}
		_movimientos = movimientos_cp;
		Fecha[] fechas_cp = new Fecha[MAX];
		for (int i = 0; i < movimientos.length; i++){
			fechas_cp[i] = fechas[i];
		}
		_fechas  = fechas_cp;
		_movimientos = movimientos_cp;
		_numMovimientos = movimientos.length;
	}
	
	public static CuentaCorriente fusionaFecha(CuentaCorriente cc1, CuentaCorriente cc2){
		
		CuentaCorriente mezclados = new CuentaCorriente(cc1.getTitular(), cc1.getDNI());
		
		for (int i = 0; i<cc1.getNumMovimientos(); i++){
			mezclados.addMovimiento(cc1.getMovimiento(i),cc1.getFecha(i));
		}
		for (int i = 0; i<cc2.getNumMovimientos(); i++){
			mezclados.addMovimiento(cc2.getMovimiento(i),cc2.getFecha(i));

		}
		mezclados.ordenaFecha();
		
		return mezclados;
	}
	//métodos set y get
	public void setTitular(String t)
	{
		_titular = t;
	}
	
	public void setSaldo(float s)
	{
		_saldo = s;
	}
	
	public void setNIF(NIF dni)
	{
		_dni = dni;
	}
	
	public String getTitular()
	{
		return _titular;
	}
	
	public float getSaldo()
	{
		return _saldo;
	}
	public NIF getDNI()
	{
		return _dni;
	}
	
	public void incrementoSaldo(int s)
	{
		_saldo += s;
	}
	
	public float  getMovimiento(int i){
		 return _movimientos[i];
	}
	
	
	public int  getNumMovimientos(){
		 return _numMovimientos;
	}
	public void setNumMovimientos(int cantidad){
		_numMovimientos = cantidad;
	}
	
	public Fecha  getFecha(int i){
		 return _fechas[i];
	}
	

	public void  setMovimientos(float [] movimientos){
		  _movimientos=movimientos;
	}
	
	public void  setFechas(Fecha [] fechas){
		 _fechas=fechas;
	}
	
	
	public float [] getMovimientos(){
		float [] copia = new float [MAX];
		for (int i = 0; i<MAX; i++){
			copia[i] = _movimientos[i];
		}
		return copia;
	}
	public Fecha [] getFechas(){
		Fecha [] copia = new Fecha [MAX];
		for (int i=0; i<MAX;i++){
			copia[i]=_fechas[i];
		}
		return copia;
	}
       
       	
	public void addMovimiento(float movimiento, Fecha fecha){
		//metodo que añade un movimineto, si no caben más se fusionan los dos primeros
		int cantMovimientos = getNumMovimientos();//variable para la cantidad original de movimientos
		float[] nuevosMovimientos = new float[cantMovimientos+1];
		//se inicializa en la cantidad original más el nuevo movimiento
		Fecha[] nuevasFechas = new Fecha[cantMovimientos+1];
		if(cantMovimientos<MAX){//si no se ha llegado al número máximo de movimientos
			for(int i = 0; i<cantMovimientos; i++){
				nuevosMovimientos[i] = getMovimiento(i);//ponemos todos los movimientos actuales
				nuevasFechas[i] = getFecha(i);//ponemos todas las fechas actuales
			}
			nuevosMovimientos[cantMovimientos] = movimiento;//se agrega el nuevo movimiento
			nuevasFechas[cantMovimientos] = fecha;//se agrega el nuevo movimiento
			setMovimientos(nuevosMovimientos);
			//se cambian los movimientos y las fechas por los nuevos array
			setFechas(nuevasFechas);
			setNumMovimientos(cantMovimientos+1);//incrementamos el némero total de movimientos
			ordenaFecha();//se ordena por fechas
			}
		else{//si pasaba del número máximo de movimientos
			nuevosMovimientos = getMovimientos(); 
			//en este caso los array tendran el mismo tamaño
			nuevasFechas = getFechas();
			//se procede a fusionar los dos primeros movimientos
			nuevosMovimientos[0]+= nuevosMovimientos[1];
			nuevasFechas[0] = nuevasFechas[1];
			nuevosMovimientos[1] = movimiento;
			//se añade el nuevo movimiento y la nueva fecha
			nuevasFechas[1] = fecha;
			setMovimientos(nuevosMovimientos);//se pasan los arrays a las variables privadas
			setFechas(nuevasFechas);
			setNumMovimientos(cantMovimientos+1);
			ordenaFecha();//finalmente se ordena por fechas
		}
	}

	public String toString(){
		String salida =_dni.toString()+" "+_numMovimientos;
		for (int i=0; i<_numMovimientos;i++){
		salida+=" "+_movimientos[i]+" "+_fechas[i];	
		}
		salida+=" "+_titular;
		return salida;
	}
	
	public String toPantalla(){
		String salida ="-"+ _dni.toString()+" "+ _titular + " Movimientos:";
		for (int i=0; i<_numMovimientos;i++){
		salida+=" "+_movimientos[i]+" "+_fechas[i];	
		}
		salida+=" "+_titular;
		return salida;
	}
	
	public void ordenaFecha(){
		int indiceMenor;
		Fecha valorMenor;
		Fecha auxFecha;
		float auxMovimiento;

		
		for(int i=0; i<_fechas.length; i++)
		{
			indiceMenor = i;
			valorMenor = _fechas[i];
			
			for(int j=i+1; j<_fechas.length; j++)
			{
				if (_fechas[j].menor(valorMenor))
				{
					indiceMenor = j;
					valorMenor = _fechas[j];
					
				}
			}
			
			auxFecha = _fechas[indiceMenor];
			_fechas[indiceMenor] = _fechas[i];
			_fechas[i] = auxFecha;
			auxMovimiento = _movimientos[indiceMenor];
			_movimientos[indiceMenor] = _movimientos[i];
			_movimientos[i] = auxMovimiento;
		}		
	}
	
}