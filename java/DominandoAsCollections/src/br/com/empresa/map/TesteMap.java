package br.com.empresa.map;

import java.util.HashMap;
import java.util.Map;

public class TesteMap {

	public static void main(String[] args) {

		Map<String, Integer> nomesParaIdade = new HashMap<>();
		nomesParaIdade.put("Paulo", 31);
		nomesParaIdade.put("Adriano", 25);
		nomesParaIdade.put("Alberto", 33);
		nomesParaIdade.put("Guilherme", 26);
		
		nomesParaIdade.keySet().forEach(keys ->{
			System.out.println(keys);
		});
		
		nomesParaIdade.values().forEach(val -> {
			System.out.println(val);
		});
	}
}