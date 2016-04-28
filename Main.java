package ar.edu.uno.poo2.modulo;
import java.io.*;

public class Main {


	public static void main (String[] args) throws MissMatchDimensionException{
		Vector vector= new Vector(3);
		Vector vector1= new Vector(3);
		Vector vector2=new Vector(3);
		vector.agregar(1.2);
		vector.agregar(5.7);
		vector.agregar(9.0);
		vector1.agregar(7.3);
		vector1.agregar(4.6);
		vector1.agregar(13.8);
		if (!vector.agregar(1.2))
			System.out.println("Error");
		System.out.println(vector.toString());
		System.out.println(vector1.toString());
		vector.sumar(vector1);
		System.out.println(vector.toString());
		vector.restar(vector1);
		System.out.println(vector.toString());
		
		
		Matriz matriz = new Matriz(3, 3);
		Matriz matriz2 = new Matriz(3,3);
		Matriz matriz3 = new Matriz(3,3);
		Matriz matriz4 = new Matriz(2,2);
		Matriz matriz5 = new Matriz(2,2);
		Matriz matriz6 = new Matriz(2,2);
		
		Matriz matriz7 = new Matriz(3,2);
		Matriz matriz8 = new Matriz(2,3);
		
		
		matriz.agregar(0, 0, 1.0);
		matriz.agregar(0, 1, 2.0);
		matriz.agregar(0, 2, 2.0);
		matriz.agregar(1, 0, 3.0);
		matriz.agregar(1, 1, 1.0);
		matriz.agregar(1, 2, 1.0);
		matriz.agregar(2, 0, 3.0);
		matriz.agregar(2, 1, 1.0);
		matriz.agregar(2, 2, 1.0);
		
		matriz2.agregar(0, 0, 1.0);
		matriz2.agregar(0, 1, 1.0);
		matriz2.agregar(0, 2, 2.0);
		matriz2.agregar(1, 0, 2.0);
		matriz2.agregar(1, 1, 3.0);
		matriz2.agregar(1, 2, 1.0);
		matriz2.agregar(2, 0, 3.0);
		matriz2.agregar(2, 1, 1.0);
		matriz2.agregar(2, 2, 1.0);
		
		matriz4.agregar(0, 0, 1.0);
		matriz4.agregar(0, 1, 1.0);
		matriz4.agregar(1, 0, 2.0);
		matriz4.agregar(1, 1, 3.0);
		
		matriz5.agregar(0, 0, 1.0);
		matriz5.agregar(0, 1, 1.0);
		matriz5.agregar(1, 0, 2.0);
		matriz5.agregar(1, 1, 3.0);

		matriz7.agregar(0, 0, 1.0);
		matriz7.agregar(0, 1, 1.0);
		matriz7.agregar(1, 0, 0.0);
		matriz7.agregar(1, 1, -1.0);
		matriz7.agregar(2, 0, 2.0);
		matriz7.agregar(2, 1, -2.0);
		
		matriz8.agregar(0, 0, 1.0);
		matriz8.agregar(0, 1, 3.0);
		matriz8.agregar(0, 2, 2.0);
		matriz8.agregar(1, 0, 1.0);
		matriz8.agregar(1, 1, -1.0);
		matriz8.agregar(1, 2, 1.0);


		
		System.out.println(matriz.toString());
		
		System.out.println(matriz2.toString());
		
		matriz3 = matriz.producto(matriz2);	
		System.out.println(matriz3.toString());
		
		matriz6 = matriz4.producto(matriz5);
		System.out.println(matriz6.matrizInversa().toString());
		
		matriz6 = matriz2.producto(matriz5);
		System.out.println(vector.productoEscalar(vector1));
		Matriz matriz9 = matriz8.producto(matriz7);
		System.out.println(matriz9.toString());
		
		System.out.println(matriz2.normaF());
//		System.out.println(matriz9.normaDos());
//		
//		System.out.println(matriz9.producto(2.0).toString());
//		
//		System.out.println(matriz9.equals(matriz9));
//		System.out.println(matriz9.equals(matriz9));
	}
}
