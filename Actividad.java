package PruebasJava;

import java.util.Scanner;

public class actividad_E1_1 {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		String nombre;
		int fecha;
		int cuenta;
		int saldo = 0;
		int contingresos = 0;
		int contgastos = 0;
		int opcion;
		boolean seguir = true;
		int numero;
		int moneda;
		int eleccion;
		String ingresos = "";
		String gastos = "";
		
		
		System.out.println("Bienvenido al banco. \n"
				+ "Introduzca su nombre: \n"
				+ "Introduzca su fecha de nacimiento: \n"
				+ "Introduzca su número de cuenta: ");
		nombre = entrada.next();
		fecha = entrada.nextInt();
		cuenta = entrada.nextInt();
		
		while (seguir == true) {
			System.out.print("\nSaldo actual: " + saldo +"\n¿Qué desea hacer?:\n"
					+ "1. Datos de la cuenta. \n"
					+ "2. Ingresar. \n"
					+ "3. Retirar. \n"
					+ "4. Equivalencia de saldo. \n"
					+ "5. Cantidad de ingresos. \n"
					+ "6. Cantidad de gastos realizados. \n"
					+ "7. Salir \n"
					+ ">> ");
			opcion = entrada.nextInt();
			
			switch(opcion) {
			case 1:
				System.out.print("Datos de la cuenta: \n"
						+ "Nombre: " + nombre + "\n"
						+ "Fecha de nacimiento: " + fecha + "\n"
						+ "Número de cuenta: " + cuenta + "\n"
						+ "Saldo: " + saldo + "\n");
				break;
			case 2:
				do {
					System.out.print("¿Cuánto quiere ingresar? >> ");
					numero = entrada.nextInt();
					if(numero >= 0) {
						saldo = numero + saldo;
						ingresos = ingresos + "+" + numero + "\n";
						contingresos ++;
					}else {
						System.out.println("ERROR. Cantidad errónea, pruebe de nuevo.");
					}
					
				}while (numero <= 0);
				break;
			case 3:
				do {
				System.out.print("¿Cuánto quiere retirar? >> ");
				numero = entrada.nextInt();
				if(numero >= 0) {
				if(numero > saldo) {
					System.out.println("El saldo insuficiente. \n¿Desea continuar? \n1. Si \n2. No");
					eleccion = entrada.nextInt();
					if(eleccion == 1) {
						saldo = saldo - numero;
						gastos = gastos + "-" + numero + "\n";
						contgastos++;
					}else {
						System.out.println("No se ha realizado la retirada.");
					}
				}else{
					saldo = saldo - numero;
					gastos = gastos + "-" + numero + "\n";
					contgastos++;
				}
				}else {
					System.out.println("ERROR. Cantidad errónea, pruebe de nuevo.");
				}
				} while(numero <= 0);
				break;
			case 4:
				do {
				System.out.println("Elige una moneda: ");
				moneda = entrada.nextInt();
				if(moneda > 0 && moneda < 4) {
				if(moneda == 1) {
					System.out.print("Dólares: " + (saldo * 0.95));
				}
				if(moneda == 2) {
					System.out.print("Libras: " + (saldo * 1.15));
				}
				if(moneda == 3) {
					System.out.print("Yuanes: " + (saldo / 0.13));
				}
				}else {
					System.out.println("ERROR. Vuelve a intentarlo.");
				}
				}while(moneda <= 0 || moneda > 4);
				break;
			case 5:
				System.out.print("Cantidad de ingresos: " + contingresos + "\n" + ingresos);
				break;
			case 6:
				System.out.print("Cantidad de gastos: " + contgastos + "\n" + gastos);
				break;
			case 7:
				System.out.print("Hasta pronto!");
				seguir = false;
			default:
				System.out.print("ERROR. Opción no válida.");
			}
		}
	}

}
