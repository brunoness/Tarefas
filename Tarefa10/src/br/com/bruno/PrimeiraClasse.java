package br.com.bruno;

import java.util.Scanner;

public class PrimeiraClasse {

	public static void main(String[] args) {
		
		Scanner t = new Scanner(System.in);
		System.out.println("Digite sua primeira nota: ");
		float nota1 = t.nextFloat();
		while(nota1 >10) {
			Scanner t1 = new Scanner(System.in);
			System.out.println("Nota máxima permitida é 10. Digite sua primeira nota: ");
			nota1 = t1.nextFloat();
		}
		
		Scanner u = new Scanner(System.in);
		System.out.println("Digite sua segunda nota: ");
		float nota2 = u.nextFloat();
		while(nota2 >10) {
			Scanner u1 = new Scanner(System.in);
			System.out.println("Nota máxima permitida é 10. Digite sua segunda nota: ");
			nota2 = u1.nextFloat();
		}
		
		Scanner v = new Scanner(System.in);
		System.out.println("Digite sua terceita nota: ");
		float nota3 = v.nextFloat();
		while(nota3 >10) {
			Scanner v1 = new Scanner(System.in);
			System.out.println("Nota máxima permitida é 10. Digite sua terceira nota: ");
			nota3 = v1.nextFloat();
		}
		
		Scanner q = new Scanner(System.in);
		System.out.println("Digite sua quarta nota: ");
		float nota4 = q.nextFloat();
		while(nota4 >10) {
			Scanner q1 = new Scanner(System.in);
			System.out.println("Nota máxima permitida é 10. Digite sua quarta nota: ");
			nota4 = q1.nextFloat();
		}
		
		
		float media = (nota1+nota2+nota3+nota4)/4;
		
		String resultado = calculaMedia(media);
		System.out.println("Sua média é " + media);
		System.out.println(resultado);	
		
	}
	
	public static String calculaMedia(float media ) {
		
		if (media >=7) {
			return "Você está aprovado!";
		} else if(media >=5) {
			return "Você está de recuperação!";
		} else {
			return "Você está reprovado!";
		}
	}

}