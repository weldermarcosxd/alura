package br.com.empresa.morerelations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import br.com.empresa.collectionsrelations.Curso;
import br.com.empresa.objects.Aula;

public class TestaCurso2 {
	public static void main(String[] args) {
		Curso curso = new Curso("Trabalhando com coleções no java","Paulo do Alura");

		curso.addAulas(new Aula("Aula 1: Arrays", 21));
		curso.addAulas(new Aula("Aula 2: Objects", 20));
		curso.addAulas(new Aula("Aula 3: Lists", 19));
		curso.addAulas(new Aula("Aula 4: Encapsulamento", 24));
		curso.addAulas(new Aula("Aula 5: Threads", 15));

		List<Aula> aulas = new ArrayList<Aula>(curso.getAulas());

		Collections.sort(aulas);

		System.out.println(aulas);
		System.out.println("Duração do curso " + curso.getNome() + ": " + curso.getDuracaoTotal());
	
		System.out.println(curso);
	}
}
