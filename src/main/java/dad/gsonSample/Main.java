package dad.gsonSample;

import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {

	public static void main(String[] args) {

		Persona p = new Persona();

		// recoger datos desde la consola y almacenarlos en "p", asegurando que son el
		// tipo de dato requerido

		Scanner lectura = new Scanner(System.in);
		do {
			System.out.println("Escribe el nombre");
			p.setNombre(lectura.nextLine());

		} while (p.getNombre().isBlank());

		System.out.println("Escribe los apellidos");
		p.setApellidos(lectura.nextLine());

		System.out.println("Escribe la edad");
		p.setEdad(lectura.nextInt());

		// Muestra en consola a través de la salida 'Print'
		System.out.println("Salida normal :");
		System.out.println("Nombre: " + p.getNombre() + ", Apellidos: " + p.getApellidos() + ", Edad: " + p.getEdad());

		// Generamos la salida por consola usando Json
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(p);

		System.out.println("\n\n Salida por Json :");
		System.out.println(json);

	}

}
