package br.com.alura.maven;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ProdutoTest {
	
	@Test
	public void verificaPrecoComImposto(){
		Produto produto = new Produto("Chocolate", 1);
		assertEquals(produto.getPrecoComImposto(), 1.1, 0.000001);
	}
	
	@Test
	public void verificaConstrutor(){
		Produto produto = new Produto("Chocolate", 1);
		assertEquals(produto.getNome(), "Chocolate");
		assertEquals(produto.getPreco(), 1, 0.0000000000000000000000001);
	}

}
