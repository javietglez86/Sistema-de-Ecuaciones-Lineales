package ar.edu.uno.poo2.modulo;
import java.io.*;

public class Main {


	public static void main (String[] args) throws MissMatchDimensionException{
		Vector vector= new Vector(3);
		Vector vector1= new Vector(3);
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

		// lectura de archivo
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;

		try {
			// Apertura del fichero y creacion de BufferedReader para poder
			// hacer una lectura comoda (disponer del metodo readLine()).
			archivo = new File ("/home/leoblau/archivo.txt");
			fr = new FileReader (archivo);
			br = new BufferedReader(fr);

			// Lectura del fichero
			String linea;
			while((linea=br.readLine())!=null)
				System.out.println(linea);
		}
		catch(Exception e){
			e.printStackTrace();
		}finally{
			// En el finally cerramos el fichero, para asegurarnos
			// que se cierra tanto si todo va bien como si salta 
			// una excepcion.
			try{                    
				if( null != fr ){   
					fr.close();     
				}                  
			}catch (Exception e2){ 
				e2.printStackTrace();
			}
		}
	}
}
