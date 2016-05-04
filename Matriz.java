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
		Matriz original = new Matriz(this.getI(), this.getJ());
		for (int i=0; i<this.getI();i++)
			for(int j=0; j<this.getJ();j++)
				original.matriz[i][j]=this.matriz[i][j];
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
			for (int i=0; (i<original.getI()-1); i++){

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
			if (original.matriz[original.getI()-1][original.getI()-1]!=1){
				auxiliar=original.matriz[original.getI()-1][original.getI()-1];
				for (int j=0; j<original.getJ(); j++){
					original.matriz[original.getI()-1][j]=original.matriz[original.getI()-1][j]/auxiliar;
					inversa.matriz[inversa.getI()-1][j]=inversa.matriz[inversa.getI()-1][j]/auxiliar;
				}
			}
			//Segunda parte.
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
