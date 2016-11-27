package br.com.empresa.collections;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Banco {
	private List<ContaPoupanca> listContaPoupanca;
	private Map<String, Conta> map = new HashMap<String, Conta>();
	
	public void addConta(ContaPoupanca contaPoupanca){
		this.listContaPoupanca.add(contaPoupanca);
		map.put(contaPoupanca.getNome(), contaPoupanca);
	}
	
	public Conta findByName(String nome){
		return map.get(nome);
	}
	
	public Conta pegaConta(int i){
		return this.listContaPoupanca.get(i);
	}
	
	public int pegaQuantidadeDeContas(){
		return this.listContaPoupanca.size();
	}

	public List<ContaPoupanca> getListContaPoupanca() {
		return listContaPoupanca;
	}

	public void setListContaPoupanca(List<ContaPoupanca> listContaPoupanca) {
		this.listContaPoupanca = listContaPoupanca;
	}
}
