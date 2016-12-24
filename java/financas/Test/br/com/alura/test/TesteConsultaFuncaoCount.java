package br.com.alura.test;

import javax.persistence.EntityManager;

import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.persistence.dao.ContaDAO;
import br.com.alura.financas.persistence.dao.MovimentacaoDAO;
import br.com.alura.financas.persistence.jpa.JPABase;

public class TesteConsultaFuncaoCount {

	public static void main(String[] args) {
		
		EntityManager entityManager = new JPABase().getEntityManagerFactory();

		MovimentacaoDAO movimentacaoDAO = new MovimentacaoDAO();
		ContaDAO contaDAO = new ContaDAO();
		
		Conta conta = contaDAO.findById(entityManager, 1);
		Long movimentacoesConta = movimentacaoDAO.getMovimentacoesContaCount(entityManager, conta);
	
		if(null != movimentacoesConta){
			System.out.println("A conta com id " + conta.getId() + " e titular " + conta.getTitular() + " teve " + movimentacoesConta + " movimentações");
		}
	}
}
