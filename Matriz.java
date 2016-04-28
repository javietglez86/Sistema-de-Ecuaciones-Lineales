package ar.edu.uno.poo2.modulo;

public class Matriz {
	private Double[][] matriz;
	private Integer i;
	private Integer j;


	public Matriz(Integer i, Integer j){
		this.matriz= new Double[i][j];
		this.setI(i);
		this.setJ(j);

	}

	public void agregar(Integer i, Integer j, Double valor){
		if(i<this.i && j<this.j){
			this.matriz[i][j] = valor;
		}

	}
	//metodos sumar overrideados

	public void sumar(Matriz otraMatriz) throws MissMatchDimensionException{
		try{
			if (this.getI()==otraMatriz.getI()&&this.getJ()==otraMatriz.getJ()){
				for (int i = 0; i < this.getI(); i++){
					for( int j=0; j < this.getJ(); j++){
						this.matriz[i][j]+=otraMatriz.matriz[i][j];
					}
				}

			}
			else
				throw new MissMatchDimensionException();
		}
		catch(MissMatchDimensionException e){

			System.out.println(e.getTextoError());

		}
	}

	// RESTAR

	public void restar(Matriz otraMatriz) throws MissMatchDimensionException{
		for (int i = 0; i < otraMatriz.getI(); i++){
			for(int j=0; j < otraMatriz.getJ(); j++){
				otraMatriz.matriz[i][j]*=-1;
			}
		}

		this.sumar(otraMatriz);
	}

	// Productos

	public Matriz producto(Matriz otraMatriz) throws MissMatchDimensionException{

		Matriz matrizResultante = new Matriz(this.getI(), otraMatriz.getJ());
		Double auxiliar = null;

		try{
			if (this.getJ()==otraMatriz.getI()){
				Integer b = 0;
				for(int i = 0;i<this.getI();i++){
					Integer a = 0;
					

					for(int j=0;j<this.getJ();j++){
						auxiliar+=this.matriz[i][j]*otraMatriz.matriz[a][b];
						a++;
					}
					
					matrizResultante.agregar(i, b, auxiliar);
					b++;
				}
			}
			else
				throw new MissMatchDimensionException();
		}
		catch(MissMatchDimensionException e){

			System.out.println(e.getTextoError());

		}
		return matrizResultante;
	}
	
	//Matriz Inversa
	
	public Matriz matrizInversa(){
		Matriz inversa = new Matriz(this.getI(),this.getJ());
		if (this.getI()==this.getJ()){
			double auxiliar;
			//inversa=
			for (int i=0; i<inversa.getI();i++)
				for (int j=0; j<inversa.getJ(); j++)
					if (i==j)
						inversa.agregar(i, j, 1.0);
					else
						inversa.agregar(i, j, 0.0);
			for (int i=0; i<this.getI(); i++){
				System.out.println("I "+i);
				System.out.println(this.toString());
				//Verificar antes que sea distinto de 0
				if (this.matriz[i][i]!=1.0){
					auxiliar = matriz[i][i];
					for (int j=0; j<this.getJ(); j++){
						this.matriz[i][j]=this.matriz[i][j]/auxiliar;
						//System.out.println(this.toString());
						inversa.matriz[i][j]=inversa.matriz[i][j]/auxiliar;
						//System.out.println(inversa.toString());
					}
				}
				for ( int k=i+1; k<this.getI(); k++){
					auxiliar=this.matriz[k][i];
					System.out.println("K "+k);
					System.out.println(this.toString());
					for ( int j=i; j<this.getJ(); j++){
						System.out.println("j= "+j);
						
						this.matriz[k][j]=this.matriz[k][j]-auxiliar*this.matriz[i][j];
						inversa.matriz[k][j]=inversa.matriz[k][j]-auxiliar*inversa.matriz[i][j];
						System.out.println(this.toString());
					}
				}
				
			}
		}
		else{
			//Arrojar excepcion
			System.out.println("La matriz debe ser cuadrada.");
		}
		return inversa;
	}
	


	// Getters y setters
	public Integer getI() {
		return i;
	}
	public void setI(Integer i) {
		this.i = i;
	}
	public Integer getJ() {
		return j;
	}
	public void setJ(Integer j) {
		this.j = j;
	}

}
