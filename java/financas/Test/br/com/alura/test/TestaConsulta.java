package br.com.alura.test;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.modelo.Movimentacao;
import br.com.alura.financas.modelo.TipoMovimentacao;
import br.com.alura.financas.persistence.jpa.JPABase;

public class TestaConsulta {

	public static void main(String[] args) {

		Conta conta = new Conta();
		conta.setId(2);

		EntityManager entityManager = new JPABase().getEntityManagerFactory();
		TypedQuery<Movimentacao> query = entityManager.createQuery("from Movimentacao " + " where conta = :conta" + " and tipoMovimentacao = :tipoMovimentacao"
				+ " order by valor desc", Movimentacao.class);

		query.setParameter("conta", conta);
		query.setParameter("tipoMovimentacao", TipoMovimentacao.SAIDA);

		List<Movimentacao> movimentacaoList = query.getResultList();

		if (null != movimentacaoList && movimentacaoList.size() > 0) {
			for (Movimentacao movimentacao : movimentacaoList) {
				System.out.println("\nTitular ....: " + movimentacao.getConta().getTitular());
				System.out.println("Descricao ..: " + movimentacao.getDescricao());
				System.out.println("Valor ......: R$ " + movimentacao.getValor());
			}
		}
	}
}
