package br.com.empresa.sets;

import java.util.HashSet;
import java.util.Set;

public class ImprimindoAlunosSemAcentos {
	public static void main(String[] args) {

		Set<String> alunos = new HashSet<>();
		alunos.add("Paulo");
		alunos.add("Alberto");
		alunos.add("Pedro");
		alunos.add("Nico");

		System.out.println(alunos.size());

		alunos.add("Nico");
		
		System.out.println(alunos.size());

		alunos.forEach(aluno -> {
			System.out.println(aluno);
		});

	}
}
