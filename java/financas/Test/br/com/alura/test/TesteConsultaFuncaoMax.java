package br.com.alura.test;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.persistence.dao.ContaDAO;
import br.com.alura.financas.persistence.dao.MovimentacaoDAO;
import br.com.alura.financas.persistence.jpa.JPABase;

public class TesteConsultaFuncaoMax {

	public static void main(String[] args) {
		
		EntityManager entityManager = new JPABase().getEntityManagerFactory();
		
		ContaDAO contaDAO = new ContaDAO();
		MovimentacaoDAO movimentacaoDAO = new MovimentacaoDAO();
		Conta conta = contaDAO.findById(entityManager, 1);
		
		BigDecimal movimentacao = movimentacaoDAO.getValorMovimentacao(entityManager, conta);
		
		if(null != movimentacao){
			System.out.println("A maior mavimentação da conta com id " + conta.getId() + " e titular " + conta.getTitular() + " foi R$" + movimentacao);
		}
	}
}
