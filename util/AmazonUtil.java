package com.playzif.util;

import java.util.Scanner;

public class AmazonUtil {
		
	public static int validateUserResponseMenu(int min, int max) {
			Scanner sc = new Scanner(System.in);

			while(!sc.hasNextInt()) {
				sc.next();
				System.out.println("No ingresaste una opción válida");
				System.out.println("Intenta otra vez1");
			}
			
			int response = sc.nextInt();
			
			while(response < min || response > max) {
				System.out.println("No ingresaste una opción válida");
				System.out.println("Intenta otra vez");
				
				while(!sc.hasNextInt()) {
					sc.next();
					System.out.println("No ingresaste una opción válida");
					System.out.println("Intenta otra vez");
				}
				response = sc.nextInt();
			}
			System.out.println("Tu Respuesta fue: " + response + "\n");
			return response;
		}
	}
