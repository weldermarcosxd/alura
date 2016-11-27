package br.com.empresa.collectionsrelations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import br.com.empresa.modelset.Aluno;
import br.com.empresa.objects.Aula;

public class Curso {

	private String nome;
	private String instrutor;
	private List<Aula> aulas = new ArrayList<Aula>();
	private Set<Aluno> alunos = new HashSet<Aluno>();
	private Map<Integer, Aluno> matriculaParaAluno = new HashMap<Integer, Aluno>();

	public Curso(String nome, String instrutor) {
		super();
		this.nome = nome;
		this.instrutor = instrutor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getInstrutor() {
		return instrutor;
	}

	public void setInstrutor(String instrutor) {
		this.instrutor = instrutor;
	}

	public List<Aula> getAulas() {
		return Collections.unmodifiableList(aulas);
	}

	public void setAulas(List<Aula> aulas) {
		this.aulas = aulas;
	}
	
	public void addAulas(Aula aula) {
		this.aulas.add(aula);
	}
	
	public int getDuracaoTotal(){
		return this.aulas.stream().mapToInt(Aula::getDuracao).sum();
	}
	
	@Override
	public String toString() {
		return "Nome: " + this.getNome() + " Duração: " + this.getDuracaoTotal() + " Número de Aulas: " + this.getAulas().size();
	}

	public void matricula(Aluno aluno) {
		this.alunos.add(aluno);
		this.matriculaParaAluno.put(aluno.getMatricula(), aluno);
	}

	public Set<Aluno> getAlunos() {
		return Collections.unmodifiableSet(this.alunos);
	}
	
	public boolean estaMatriculado(Aluno aluno){
		return this.alunos.contains(aluno);
	}
	
	public Aluno buscamatriculado(int matricula){
		if(this.matriculaParaAluno.containsKey(matriculaParaAluno)){
			throw new NoSuchElementException("Matricula não encontrada");
		}else{
			return this.matriculaParaAluno.get(matriculaParaAluno);
		}
	}
}