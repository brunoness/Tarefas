package br.com.bruno;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Classe1 {

	public static void main(String[] args) {
		System.out.println("**********LISTAS**********");
		System.out.println("Tarefa 1");
		tarefa1();
		System.out.println("Tarefa 2");
		tarefa2();

	}
	
	public static void tarefa1() {
		
		List<String> lista = new ArrayList<String>();
		lista.add("Manuela Santos");
		lista.add("Jacqueline Oliveira");
		lista.add("Bruno Correia");
		lista.add("Adriana Souza");
		lista.add("Lucas Yuri");
		System.out.println("Lista desordenada:" + lista);
		
		Collections.sort(lista);
		System.out.println("Lista ordenada:" + lista);
		
	}
	
	public static void tarefa2() {
		
		List<String> lista2 = new ArrayList<String>();
		lista2.add("Manuela - feminino");
		lista2.add("Jacqueline - feminino");
		lista2.add("Bruno - masculino");
		lista2.add("Adriana - feminino");
		lista2.add("Lucas - masculino");
		System.out.println("Lista desordenada:" + lista2);
		
		Collections.sort(lista2, new Comparator<String>() {
	        public int compare(String o1, String o2) {
	
	            String genero1 = o1.split(" - ")[1];
	            String genero2 = o2.split(" - ")[1];
	
	            // Ordena primeiro por genero
	            int generoComparacao = genero1.compareTo(genero2);
	            if (generoComparacao != 0) {
	                return generoComparacao; 
	            }
	            //com mesmo genero, ordena por nome
	            String nome1 = o1.split(" - ")[0];
	            String nome2 = o2.split(" - ")[0];
	            return nome1.compareTo(nome2);
	        }
		});

        System.out.println("Lista ordenada: " + lista2);
		
	}

}
