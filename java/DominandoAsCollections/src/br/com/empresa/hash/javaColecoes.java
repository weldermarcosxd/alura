package br.com.empresa.hash;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

import br.com.empresa.collectionsrelations.Curso;
import br.com.empresa.modelset.Aluno;
import br.com.empresa.objects.Aula;

public class javaColecoes {
	public static void main(String[] args) {
		
		Aula a1 = new Aula("Revisitando as ArrayLists", 21);
		Aula a2 = new Aula("Listas de objetos", 20);
		Aula a3 = new Aula("Relacionamento de listas e objetos", 15);

		ArrayList<Aula> aulas = new ArrayList<>();

		aulas.add(a1);
		aulas.add(a2);
		aulas.add(a3);

		System.out.println(aulas);

		Collections.sort(aulas);

		System.out.println(aulas);

		Collections.sort(aulas, Comparator.comparing(Aula::getDuracao));
		
		System.out.println(aulas);
		
		aulas.sort(Comparator.comparing(Aula::getDuracao));
		
		Curso curso = new Curso("Java 8", "Paulo");
		aulas.forEach(aula -> {
			curso.addAulas(aula);
			curso.matricula(new Aluno("Joao " + aula.getNome() + " ", new Random().nextInt(10000)));
			curso.matricula(new Aluno("Maria " + aula.getNome() + " ", new Random().nextInt(10000)));
			curso.matricula(new Aluno("Jose " + aula.getNome() + " ", new Random().nextInt(10000)));
		});
		
		System.out.println(curso.getAlunos());;
		
		Boolean joseMatriculado = curso.estaMatriculado(new Aluno("Joao Revisitando as ArrayLists ", new Random().nextInt(10000)));
		System.out.println(joseMatriculado);
	}
}