package br.com.bruno;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class classe1 {

	public static void main(String[] args) {
		listaComMap();
		

	}
	
	private static void listaComMap() {
		System.out.println("Lista com MAP");
		Map<Integer, String> lista = new HashMap<>();
		lista.put(1, "Bruno - Masculino");
		lista.put(2, "Manuela - Feminino");
		lista.put(3, "Lucas - Masculino");
		lista.put(5, "Jacqueline - Feminino");
		lista.put(4, "Adriana - Feminino");
		
		System.out.println(lista);
        System.out.println(" ");
		
		//teste com o ForEach
		System.out.println("Imprimindo com forEach");
		lista.forEach((key, value) -> System.out.println(key + " " + value));
		
		// trabalhando com outras funções de MAP's
        LinkedHashMap<Integer, String> ordem = lista.entrySet()
                .stream()
                .sorted((e1, e2) -> e1.getValue().contains("- Feminino") ? -1 : e2.getValue().contains("- Feminino") ? 1 : 0)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new
                ));

        System.out.println(" ");
        System.out.println("Lista Ordenada");
        ordem.values().stream().forEach( System.out::println);
		;
	}

}
