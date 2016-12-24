package br.com.alura.financas.persistence.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.modelo.Movimentacao;
import br.com.alura.financas.modelo.TipoMovimentacao;

public class MovimentacaoDAO {

	public List<Movimentacao> getMovimentacoesConta(EntityManager entityManager, Conta conta){
		
		TypedQuery<Movimentacao> query = entityManager.createNamedQuery("getMovimentacoesConta", Movimentacao.class);
		query.setParameter("conta", conta);
		
		List<Movimentacao> resultList = query.getResultList();
		
		if(null != resultList && resultList.size() > 0){
			return resultList;
		}else{
			return null;
		}
	}
	
	public List<Movimentacao> getMovimentacoesTipo(EntityManager entityManager, TipoMovimentacao tipoMovimentacao){
		TypedQuery<Movimentacao> query = entityManager.createNamedQuery("getMovimentacoesTipo", Movimentacao.class);
		query.setParameter("tipoMovimentacao", tipoMovimentacao);
		
		List<Movimentacao> resultList = query.getResultList();
		
		if(null != resultList && resultList.size() > 0){
			return resultList;
		}else{
			return null;
		}
	}
	
	public Long getMovimentacoesContaCount(EntityManager entityManager, Conta conta){
		
		TypedQuery<Long> query = entityManager.createNamedQuery("getMovimentacoesContaCount", Long.class);
		query.setParameter("conta", conta);
		
		Long count = query.getSingleResult();
		
		if(null != count && count > 0){
			return count;
		}else{
			return null;
		}
	}
	
	public BigDecimal getValorMovimentacao(EntityManager entityManager, Conta conta){
		
		TypedQuery<BigDecimal> query = entityManager.createNamedQuery("getValorMovimentacao", BigDecimal.class);
		query.setParameter("conta", conta);
		
		BigDecimal maxValue = query.getSingleResult();
		
		if(null != maxValue){
			return maxValue;
		}else{
			return null;
		}
	}
}
