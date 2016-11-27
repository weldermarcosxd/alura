package br.com.empresa.objects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TestaAulas {
	public static void main(String[] args) {
		
		Aula a1 = new Aula("Trabalhando com arrays", 15);
		Aula a2 = new Aula("Trabalhando com objetos", 14);
		Aula a3 = new Aula("Trabalhando com listas", 16);
		
		ArrayList<Aula> aulas = new ArrayList<Aula>();
		
		aulas.add(a1);
		aulas.add(a2);
		aulas.add(a3);
		
		System.out.println(aulas);
		
		Collections.sort(aulas);
		
		System.out.println(aulas);
		
		aulas.sort(Comparator.comparing(Aula::getDuracao));
		
		System.out.println(aulas);
		
	}
}
