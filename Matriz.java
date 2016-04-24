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
