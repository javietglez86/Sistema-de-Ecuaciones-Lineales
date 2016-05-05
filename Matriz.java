package ar.edu.uno.poo2.modulo;

import java.util.Arrays;

public class Matriz {
	private double[][] matriz;
	private Integer i;
	private Integer j;
	
	public Matriz(Integer i, Integer j){
		this.matriz= new double[i][j];
		this.setI(i);
		this.setJ(j);
	}
	
	public void agregar(int i, int j, double dato){
		this.matriz[i][j]=dato;
	}
	
	public Matriz matrizInversa()throws NoInversibleException{
		//Creo original para no modificar la matriz
		Matriz original = new Matriz(this.getI(), this.getJ());
		for (int i=0; i<this.getI();i++)
			for(int j=0; j<this.getJ();j++)
				original.matriz[i][j]=this.matriz[i][j];
		//Creo la matriz inversa y la cargo con los valores de la matriz identidad.
		Matriz inversa = new Matriz(original.getI(),original.getJ());
		if (original.getI()==original.getJ()){
			double auxiliar;
			for (int i=0; i<inversa.getI();i++){
				for (int j=0; j<inversa.getJ(); j++)
					if (i==j)
						inversa.agregar(i, j, 1);
					else
						inversa.agregar(i, j, 0);
			}
			//Convierto la matriz en triangular superior y al mismo tiempo
			//convierto en uno la diagonal.
			for (int i=0; (i<original.getI()-1); i++){
				//Compruebo si alguna linea es cero
				
				for (int k=0; k<original.getI();k++){
					boolean filaCero=true;
					for (int j=0; (j<original.getJ()&& filaCero);j++){
						if (original.matriz[k][j]!=0){
							filaCero=false;
						}
					}
					if (filaCero){
						throw new NoInversibleException();
					}
				}
				
				
				//Compruebo si el numero en la diagonal es cero
				//si es cero intercambio por una fila donde no lo sea.
				if (original.matriz[i][i]==0){
					int otraFila=0;
					double aux;
					for (int j=i+1; j<original.getI(); j++){
						if (original.matriz[i][i]!=0){
							otraFila=j;
							j=original.getI();
						}
					}
					for (int j=i; j<original.getJ();j++){
						aux=original.matriz[i][j];
						original.matriz[i][j]= original.matriz[otraFila][j];
						original.matriz[otraFila][j]= aux;
						aux=inversa.matriz[i][j];
						inversa.matriz[i][j]= inversa.matriz[otraFila][j];
						inversa.matriz[otraFila][j]= aux;
					}
				}
				
				
				//Compruebo si la diagonal es uno y si no divido toda la fila por el nÃºmero
				//en la diagonal
				if (original.matriz[i][i]!=1){
					auxiliar=original.matriz[i][i];
					for (int j=0; j<original.getJ(); j++){
						original.matriz[i][j]=original.matriz[i][j]/auxiliar;
						inversa.matriz[i][j]=inversa.matriz[i][j]/auxiliar;
					}
				}
				
				for (int k=i+1; k<original.getI();k++){
					auxiliar=original.matriz[k][i];
					for (int j=0; j<original.getJ(); j++){
						original.matriz[k][j]= original.matriz[k][j]-auxiliar*original.matriz[i][j];
						inversa.matriz[k][j]= inversa.matriz[k][j]-auxiliar*inversa.matriz[i][j];
					}
				}

			}
			boolean filaCero=true;
			for (int j=0; (j<original.getJ()&& filaCero);j++){
				if (original.matriz[original.getI()-1][j]!=0){
					filaCero=false;
				}
			}
			if (filaCero){
				throw new NoInversibleException();
			}
			if (original.matriz[original.getI()-1][original.getI()-1]!=1){
				auxiliar=original.matriz[original.getI()-1][original.getI()-1];
				for (int j=0; j<original.getJ(); j++){
					original.matriz[original.getI()-1][j]=original.matriz[original.getI()-1][j]/auxiliar;
					inversa.matriz[inversa.getI()-1][j]=inversa.matriz[inversa.getI()-1][j]/auxiliar;
				}
			}
			//Segunda parte.
			//A la matriz diagonal superior y con unos en la diagonal
			//la convierto en la identidad.
			for (int i=original.getI()-1; (i>0); i--){
				for (int k=i-1; k>=0;k--){
					auxiliar=original.matriz[k][i];
					for (int j=original.getJ()-1; j>=0; j--){
						original.matriz[k][j]= original.matriz[k][j]-auxiliar*original.matriz[i][j];
						inversa.matriz[k][j]= inversa.matriz[k][j]-auxiliar*inversa.matriz[i][j];
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
	
	public double determinante(){
		double determinante=1.0;
		double auxiliar1;
		double auxiliar2;
		Matriz original = new Matriz(this.getI(), this.getJ());
		
		for (int i=0; i<this.getI();i++)
			for(int j=0; j<this.getJ();j++)
				original.matriz[i][j]=this.matriz[i][j];
		
		if (original.getI()==original.getJ()){
			for (int i=0; (i<original.getI()-1); i++){
				//Compruebo si alguna linea es cero

				for (int k=0; k<original.getI();k++){
					boolean filaCero=true;
					for (int j=0; (j<original.getJ()&& filaCero);j++){
						if (original.matriz[k][j]!=0){
							filaCero=false;
						}
					}
					if (filaCero){
						return 0;
					}
				}

				auxiliar2=original.matriz[i][i];

				for (int k=i+1; k<original.getI();k++){
					auxiliar1=original.matriz[k][i]/auxiliar2;
					for (int j=0; j<original.getJ(); j++){
						original.matriz[k][j]= original.matriz[k][j]-auxiliar1*original.matriz[i][j];
					}
					

				}

			}
		}
		
		for (int i=0; i<original.getI();i++)
			determinante*=original.matriz[i][i];
		return determinante;
	}
	
	public Integer getI() {
		return this.i;
	}

	public void setI(Integer i) {
		this.i = i;
	}

	public Integer getJ() {
		return this.j;
	}

	public void setJ(Integer j) {
		this.j = j;
	}

	@Override
	public String toString() {
		String cadena=new String("");
		
		for (int i=0; i < this.i ;i++){
			cadena+="| ";
			for (int j=0; j<this.getJ();j++){
				cadena+= this.matriz[i][j]+" ";
			}
			cadena+="|\n";
		}
		return cadena;
	}
	
	
}
