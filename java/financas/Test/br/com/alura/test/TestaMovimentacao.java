package br.com.alura.test;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;

import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.modelo.Movimentacao;
import br.com.alura.financas.modelo.TipoMovimentacao;
import br.com.alura.financas.persistence.jpa.JPABase;

public class TestaMovimentacao {

	public static void main(String[] args) {
		
		 double inicio = System.currentTimeMillis();
		
		EntityManager entityManager = new JPABase().getEntityManagerFactory();

		String titular = "João da Silva";
		String numero = "00066656";
		String banco = "Banco Itaú";
		String agencia = "Formiga";
		Conta conta = new Conta(titular, numero, banco, agencia);
		
		BigDecimal valor = new BigDecimal(15236.00);
		String descricao = "Pagamento de Internet";
		Calendar date = GregorianCalendar.getInstance();
		TipoMovimentacao tipoMovimentacao = TipoMovimentacao.SAIDA;
		Movimentacao movimentacao = new Movimentacao(valor, tipoMovimentacao, date, descricao, conta);
		
		entityManager.getTransaction().begin();
		entityManager.persist(conta);
		entityManager.persist(movimentacao);
		entityManager.getTransaction().commit();
		entityManager.close();
		
		double fim = System.currentTimeMillis();
        System.out.println("Executado em: " + (fim - inicio)/1000 + "s");
	}
}