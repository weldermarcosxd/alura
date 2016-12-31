package br.com.alura.test;

import java.util.List;
import javax.persistence.EntityManager;
import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.modelo.Movimentacao;
import br.com.alura.financas.persistence.dao.MovimentacaoDAO;
import br.com.alura.financas.persistence.jpa.JPABase;

public class TestaNamedQuery {
	
	public static void main(String[] args) {
		
		EntityManager entityManager = new JPABase().getEntityManagerFactory();
		Conta conta = new Conta();
		conta.setId(1);
		
		List<Movimentacao> movimentacoesConta = new MovimentacaoDAO().getMovimentacoesConta(entityManager, conta);
		for (Movimentacao movimentacao : movimentacoesConta) {
			System.out.println(movimentacao.getConta().getTitular());
			System.out.println(movimentacao.getTipoMovimentacao());
			System.out.println(movimentacao.getValor());
			System.out.println(" - ");
		}
	}

}