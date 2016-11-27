package br.com.empresa.iterators;

import java.util.Comparator;


public class OrdenaPorIdade implements Comparator<Funcionario>{

	@Override
	public int compare(Funcionario f1, Funcionario f2) {
		return Integer.compare(f1.getIdade(), f2.getIdade());
	}
}