package dad.gsonSample;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {

	public static void main(String[] args) {

		// Variables necesarias para el funcionamiento del programa.
		Persona p = new Persona();
		int counter = 0;
		int i = 0;
		boolean itsNumber = false;

		// recoger datos desde la consola y almacenarlos en "p", asegurando que son el
		// tipo de dato requerido

		Scanner lectura = new Scanner(System.in);

		System.out.println("Escribe el nombre");
		p.setNombre(lectura.nextLine());

		do {
			if (Character.isLetter(p.getNombre().charAt(i))) {
				i++;
			} else {
				System.out.println("El nombre debe tener solo letras. Introduzca un nombre válido:");
				p.setNombre(lectura.nextLine());
				i = 0;
			}
		} while (i != p.getNombre().length());

		System.out.println("Escribe los apellidos");
		p.setApellidos(lectura.nextLine());
		i = 0;

		do {
			if (Character.isLetter(p.getApellidos().charAt(i)) || p.getApellidos().charAt(i) == ' ') {
				i++;
			} else {
				System.out.println("Los apellidos debe tener solo letras. Introduzca apellidos válidos:");
				p.setApellidos(lectura.nextLine());
				i = 0;
			}
		} while (i != p.getApellidos().length());

		System.out.println("Escribe la edad");

		do {
			try {
				p.setEdad(lectura.nextInt());
				itsNumber = true;
			} catch (InputMismatchException e) {
				System.out.println("Introduzca números, por favor : ");
				itsNumber = false;
				lectura.next();
			}
		} while (itsNumber == false);

		lectura.close();

		// Muestra en consola
		System.out.println("\nSalida normal :");
		System.out.println("Nombre: " + p.getNombre() + ", Apellidos: " + p.getApellidos() + ", Edad: " + p.getEdad());

		// Generamos la salida por consola usando Json
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(p);

		System.out.println("\nSalida por Json :");
		System.out.println(json);

	}

}
