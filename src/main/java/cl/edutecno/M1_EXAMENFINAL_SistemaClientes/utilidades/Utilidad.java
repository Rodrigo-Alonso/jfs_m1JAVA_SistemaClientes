package cl.edutecno.M1_EXAMENFINAL_SistemaClientes.utilidades;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utilidad {
	static Scanner scS = new Scanner(System.in);

	// Metodos
	public void tiempoEspera() {

		System.out.println("");
		System.out.print("Abadonando el Sistema de Clientes");

		try {
			System.out.print(".");
			TimeUnit.SECONDS.sleep(1);
			System.out.print(".");
			TimeUnit.SECONDS.sleep(1);
			System.out.print(".");
			TimeUnit.SECONDS.sleep(1);
			System.out.print(".\n");
			TimeUnit.SECONDS.sleep(1);
			System.out.println("Acaba de salir del sistema");
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO: handle exception
			System.out.println("Error de ejecucion de tiempo: " + e.getMessage());
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error no identificado: " + e.getMessage());
		}

	}

	public void limpiezaPantalla() {
		for (int i = 0; i < 200; i++) {
			System.out.println("");
		}
		System.exit(0);
	}

	public boolean comprobarFichero(File fichero) {

		boolean crear = false;
		boolean condicion = true;
		String respuesta = " ";

		try {
			if (fichero.exists() != true) {
				crear = true;
			} else {
				System.out.print("El archivo notas.txt ya existe, ¿Desea sobreescibirlo? [s/n]: ");
				respuesta = scS.nextLine();
				while (condicion) {
					if (respuesta.equalsIgnoreCase("s")) {
						crear = true;
						condicion = false;
					} else if (respuesta.equalsIgnoreCase("n")) {
						System.out.println("No se sobreescribira el archivo");
						crear = false;
						condicion = false;
					} else {
						System.out.println("Opcion invalida");
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Ha ocurrido un error al crear el archivo - " + e.getMessage());
		}
		return crear;
	}

	/*** Validación de RUT Chileno***/
	/****
	 * Valida rut de la forma XXXXXXXX-X
	 */
	public static Boolean validaRut(String rut) {
		rut = rut.replace(".", "");
		Pattern pattern = Pattern.compile("^[0-9]+-[0-9kK]{1}$");
		Matcher matcher = pattern.matcher(rut);
		if (matcher.matches() == false)
			return false;
		String[] stringRut = rut.split("-");
		return stringRut[1].toLowerCase().equals(dv(stringRut[0]));
	}

	/*** Valida el dígito verificador ***/
	public static String dv(String rut) {
		Integer M = 0, S = 1, T = Integer.parseInt(rut);
		for (; T != 0; T = (int) Math.floor(T /= 10))
			S = (S + T % 10 * (9 - M++ % 6)) % 11;
		return (S > 0) ? String.valueOf(S - 1) : "k";

	}

}
