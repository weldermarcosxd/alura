package br.com.empresa.objects;

public class Aula implements Comparable<Aula>{
	private String nome;
	private int duracao;
	
	public Aula(String nome, int duracao) {
		this.nome = nome;
		this.duracao = duracao;
	}
	
	@Override
	public String toString() {
		return "Nome: " + this.getNome() + " Duração: " + this.getDuracao();
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	@Override
	public int compareTo(Aula aula) {
		return this.getNome().compareTo(aula.getNome());
	}
}