package br.com.caelum.empresa;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Test;

import br.com.caelum.empresa.modelo.Funcionario;
import br.com.caelum.empresa.modelo.Gasto;

public class FiltradorDeGastosEspeciaisTest {

	@Test
	public void test() {
		Funcionario funcionario = new Funcionario("João", 1254,
				new GregorianCalendar(1999, 12, 10));
		Gasto g1 = new Gasto(150, "Comida", funcionario, Calendar.getInstance());
		Gasto g2 = new Gasto(22, "Dormida", funcionario, Calendar.getInstance());
		Gasto g3 = new Gasto(10, "Bebida", funcionario, Calendar.getInstance());
		List<Gasto> lista = Arrays.asList(g1, g2, g3);
		
		FiltradorDeGastosEspeciais filtrador = new FiltradorDeGastosEspeciais(
				25.0);
		List<Gasto> gastosGrandes = filtrador.filtraGastosGrandes(lista);

		assertEquals(1, gastosGrandes.size());
		assertEquals(150.0, gastosGrandes.get(0).getValor(), 0.00001);
	}

}