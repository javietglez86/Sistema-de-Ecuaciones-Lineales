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
	
	public Matriz matrizInversa(){
		Matriz inversa = new Matriz(this.getI(),this.getJ());
		if (this.getI()==this.getJ()){
			double auxiliar;
			for (int i=0; i<inversa.getI();i++){
				for (int j=0; j<inversa.getJ(); j++)
					if (i==j)
						inversa.agregar(i, j, 1);
					else
						inversa.agregar(i, j, 0);
			}
			for (int i=0; (i<this.getI()-1); i++){

				if (this.matriz[i][i]!=1){
					auxiliar=this.matriz[i][i];
					for (int j=0; j<this.getJ(); j++){
						this.matriz[i][j]=this.matriz[i][j]/auxiliar;
						inversa.matriz[i][j]=inversa.matriz[i][j]/auxiliar;
					}
				}
				
				for (int k=i+1; k<this.getI();k++){
					auxiliar=this.matriz[k][i];
					for (int j=0; j<this.getJ(); j++){
						this.matriz[k][j]= this.matriz[k][j]-auxiliar*this.matriz[i][j];
						inversa.matriz[k][j]= inversa.matriz[k][j]-auxiliar*inversa.matriz[i][j];
					}
				}

			}
			if (this.matriz[this.getI()-1][this.getI()-1]!=1){
				auxiliar=this.matriz[this.getI()-1][this.getI()-1];
				for (int j=0; j<this.getJ(); j++){
					this.matriz[this.getI()-1][j]=this.matriz[this.getI()-1][j]/auxiliar;
					inversa.matriz[inversa.getI()-1][j]=inversa.matriz[inversa.getI()-1][j]/auxiliar;
				}
			}
			//Segunda parte.
			for (int i=this.getI()-1; (i>0); i--){
				for (int k=i-1; k>=0;k--){
					auxiliar=this.matriz[k][i];
					for (int j=this.getJ()-1; j>=0; j--){
						this.matriz[k][j]= this.matriz[k][j]-auxiliar*this.matriz[i][j];
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
