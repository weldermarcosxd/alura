package br.com.empresa.collectionsrelations;

import br.com.empresa.objects.Aula;

public class TestaCurso {
	public static void main(String[] args) {
		Curso curso = new Curso("Trabalhando com coleções no java", "Paulo do Alura");
		System.out.println(curso.getAulas());
		
		curso.addAulas(new Aula("Aula 1: Arrays", 21));
		curso.addAulas(new Aula("Aula 2: Objects", 20));
		curso.addAulas(new Aula("Aula 3: Lists", 19));
		curso.addAulas(new Aula("Aula 4: Encapsulamento", 24));
		curso.addAulas(new Aula("Aula 5: Threads", 15));
		
		System.out.println(curso.getAulas());
	}
}
