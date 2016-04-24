package ar.edu.uno.poo2.modulo;

public class Vector {
	private Double[] vector;
	private int ultimo=0;

	public Vector(int dimension){
		vector= new Double[dimension];
	}

	public boolean agregar(Double valor){
		if (ultimo < vector.length) {
			vector[ultimo]=valor;
			ultimo++;
			return true;
		}else
			return false;
	}

	public void sumar(Vector otroVector) throws MissMatchDimensionException{
		try{
			if (this.vector.length==otroVector.vector.length){
				for (int i = 0; i < this.vector.length; i++)
					this.vector[i]+=otroVector.vector[i];
			}
			else
				throw new MissMatchDimensionException();
		}
		catch(MissMatchDimensionException e){

			System.out.println(e.getTextoError());

		}
	}

	public void restar(Vector otroVector) throws MissMatchDimensionException{
		for (int i = 0; i < otroVector.vector.length; i++)
			otroVector.vector[i]*=-1;
		this.sumar(otroVector);
	}

	public Double productoEscalar(Vector otroVector) throws MissMatchDimensionException{

		Double producto=0.0;
		try{

			if (this.vector.length==otroVector.vector.length){
				for (int i = 0; i < this.vector.length; i++)
					producto+=this.vector[i]*otroVector.vector[i];
			}
			else
				throw new MissMatchDimensionException();

		}
		catch(MissMatchDimensionException e){

			System.out.println(e.getTextoError());

		}
		return producto; 


	}

	public void productoXEscalar(Double escalar){
		for (int i = 0; i < this.vector.length; i++)
			this.vector[i]=this.vector[i]*escalar;

	}
	/*
	public Vector productoXMatriz(){
		(a b c)|d e f| =(a*d+b*g+c*j; ... ; ... )
			   |g h i|
			   |j k l|		
	}
	 */

	public Double normaUno(){
		Double norma=0.0;
		for (int i=0; i<this.vector.length;i++)
			if(this.vector[i]>=0)
				norma+=this.vector[i];
			else
				norma-=this.vector[i];
		return norma;
	}

	public Double normaDos(){
		Double norma=0.0;
		for (int i=0; i<this.vector.length;i++){

			norma+=this.vector[i]*this.vector[i];
		}
		return Math.sqrt(norma);
	}

	public Double normaInfinito(){
		Double norma=(this.vector[0]>=0)?this.vector[0]:-this.vector[0];

		for (int i=1; i<this.vector.length;i++)
			if (this.vector[i]>=0 && this.vector[i]>norma)
				norma=this.vector[i];
			else
				if (this.vector[i]<0 && -this.vector[i]>norma)
					norma=-this.vector[i];
		return norma;
	}	

	@Override
	public boolean equals(Object otroVector) {
		boolean bandera=true; 
		if (otroVector.getClass().getSimpleName()=="Vector"){
			Vector temporal=(Vector)otroVector;
			for (int i =0; i< this.vector.length; i++)
				if (this.vector[i]!=temporal.vector[i])
					bandera=false;
		}
		else
			bandera= false;
		return bandera;
	}

	@Override
	public String toString() {
		String cadena="(";
		for (int i = 0; i < this.vector.length; i++)
			cadena+=this.vector[i]+" , ";

		cadena=cadena.substring(0, (cadena.length())-3);
		cadena+=")";
		return cadena;
	}

}
