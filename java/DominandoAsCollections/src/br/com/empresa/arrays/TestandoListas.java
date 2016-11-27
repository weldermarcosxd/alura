package br.com.empresa.arrays;

import java.util.ArrayList;
import java.util.Collections;

public class TestandoListas {
	public static void main(String[] args) {
		String curso1 = "Java 1";
		String curso2 = "Java 2";
		String curso3 = "Java 3";
		
		ArrayList<String> cursos = new ArrayList<String>();
		
		cursos.add(curso1);
		cursos.add(curso2);
		cursos.add(curso3);
		
		cursos.remove(1);
		
		cursos.forEach(curso -> {
			System.out.println("Curso: " + curso.toString());
		});
		
		System.out.println("Primeiro curso: " + cursos.get(0).toString());
		
		Collections.sort(cursos);
	}
}