package br.com.empresa.modelset;

import java.util.Random;

import br.com.empresa.collectionsrelations.Curso;
import br.com.empresa.objects.Aula;

public class TesteMatricula {
	public static void main(String[] args) {
		
		Curso curso = new Curso("Jaguar 7", "Mauren");
		
		curso.addAulas(new Aula("Angular", 1000));
		curso.addAulas(new Aula("Hibernate", 1000));
		curso.addAulas(new Aula("Java", 1000));
		curso.addAulas(new Aula("Framework", 100000000));
		
		curso.matricula(new Aluno("Rafael", new Random().nextInt()));
		curso.matricula(new Aluno("Welder", new Random().nextInt()));
		curso.matricula(new Aluno("Joice", new Random().nextInt()));
		curso.matricula(new Aluno("Leandro", new Random().nextInt()));
		curso.matricula(new Aluno("Chrystian", new Random().nextInt()));
		
	}
}