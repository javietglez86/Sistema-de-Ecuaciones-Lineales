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
					
					matrizResultante.matriz[i][b]=auxiliar;
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
